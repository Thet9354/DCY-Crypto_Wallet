package com.example.dyccryptowallet.Model;

public class CryptoModel {

    int id;
    int images;
    String tokenName;
    String tokenID;
    String tokenPrice;
    String tokenOwned;
    String priceChange;

    public CryptoModel()
    {

    }

    public CryptoModel(int id, int images, String tokenName, String tokenID, String tokenPrice, String tokenOwned, String priceChange) {
        this.id = id;
        this.images = images;
        this.tokenName = tokenName;
        this.tokenID = tokenID;
        this.tokenPrice = tokenPrice;
        this.tokenOwned = tokenOwned;
        this.priceChange = priceChange;
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

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenID() {
        return tokenID;
    }

    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }

    public String getTokenPrice() {
        return tokenPrice;
    }

    public void setTokenPrice(String tokenPrice) {
        this.tokenPrice = tokenPrice;
    }

    public String getTokenOwned() {
        return tokenOwned;
    }

    public void setTokenOwned(String tokenOwned) {
        this.tokenOwned = tokenOwned;
    }

    public String getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(String priceChange) {
        this.priceChange = priceChange;
    }
}
