package com.acuilab.bc.main.wallet;

import com.acuilab.bc.main.util.AESUtil;
import com.acuilab.bc.main.wallet.wizard.PasswordInputWizardPanel;
import com.acuilab.bc.main.wallet.wizard.TransferConfirmWizardPanel;
import com.acuilab.bc.main.wallet.wizard.TransferInputWizardPanel;
import java.awt.Component;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import org.apache.commons.lang3.math.NumberUtils;
import org.jdesktop.swingx.JXPanel;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;
import org.openide.util.Exceptions;

/**
 *
 * @author admin
 */
public class CoinPanel extends JXPanel {
    
    private final Wallet wallet;
    private final Coin coin;
    private TransferRecordTableModel tableModel; 

    /**
     * Creates new form CoinPanel
     * @param wallet
     * @param coin
     */
    public CoinPanel(Wallet wallet, Coin coin) {
        initComponents();
        this.wallet = wallet;
        this.coin = coin;
        
        tableModel = new TransferRecordTableModel(table);
        
        // set the table model after setting the factory
        table.setModel(tableModel);
        
        // 余额
        BigInteger balance = coin.balanceOf(wallet.getAddress());
        balanceFld.setText(coin.minUnit2MainUint(balance).setScale(coin.getMainUnitScale(), RoundingMode.HALF_DOWN).toPlainString() + " " + coin.getMainUnit());

        
        // TODO: 获得历史记录
//        coin.transferRecord(wallet.getAddress());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXButton1 = new org.jdesktop.swingx.JXButton();
        balanceFld = new org.jdesktop.swingx.JXTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new org.jdesktop.swingx.JXTable();

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel1, org.openide.util.NbBundle.getMessage(CoinPanel.class, "CoinPanel.jXLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXButton1, org.openide.util.NbBundle.getMessage(CoinPanel.class, "CoinPanel.jXButton1.text")); // NOI18N
        jXButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton1ActionPerformed(evt);
            }
        });

        balanceFld.setEditable(false);
        balanceFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        balanceFld.setText(org.openide.util.NbBundle.getMessage(CoinPanel.class, "CoinPanel.balanceFld.text")); // NOI18N

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balanceFld, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balanceFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jXButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton1ActionPerformed
        List<WizardDescriptor.Panel<WizardDescriptor>> panels = new ArrayList<>();
        panels.add(new TransferInputWizardPanel(wallet, coin));
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
                String hash = coin.transfer(AESUtil.decrypt(wallet.getPrivateKeyAES(), pwd), recvAddress, coin.mainUint2MinUint(NumberUtils.toDouble(value)), BigInteger.valueOf(gas));
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }//GEN-LAST:event_jXButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTextField balanceFld;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXButton jXButton1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXTable table;
    // End of variables declaration//GEN-END:variables
}
