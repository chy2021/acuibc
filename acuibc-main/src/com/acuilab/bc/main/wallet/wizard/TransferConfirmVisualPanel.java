package com.acuilab.bc.main.wallet.wizard;

import javax.swing.JPanel;

public final class TransferConfirmVisualPanel extends JPanel {

    /**
     * Creates new form TransferVisualPanel3
     */
    public TransferConfirmVisualPanel() {
        initComponents();
    }

    @Override
    public String getName() {
        return "确认转账信息";
    }
    
    public void init(String recvAddress, String value, String sendAddress, String gasDesc) {
        recvAddressFld.setText(recvAddress);
        valueFld.setText(value);
        sendAddressFld.setText(sendAddress);
        gasFld.setText(gasDesc);
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
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        recvAddressFld = new org.jdesktop.swingx.JXTextField();
        valueFld = new org.jdesktop.swingx.JXTextField();
        sendAddressFld = new org.jdesktop.swingx.JXTextField();
        gasFld = new org.jdesktop.swingx.JXTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel1, org.openide.util.NbBundle.getMessage(TransferConfirmVisualPanel.class, "TransferConfirmVisualPanel.jXLabel1.text")); // NOI18N
        jXLabel1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel2, org.openide.util.NbBundle.getMessage(TransferConfirmVisualPanel.class, "TransferConfirmVisualPanel.jXLabel2.text")); // NOI18N
        jXLabel2.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel3, org.openide.util.NbBundle.getMessage(TransferConfirmVisualPanel.class, "TransferConfirmVisualPanel.jXLabel3.text")); // NOI18N
        jXLabel3.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel4, org.openide.util.NbBundle.getMessage(TransferConfirmVisualPanel.class, "TransferConfirmVisualPanel.jXLabel4.text")); // NOI18N
        jXLabel4.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        recvAddressFld.setEditable(false);
        recvAddressFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        recvAddressFld.setText(org.openide.util.NbBundle.getMessage(TransferConfirmVisualPanel.class, "TransferConfirmVisualPanel.recvAddressFld.text")); // NOI18N
        recvAddressFld.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        valueFld.setEditable(false);
        valueFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        valueFld.setText(org.openide.util.NbBundle.getMessage(TransferConfirmVisualPanel.class, "TransferConfirmVisualPanel.valueFld.text")); // NOI18N
        valueFld.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        sendAddressFld.setEditable(false);
        sendAddressFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sendAddressFld.setText(org.openide.util.NbBundle.getMessage(TransferConfirmVisualPanel.class, "TransferConfirmVisualPanel.sendAddressFld.text")); // NOI18N
        sendAddressFld.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        gasFld.setEditable(false);
        gasFld.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gasFld.setText(org.openide.util.NbBundle.getMessage(TransferConfirmVisualPanel.class, "TransferConfirmVisualPanel.gasFld.text")); // NOI18N
        gasFld.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(recvAddressFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valueFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sendAddressFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gasFld, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gasFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTextField gasFld;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXTextField recvAddressFld;
    private org.jdesktop.swingx.JXTextField sendAddressFld;
    private org.jdesktop.swingx.JXTextField valueFld;
    // End of variables declaration//GEN-END:variables
}
