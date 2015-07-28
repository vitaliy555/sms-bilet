package com.dudi.core.constant;

public enum VendorUrl {
    RST("http://rst.ua"),
    ARia("http://auto.ria.com/");
    private String url;

    VendorUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
