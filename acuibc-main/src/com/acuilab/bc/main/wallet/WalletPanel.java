package com.acuilab.bc.main.wallet;

import com.acuilab.bc.main.BlockChain;
import com.acuilab.bc.main.dao.WalletDAO;
import com.acuilab.bc.main.manager.BlockChainManager;
import com.acuilab.bc.main.manager.CoinManager;
import com.acuilab.bc.main.util.AESUtil;
import com.acuilab.bc.main.wallet.wizard.TransferInputWizardPanel;
import com.acuilab.bc.main.wallet.wizard.PasswordInputWizardPanel;
import com.acuilab.bc.main.wallet.wizard.TransferConfirmWizardPanel;
import java.awt.Component;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutionException;
import javax.swing.JComponent;
import javax.swing.SwingWorker;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jdesktop.swingx.JXPanel;
import org.netbeans.api.progress.ProgressHandle;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author admin
 */
public class WalletPanel extends JXPanel implements Observer {
    
    private final Wallet wallet;
    
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
        
        Coin baseCoin = CoinManager.getDefault().getBaseCoin(wallet.getBlockChainSymbol());
        balanceFld.setText("0.000000 " + baseCoin.getMainUnit());
        
        this.wallet = wallet;
        this.walletTopComponentId = null;
        
        wallet.addObserver(this);
    }
    
    public Wallet getWallet() {
        return wallet;
    }
    
    public void setBalance(BigInteger balance) {
        Coin baseCoin = CoinManager.getDefault().getBaseCoin(wallet.getBlockChainSymbol());
        balanceFld.setText(baseCoin.minUnit2MainUint(balance).setScale(baseCoin.getMainUnitScale(), RoundingMode.HALF_DOWN).toPlainString() + " " + baseCoin.getMainUnit());
    }
    
    public void setRefreshBtnEnabled() {
        refreshBtn.setEnabled(true);
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
        walletAddressFld = new org.jdesktop.swingx.JXTextField();
        walletNameFld = new org.jdesktop.swingx.JXTextField();
        transferBtn = new org.jdesktop.swingx.JXButton();
        refreshBtn = new org.jdesktop.swingx.JXButton();
        openBtn = new org.jdesktop.swingx.JXButton();
        deleteBtn = new org.jdesktop.swingx.JXButton();
        balanceFld = new org.jdesktop.swingx.JXTextField();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        org.openide.awt.Mnemonics.setLocalizedText(walletIconFld, org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.walletIconFld.text")); // NOI18N
        walletIconFld.setMaximumSize(new java.awt.Dimension(64, 64));
        walletIconFld.setMinimumSize(new java.awt.Dimension(64, 64));
        walletIconFld.setPreferredSize(new java.awt.Dimension(64, 64));

        walletAddressFld.setEditable(false);
        walletAddressFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        walletAddressFld.setForeground(new java.awt.Color(0, 0, 255));
        walletAddressFld.setText(org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.walletAddressFld.text")); // NOI18N

        walletNameFld.setEditable(false);
        walletNameFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        walletNameFld.setForeground(new java.awt.Color(0, 0, 255));
        walletNameFld.setText(org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.walletNameFld.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(transferBtn, org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.transferBtn.text")); // NOI18N
        transferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferBtnActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(refreshBtn, org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.refreshBtn.text")); // NOI18N
        refreshBtn.setEnabled(false);
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

        org.openide.awt.Mnemonics.setLocalizedText(deleteBtn, org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.deleteBtn.text")); // NOI18N
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        balanceFld.setEditable(false);
        balanceFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        balanceFld.setForeground(java.awt.Color.magenta);
        balanceFld.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        balanceFld.setText(org.openide.util.NbBundle.getMessage(WalletPanel.class, "WalletPanel.balanceFld.text")); // NOI18N

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
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balanceFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(walletNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(walletAddressFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(walletIconFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(transferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(openBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(balanceFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void transferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferBtnActionPerformed
        Coin baseCoin = CoinManager.getDefault().getBaseCoin(wallet.getBlockChainSymbol());
        
        List<WizardDescriptor.Panel<WizardDescriptor>> panels = new ArrayList<>();
        panels.add(new TransferInputWizardPanel(wallet, baseCoin));
        panels.add(new PasswordInputWizardPanel(wallet));
        panels.add(new TransferConfirmWizardPanel(wallet, baseCoin));
        String[] steps = new String[panels.size()];
        for (int i = 0; i < panels.size(); i++) {
            Component c = panels.get(i).getComponent();
            // Default step name to component name of panel.
            steps[i] = c.getName();
            if (c instanceof JComponent) { // assume Swing components
                JComponent jc = (JComponent) c;
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, Boolean.TRUE);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, Boolean.TRUE);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, Boolean.TRUE);
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
            boolean gasDefault = (Boolean)wiz.getProperty("isGasDefault");
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
                        gasDefault ? null : BigInteger.valueOf(gas));
                System.out.println("hash=====================" + hash);
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }//GEN-LAST:event_transferBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
            // 获得余额
            // 这里没有禁用refreshBtn，因为禁用会导致焦点转移给下一个打开按钮openBtn，界面闪烁，用户体验不好；暂时没有更好的解决办法
            // 好吧，想到一个折中的办法，将refreshBtn放到最后
            refreshBtn.setEnabled(false);
            final Coin baseCoin = CoinManager.getDefault().getBaseCoin(wallet.getBlockChainSymbol());
            final ProgressHandle ph = ProgressHandle.createHandle("正在请求余额，请稍候");
            SwingWorker<BigInteger, Void> worker = new SwingWorker<BigInteger, Void>() {
                @Override
                protected BigInteger doInBackground() throws Exception {
                    ph.start();
                    return baseCoin.balanceOf(wallet.getAddress());
                }

                @Override
                protected void done() {
                    try {
                        balanceFld.setText(baseCoin.minUnit2MainUint(get()).setScale(baseCoin.getMainUnitScale(), RoundingMode.HALF_DOWN).toPlainString() + " " + baseCoin.getMainUnit());
                    } catch (InterruptedException | ExecutionException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                    
                    ph.finish();
                    refreshBtn.setEnabled(true);
                    refreshBtn.requestFocusInWindow();
                }
            };
            worker.execute();
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

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        PasswordVerifyDialog passwordVerifyDialog = new PasswordVerifyDialog(null, wallet);
        passwordVerifyDialog.setVisible(true);
        if(passwordVerifyDialog.getReturnStatus() == PasswordVerifyDialog.RET_OK) {
            try {
                // 先删除数据库记录
                WalletDAO.delete(wallet.getName());
                
                // 从面板中删除
                WalletListTopComponent walletListTC = (WalletListTopComponent)WindowManager.getDefault().findTopComponent("WalletListTopComponent");
                walletListTC.deleteWallet(wallet);

                // 关闭对应的WalletTopComponent
                if(StringUtils.isNotEmpty(walletTopComponentId)) {
                    TopComponent walletTC = WindowManager.getDefault().findTopComponent(walletTopComponentId);
                    if(walletTC != null && walletTC.isOpened()) {
                        walletTC.close();
                    }
                }
            } catch (SQLException ex) {
                Exceptions.printStackTrace(ex);
            }
            
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTextField balanceFld;
    private org.jdesktop.swingx.JXButton deleteBtn;
    private org.jdesktop.swingx.JXButton openBtn;
    private org.jdesktop.swingx.JXButton refreshBtn;
    private org.jdesktop.swingx.JXButton transferBtn;
    private org.jdesktop.swingx.JXTextField walletAddressFld;
    private org.jdesktop.swingx.JXLabel walletIconFld;
    private org.jdesktop.swingx.JXTextField walletNameFld;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("arg=" + arg);
        walletNameFld.setText(((Wallet)o).getName());
    }
}
