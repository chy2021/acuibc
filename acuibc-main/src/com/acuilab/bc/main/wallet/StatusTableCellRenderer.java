package com.acuilab.bc.main.wallet;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author admin
 */
public class StatusTableCellRenderer extends DefaultTableCellRenderer {
    
    private static final Icon okIcon = new javax.swing.ImageIcon(StatusTableCellRenderer.class.getResource("/resource/ok24.png"));
    private static final Icon errorIcon = new javax.swing.ImageIcon(StatusTableCellRenderer.class.getResource("/resource/error24.png"));

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	
	JLabel label = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	if(column == TransferRecordTableModel.STATUS_COLUMN){
	    label.setText(null);
	    TransferRecordTableModel tableModel = (TransferRecordTableModel)table.getModel();
	    TransferRecord rransferRecord = tableModel.getTransferRecord(table.convertRowIndexToModel(row));
	    if(StringUtils.equals(rransferRecord.getStatus(), "0")) {
		label.setIcon(okIcon);
	    } else {
		label.setIcon(errorIcon);
	    }
	}
	
	return label;
    }
    
}