package com.acuilab.bc.main.wallet.wizard;

import com.acuilab.bc.main.manager.BlockChainManager;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class NameCoinVisualPanel extends JPanel {

    /**
     * Creates new form FirstCreateVisualPanel1
     */
    public NameCoinVisualPanel() {
        initComponents();
        coinList.setListData(BlockChainManager.getDefault().getBlockChainSymbols());
        // 默认选中第一项
        coinList.setSelectedIndex(0);
    }

    @Override
    public String getName() {
        return "设置钱包名称并选择币种";
    }
    
    public JTextField getWalletNameField(){
        return walletNameFld;
    }

    public JList getCoinList(){
        return coinList;
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        walletNameFld = new org.jdesktop.swingx.JXTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        coinList = new org.jdesktop.swingx.JXList();

        setPreferredSize(new java.awt.Dimension(400, 500));

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel1, org.openide.util.NbBundle.getMessage(NameCoinVisualPanel.class, "NameCoinVisualPanel.jXLabel1.text")); // NOI18N

        walletNameFld.setText(org.openide.util.NbBundle.getMessage(NameCoinVisualPanel.class, "NameCoinVisualPanel.walletNameFld.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jXLabel2, org.openide.util.NbBundle.getMessage(NameCoinVisualPanel.class, "NameCoinVisualPanel.jXLabel2.text")); // NOI18N

        coinList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(coinList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(walletNameFld, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(walletNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXList coinList;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXTextField walletNameFld;
    // End of variables declaration//GEN-END:variables
}
