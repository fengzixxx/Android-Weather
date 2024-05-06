package com.h.goodweather.contract;

import android.annotation.SuppressLint;
import com.h.goodweather.api.ApiService;
import com.h.goodweather.bean.WorldCityResponse;
import com.h.mvplibrary.base.BasePresenter;
import com.h.mvplibrary.base.BaseView;
import com.h.mvplibrary.newnet.NetworkApi;
import com.h.mvplibrary.newnet.observer.BaseObserver;


/**
 * 世界城市订阅器
 *
 * @author h
 */
public class WorldCityContract {

    public static class WorldCityPresenter extends BasePresenter<IWorldCityView> {

        /**
         * 世界城市  V7
         *
         * @param range 类型
         */
        @SuppressLint("CheckResult")
        public void worldCity(String range) {
            ApiService service = NetworkApi.createService(ApiService.class, 4);//指明访问的地址
            service.worldCity(range).compose(NetworkApi.applySchedulers(new BaseObserver<WorldCityResponse>() {
                @Override
                public void onSuccess(WorldCityResponse worldCityResponse) {
                    if (getView() != null) {
                        getView().getWorldCityResult(worldCityResponse);
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

    public interface IWorldCityView extends BaseView {

        //热门城市返回数据 V7
        void getWorldCityResult(WorldCityResponse response);

        //错误返回
        void getDataFailed();
    }
}
