package com.h.goodweather.contract;

import android.annotation.SuppressLint;

import com.h.goodweather.api.ApiService;
import com.h.goodweather.bean.BiYingImgResponse;
import com.h.goodweather.bean.WallPaperResponse;
import com.h.mvplibrary.base.BasePresenter;
import com.h.mvplibrary.base.BaseView;
import com.h.mvplibrary.newnet.NetworkApi;
import com.h.mvplibrary.newnet.observer.BaseObserver;

/**
 * 壁纸订阅器
 *
 * @author h
 */
public class WallPaperContract {

    public static class WallPaperPresenter extends BasePresenter<IWallPaperView> {


        /**
         * 获取必应  每日一图
         */
        @SuppressLint("CheckResult")
        public void biying() {
            ApiService service = NetworkApi.createService(ApiService.class, 1);
            service.biying().compose(NetworkApi.applySchedulers(new BaseObserver<BiYingImgResponse>() {
                @Override
                public void onSuccess(BiYingImgResponse biYingImgResponse) {
                    if (getView() != null) {
                        getView().getBiYingResult(biYingImgResponse);
                    }
                }

                @Override
                public void onFailure(Throwable e) {
                    if (getView() != null) {
                        getView().getDataFailed();
                    }
                }
            }));
        }


        /**
         * 获取壁纸数据
         */
        @SuppressLint("CheckResult")
        public void getWallPaper() {
            // 6 表示访问网络壁纸接口
            ApiService service = NetworkApi.createService(ApiService.class, 6);
            service.getWallPaper().compose(NetworkApi.applySchedulers(new BaseObserver<WallPaperResponse>() {
                @Override
                public void onSuccess(WallPaperResponse wallPaperResponse) {
                    if (getView() != null) {
                        getView().getWallPaperResult(wallPaperResponse);
                    }
                }

                @Override
                public void onFailure(Throwable e) {
                    if (getView() != null) {
                        getView().getDataFailed();
                    }
                }
            }));
        }
    }

    public interface IWallPaperView extends BaseView {

        /**
         * 获取必应每日一图返回
         * @param response BiYingImgResponse
         */
        void getBiYingResult(BiYingImgResponse response);

        /**
         * 壁纸数据返回
         * @param response WallPaperResponse
         */
        void getWallPaperResult(WallPaperResponse response);

        /**
         * 错误返回
         */
        void getDataFailed();


    }
}
