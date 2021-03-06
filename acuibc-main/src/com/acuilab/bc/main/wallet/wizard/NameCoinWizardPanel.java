package com.acuilab.bc.main.wallet.wizard;

import com.acuilab.bc.main.dao.WalletDAO;
import java.sql.SQLException;
import javax.swing.JList;
import javax.swing.event.ChangeListener;
import org.apache.commons.lang3.StringUtils;
import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;
import org.openide.util.Exceptions;
import org.openide.util.HelpCtx;

public class NameCoinWizardPanel implements WizardDescriptor.ValidatingPanel<WizardDescriptor> {
    
    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private NameCoinVisualPanel component;

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public NameCoinVisualPanel getComponent() {
        if (component == null) {
            component = new NameCoinVisualPanel();
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        // Show no Help button for this panel:
        return HelpCtx.DEFAULT_HELP;
        // If you have context help:
        // return new HelpCtx("help.key.here");
    }

    @Override
    public boolean isValid() {
        // If it is always OK to press Next or Finish, then:
        return true;
        // If it depends on some condition (form filled out...) and
        // this condition changes (last form field filled in...) then
        // use ChangeSupport to implement add/removeChangeListener below.
        // WizardDescriptor.ERROR/WARNING/INFORMATION_MESSAGE will also be useful.
    }

    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }

    @Override
    public void readSettings(WizardDescriptor wiz) {
        // use wiz.getProperty to retrieve previous panel state
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        // use wiz.putProperty to remember current panel state
        wiz.putProperty("walletName", getComponent().getWalletNameField().getText());
        wiz.putProperty("coinSymbal", (String)getComponent().getCoinList().getSelectedValue());
    }

    @Override
    public void validate() throws WizardValidationException {
        String name = component.getWalletNameField().getText();
        if(StringUtils.isBlank(name)) {
            component.getWalletNameField().requestFocus();
            throw new WizardValidationException(null, "请填写钱包名称", null);
        }
        
        try {
            // 钱包名称不能重复
            if(WalletDAO.existByName(name)) {
                component.getWalletNameField().requestFocus();
                throw new WizardValidationException(null, "钱包名称已存在", null);
            }
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        JList coinList = component.getCoinList();
        if(coinList.getSelectedIndex() == -1) {
            throw new WizardValidationException(null, "请选择币种", null);
        }
        
    }

}
