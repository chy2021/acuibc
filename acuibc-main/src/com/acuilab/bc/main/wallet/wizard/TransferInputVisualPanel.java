package com.acuilab.bc.main.wallet.wizard;

import com.acuilab.bc.main.BlockChain;
import com.acuilab.bc.main.wallet.Coin;
import com.acuilab.bc.main.manager.BlockChainManager;
import com.acuilab.bc.main.wallet.Wallet;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.concurrent.ExecutionException;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import org.openide.util.Exceptions;

public final class TransferInputVisualPanel extends JPanel {
    
    private final Wallet wallet;
    private BigInteger balance;
    
    /**
     * Creates new form TransferVisualPanel1
     */
    public TransferInputVisualPanel(Wallet wallet, Coin coin) {
        initComponents();
        
        this.wallet = wallet;
        
        // sdk估算
//        BlockChain bc = BlockChainManager.getDefault().getBlockChain(coin.getBlockChainSymbol());
//        gasSlider.setMinimum(bc.gasMin());
//        gasSlider.setMaximum(bc.gasMax());
//        gasSlider.setValue(bc.gasDefaultValue());
//        gasLbl.setText(bc.gasDesc(bc.gasDefaultValue()));

        // 求余额
        valueFld.setPrompt("正在请求余额，请稍候...");
        SwingWorker<BigInteger, Void> worker = new SwingWorker<BigInteger, Void>() {
            @Override
            protected BigInteger doInBackground() throws Exception {
                return coin.balanceOf(wallet.getAddress());
            }

            @Override
            protected void done() {
                try {
                    balance = get();
                    valueFld.setPrompt("可用：" + coin.minUnit2MainUint(balance).setScale(coin.getMainUnitScale(), RoundingMode.HALF_DOWN).toPlainString() + " " + coin.getMainUnit());
                } catch (InterruptedException | ExecutionException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        };
        worker.execute();
        
        sendAddressFld.setText(wallet.getAddress());
    }

    @Override
    public String getName() {
        return "输入转账信息";
    }
    
    public JTextField getRecvAddressFld() {
        return recvAddressFld;
    }
    
    public JTextField getValueFld() {
        return valueFld;
    }
    
    public JSlider getGasSlider() {
        return gasSlider;
    }
    
    public BigInteger getBalance() {
        return balance;
    }
    
    public boolean balanceAvailable() {
        return balance != null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        recvAddressFld = new org.jdesktop.swingx.JXTextField();
        valueFld = new org.jdesktop.swingx.JXTextField();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        sendAddressFld = new org.jdesktop.swingx.JXTextField();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        gasSlider = new javax.swing.JSlider();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        gasLbl = new org.jdesktop.swingx.JXLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel1, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.jXLabel1.text")); // NOI18N
        jXLabel1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel2, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.jXLabel2.text")); // NOI18N
        jXLabel2.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        recvAddressFld.setText(org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.recvAddressFld.text")); // NOI18N
        recvAddressFld.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        valueFld.setText(org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.valueFld.text")); // NOI18N
        valueFld.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel3, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.jXLabel3.text")); // NOI18N
        jXLabel3.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        sendAddressFld.setEditable(false);
        sendAddressFld.setText(org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.sendAddressFld.text")); // NOI18N
        sendAddressFld.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel4, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.jXLabel4.text")); // NOI18N
        jXLabel4.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        gasSlider.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        gasSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gasSliderStateChanged(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel5, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.jXLabel5.text")); // NOI18N
        jXLabel5.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel6, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.jXLabel6.text")); // NOI18N
        jXLabel6.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        gasLbl.setForeground(new java.awt.Color(0, 0, 255));
        gasLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(gasLbl, org.openide.util.NbBundle.getMessage(TransferInputVisualPanel.class, "TransferInputVisualPanel.gasLbl.text")); // NOI18N
        gasLbl.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gasLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(recvAddressFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valueFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sendAddressFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gasSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recvAddressFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendAddressFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gasSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gasLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(262, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void gasSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gasSliderStateChanged
        BlockChain bc = BlockChainManager.getDefault().getBlockChain(wallet.getBlockChainSymbol());
//        gasLbl.setText(bc.gasDesc(((JSlider) evt.getSource()).getValue()));
        gasLbl.setText("sdk估算");
    }//GEN-LAST:event_gasSliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel gasLbl;
    private javax.swing.JSlider gasSlider;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXTextField recvAddressFld;
    private org.jdesktop.swingx.JXTextField sendAddressFld;
    private org.jdesktop.swingx.JXTextField valueFld;
    // End of variables declaration//GEN-END:variables
}
