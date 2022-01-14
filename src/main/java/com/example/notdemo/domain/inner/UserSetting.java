package com.example.notdemo.domain.inner;

import java.io.Serializable;

public class UserSetting implements Serializable {
    private boolean allowPersonalization;
    private boolean marketingSms;
    private boolean receiveNewsletter;
    private boolean receiveTransaction;
    private boolean priceAlertMail;
    private boolean priceAlertSms;
    private boolean publicProfile;

    public boolean isAllowPersonalization() {
        return allowPersonalization;
    }

    public void setAllowPersonalization(boolean allowPersonalization) {
        this.allowPersonalization = allowPersonalization;
    }

    public boolean isMarketingSms() {
        return marketingSms;
    }

    public void setMarketingSms(boolean marketingSms) {
        this.marketingSms = marketingSms;
    }

    public boolean isReceiveNewsletter() {
        return receiveNewsletter;
    }

    public void setReceiveNewsletter(boolean receiveNewsletter) {
        this.receiveNewsletter = receiveNewsletter;
    }

    public boolean isReceiveTransaction() {
        return receiveTransaction;
    }

    public void setReceiveTransaction(boolean receiveTransaction) {
        this.receiveTransaction = receiveTransaction;
    }

    public boolean isPriceAlertMail() {
        return priceAlertMail;
    }

    public void setPriceAlertMail(boolean priceAlertMail) {
        this.priceAlertMail = priceAlertMail;
    }

    public boolean isPriceAlertSms() {
        return priceAlertSms;
    }

    public void setPriceAlertSms(boolean priceAlertSms) {
        this.priceAlertSms = priceAlertSms;
    }

    public boolean isPublicProfile() {
        return publicProfile;
    }

    public void setPublicProfile(boolean publicProfile) {
        this.publicProfile = publicProfile;
    }

    @Override
    public String toString() {
        return "UserSetting{" +
                "allowPersonalization=" + allowPersonalization +
                ", marketingSms=" + marketingSms +
                ", receiveNewsletter=" + receiveNewsletter +
                ", receiveTransaction=" + receiveTransaction +
                ", priceAlertMail=" + priceAlertMail +
                ", priceAlertSms=" + priceAlertSms +
                ", publicProfile=" + publicProfile +
                '}';
    }
}
