package com.example.dyccryptowallet.Model;

public class MyAccounts {

    int id;
    int images;
    String accountName;
    String walletAddress;

    public MyAccounts(int id, int images, String accountName, String walletAddress) {
        this.id = id;
        this.images = images;
        this.accountName = accountName;
        this.walletAddress = walletAddress;
    }

    public MyAccounts()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }
}
