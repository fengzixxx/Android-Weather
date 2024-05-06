package com.h.goodweather;

import android.app.Application;

import com.h.mvplibrary.newnet.INetworkRequiredInfo;


/**
 * 网络访问信息
 * @author h
 */
public class NetworkRequiredInfo implements INetworkRequiredInfo {

    private final Application application;

    public NetworkRequiredInfo(Application application){
        this.application = application;
    }

    /**
     * 版本名
     */
    @Override
    public String getAppVersionName() {
        return com.h.goodweather.BuildConfig.VERSION_NAME;
    }
    /**
     * 版本号
     */
    @Override
    public String getAppVersionCode() {
        return String.valueOf(com.h.goodweather.BuildConfig.VERSION_CODE);
    }

    /**
     * 是否为debug
     */
    @Override
    public boolean isDebug() {
        return com.h.goodweather.BuildConfig.DEBUG;
    }

    /**
     * 应用全局上下文
     */
    @Override
    public Application getApplicationContext() {
        return application;
    }
}
