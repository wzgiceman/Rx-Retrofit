package com.wzgiceman.rxretrofitlibrary.retrofit_rx;

import android.app.Application;

/**
 * 全局app
 * Created by WZG on 2016/12/12.
 */

public class RxRetrofitApp  {
    private static Application application;
    /*基础url*/
    private static String baseUrl="blog.csdn.net/wzgiceamn";


    /**
     * 初始化rx_retrofit数据
     * @param app app
     * @param baseUrl 基础url
     */
    public static void init(Application app,String baseUrl){
        setApplication(app);
        setBaseUrl(baseUrl);
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        RxRetrofitApp.baseUrl = baseUrl;
    }

    public static Application getApplication() {
        return application;
    }

    private static void setApplication(Application application) {
        RxRetrofitApp.application = application;
    }
}
