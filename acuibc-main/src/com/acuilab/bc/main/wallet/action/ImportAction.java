package com.acuilab.bc.main.wallet.action;

import com.acuilab.bc.main.BlockChain;
import com.acuilab.bc.main.dao.WalletDAO;
import com.acuilab.bc.main.manager.BlockChainManager;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import com.acuilab.bc.main.wallet.Wallet;
import com.acuilab.bc.main.wallet.WalletListTopComponent;
import com.acuilab.bc.main.wallet.wizard.MnemonicInputWizardPanel;
import com.acuilab.bc.main.wallet.wizard.NameCoinWizardPanel;
import com.acuilab.bc.main.wallet.wizard.PasswordWizardPanel;
import java.awt.Component;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import org.apache.commons.lang3.StringUtils;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;
import org.openide.util.Exceptions;
import org.openide.windows.WindowManager;

/**
 *
 * @author admin
 */
public class ImportAction extends AbstractAction {
    
    public ImportAction() {
        putValue(NAME, "导入钱包");
        putValue(SMALL_ICON, new javax.swing.ImageIcon(getClass().getResource("/resource/import_wallet32.png")));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            List<WizardDescriptor.Panel<WizardDescriptor>> panels = new ArrayList<>();
            panels.add(new NameCoinWizardPanel());
            panels.add(new PasswordWizardPanel());
            panels.add(new MnemonicInputWizardPanel());
            String[] steps = new String[panels.size()];
            for (int i = 0; i < panels.size(); i++) {
                Component c = panels.get(i).getComponent();
                // Default step name to component name of panel.
                steps[i] = c.getName();
                if (c instanceof JComponent) { // assume Swing components
                    JComponent jc = (JComponent) c;
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                    jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, true);
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, true);
                    jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, true);
                }
            }
            WizardDescriptor wiz = new WizardDescriptor(new WizardDescriptor.ArrayIterator<>(panels));
            // {0} will be replaced by WizardDesriptor.Panel.getComponent().getName()
            wiz.setTitleFormat(new MessageFormat("{0}"));
            wiz.setTitle("导入钱包");
            if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
                // TODO: 
                String pwd = (String)wiz.getProperty("password");
                String walletName = (String)wiz.getProperty("walletName");
                String coinSymbal = (String)wiz.getProperty("coinSymbal");
                String importType = (String)wiz.getProperty("importType");
                String mnemonicOrPrivate = StringUtils.trim((String)wiz.getProperty("mnemonicOrPrivate"));    // 助记词或私钥

                WalletListTopComponent tc = (WalletListTopComponent)WindowManager.getDefault().findTopComponent("WalletListTopComponent");
                BlockChain blockChain = BlockChainManager.getDefault().getBlockChain(coinSymbal);
                if(StringUtils.equals(importType, "助记词")) {
                    // 保存钱包到数据库
                    Wallet wallet = blockChain.importWalletByMnemonic(walletName, pwd, mnemonicOrPrivate);
                    WalletDAO.insert(wallet);
                    
                    tc.addWallet(wallet);
                } else {
                    Wallet wallet = blockChain.importWalletByPrivateKey(walletName, pwd, mnemonicOrPrivate);
                    WalletDAO.insert(wallet);
                
                    tc.addWallet(wallet);
                }

            }
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
