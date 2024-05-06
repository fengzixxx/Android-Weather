package com.h.mvplibrary.bean;

import org.litepal.crud.LitePalSupport;

/**
 * 壁纸表
 *
 * @author h
 */
public class WallPaper extends LitePalSupport {

    private String ImgUrl;

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }
}
