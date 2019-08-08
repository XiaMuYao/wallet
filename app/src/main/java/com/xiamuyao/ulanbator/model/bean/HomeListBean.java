package com.xiamuyao.ulanbator.model.bean;

public class HomeListBean {
    private String itemId = "";
    private int imageId = 0;
    private String homeTitle = "";

    public HomeListBean(String itemId, int imageId, String homeTitle) {
        this.itemId = itemId;
        this.imageId = imageId;
        this.homeTitle = homeTitle;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getHomeTitle() {
        return homeTitle;
    }

    public void setHomeTitle(String homeTitle) {
        this.homeTitle = homeTitle;
    }
}
