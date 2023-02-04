package edu.northeastern.numad23sp_siyueli;

public class ItemCard {

    private final String urlName;
    private final String url;

    public ItemCard(String urlName, String url) {
        this.url = url;
        this.urlName = urlName;
    }

    public String getUrlName() {
        return urlName;
    }

    public String getUrl() {
        return url;
    }
}