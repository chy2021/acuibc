package com.acuilab.bc.main.wallet;

import com.acuilab.bc.main.BlockChain;
import com.acuilab.bc.main.manager.BlockChainManager;
import com.acuilab.bc.main.manager.CoinManager;
import com.acuilab.bc.main.util.AESUtil;
import com.acuilab.bc.main.wallet.wizard.TransferInputWizardPanel;
import com.acuilab.bc.main.wallet.wizard.PasswordInputWizardPanel;
import com.acuilab.bc.main.wallet.wizard.TransferConfirmWizardPanel;
import java.awt.Component;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jdesktop.swingx.JXPanel;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author admin
 */
public class WalletPanel extends JXPanel {
    
    private final Wallet wallet;
    private final Coin baseCoin;
    
    private String walletTopComponentId;
    
    /**
     * Creates new form WalletPanel
     * @param wallet
     */
    public WalletPanel(Wallet wallet) {
        initComponents();
        
        BlockChain bc = BlockChainManager.getDefault().getBlockChain(wallet.getBlockChainSymbol());
        walletIconFld.setIcon(bc.getIcon(64));
        
        walletNameFld.setText(wallet.getName());
        walletAddressFld.setText(wallet.getAddress());
        
        // 获得余额
        baseCoin = CoinManager.getDefault().getBaseCoin(wallet.getBlockChainSymbol());
        BigInteger balance = baseCoin.balanceOf(wallet.getAddress());
        balanceFld.setText(baseCoin.minUnit2MainUint(balance).setScale(baseCoin.getMainUnitScale(), RoundingMode.HALF_DOWN).toPlainString() + " " + baseCoin.getMainUnit());
        
        this.wallet = wallet;
        this.walletTopComponentId = null;
    }

    public String getWalletTopComponentId() {
        return walletTopComponentId;
    }

    public void setWalletTopComponentId(String walletTopComponentId) {
        this.walletTopComponentId = walletTopComponentId;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        walletIconFld = new org.jdesktop.swingx.JXLabel();
        balanceFld = new org.jdesktop.swingx.JXLabel();
        walletAddressFld = new org.jdesktop.swingx.JXTextField();
        walletNameFld = new org.jdesktop.swingx.JXTextField();
        receivingBtn = new org.jdesktop.swingx.JXButton();
        transferBtn = new org.jdesktop.swingx.JXButton();
        refreshBtn = new org.jdesktop.swingx.JXButton();
        openBtn = new org.jdesktop.swingx.JXButton();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setMinimumSize(new java.awt.Dimension(360, 123));
        setPreferredSize(new java.awt.Dimension(360, 123));

        org.openide.awt.Mnemonics.setLocalizedText(walletIconFld, org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.walletIconFld.text")); // NOI18N
        walletIconFld.setPreferredSize(new java.awt.Dimension(64, 64));

        balanceFld.setForeground(new java.awt.Color(0, 0, 255));
        balanceFld.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.openide.awt.Mnemonics.setLocalizedText(balanceFld, org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.balanceFld.text")); // NOI18N
        balanceFld.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N

        walletAddressFld.setEditable(false);
        walletAddressFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        walletAddressFld.setForeground(new java.awt.Color(0, 0, 255));
        walletAddressFld.setText(org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.walletAddressFld.text")); // NOI18N
        walletAddressFld.setFont(new java.awt.Font("宋体", 1, 18)); // NOI18N

        walletNameFld.setEditable(false);
        walletNameFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        walletNameFld.setForeground(new java.awt.Color(0, 0, 255));
        walletNameFld.setText(org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.walletNameFld.text")); // NOI18N
        walletNameFld.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(receivingBtn, org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.receivingBtn.text")); // NOI18N
        receivingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivingBtnActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(transferBtn, org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.transferBtn.text")); // NOI18N
        transferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferBtnActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(refreshBtn, org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.refreshBtn.text")); // NOI18N
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(openBtn, org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.openBtn.text")); // NOI18N
        openBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(transferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receivingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balanceFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(walletIconFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(walletAddressFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(walletNameFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(walletIconFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(walletNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(walletAddressFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receivingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void transferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferBtnActionPerformed
        List<WizardDescriptor.Panel<WizardDescriptor>> panels = new ArrayList<>();
        panels.add(new TransferInputWizardPanel(wallet, baseCoin));
        panels.add(new PasswordInputWizardPanel(wallet));
        panels.add(new TransferConfirmWizardPanel(wallet));
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
        wiz.setTitle("转账");
        if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
            // do something
            String recvAddress = (String)wiz.getProperty("recvAddress");
            String value = (String)wiz.getProperty("value");
            int gas = (int)wiz.getProperty("gas");
            String pwd = (String)wiz.getProperty("password");
            
            try {
                System.out.println("privateKey=" + AESUtil.decrypt(wallet.getPrivateKeyAES(), pwd));
                System.out.println("recvAddress=" + recvAddress);
                System.out.println("value=" + value);
                System.out.println("gas=" + gas);
                String hash = baseCoin.transfer(AESUtil.decrypt(wallet.getPrivateKeyAES(), pwd), 
                        recvAddress, 
                        baseCoin.mainUint2MinUint(NumberUtils.toDouble(value)), 
                        BigInteger.valueOf(gas));
                System.out.println("hash=====================" + hash);
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }//GEN-LAST:event_transferBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        BigInteger balance = baseCoin.balanceOf(wallet.getAddress());
        balanceFld.setText(baseCoin.minUnit2MainUint(balance).setScale(baseCoin.getMainUnitScale(), RoundingMode.HALF_DOWN).toPlainString() + " " + baseCoin.getMainUnit());
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void openBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openBtnActionPerformed
        
        if(StringUtils.isNotEmpty(walletTopComponentId)) {
            TopComponent tc = WindowManager.getDefault().findTopComponent(walletTopComponentId);
            if(tc != null && tc.isOpened()) {
                tc.requestActive();
                return;
            }
        }
        
        // 1 未打开过
        // 2 若打开过，但已被关闭
        WalletTopComponent tc = new WalletTopComponent(wallet);
        tc.open();
        tc.requestActive();
        walletTopComponentId = tc.preferredID();
    }//GEN-LAST:event_openBtnActionPerformed

    private void receivingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivingBtnActionPerformed
        RecvDialog dlg = new RecvDialog(null, wallet.getAddress());
        dlg.setVisible(true);
    }//GEN-LAST:event_receivingBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel balanceFld;
    private org.jdesktop.swingx.JXButton openBtn;
    private org.jdesktop.swingx.JXButton receivingBtn;
    private org.jdesktop.swingx.JXButton refreshBtn;
    private org.jdesktop.swingx.JXButton transferBtn;
    private org.jdesktop.swingx.JXTextField walletAddressFld;
    private org.jdesktop.swingx.JXLabel walletIconFld;
    private org.jdesktop.swingx.JXTextField walletNameFld;
    // End of variables declaration//GEN-END:variables
}
