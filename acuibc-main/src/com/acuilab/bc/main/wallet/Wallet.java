package com.acuilab.bc.main.wallet;

import java.util.Date;
import java.util.Observable;
import org.apache.commons.lang3.StringUtils;

/**
 * 钱包
 * 
 *
 * @author admin
 */
public class Wallet extends Observable {
    
    private String name;          // 钱包名称(主键)
    private String pwdMD5;        // 钱包密码
    private final String blockChainSymbol;        // 区块链简称
    private final String address;       // 钱包地址
    private String privateKeyAES;    // 私钥
    private String mnemonicAES;      // 助记词
    private final Date created;             // 创建事件
    
    public Wallet(String name, String pwdMD5, String symbol, String address, String privateKeyAES, Date created) {
        this(name, pwdMD5, symbol, address, privateKeyAES, "", created);
    }
    
    public Wallet(String name, String pwdMD5, String blockChainSymbol, String address, String privateKeyAES, String mnemonicAES, Date created) {
        this.name = name;
        this.pwdMD5 = pwdMD5;
        
        this.blockChainSymbol = blockChainSymbol;
        this.address = address;
        this.privateKeyAES = privateKeyAES;
        this.mnemonicAES = mnemonicAES;
        this.created = created;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if(!StringUtils.equals(this.name, name)) {
            this.name = name;
            setChanged();
        }
        
        notifyObservers();
    }

    public String getPwdMD5() {
        return pwdMD5;
    }

    public void setPwdMD5(String pwdMD5) {
        this.pwdMD5 = pwdMD5;
    }
    
    public String getBlockChainSymbol() {
        return blockChainSymbol;
    }

    public String getAddress() {
        return address;
    }
    
    public String getPrivateKeyAES() {
        return privateKeyAES;
    }
    
    public String getMnemonicAES() {
        return mnemonicAES;
    }
    
    public Date getCreated() {
        return created;
    }

    public void setPrivateKeyAES(String privateKeyAES) {
        this.privateKeyAES = privateKeyAES;
    }

    public void setMnemonicAES(String mnemonicAES) {
        this.mnemonicAES = mnemonicAES;
    }
}
