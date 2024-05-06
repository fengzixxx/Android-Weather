package com.h.goodweather.contract;

import android.annotation.SuppressLint;

import com.h.goodweather.api.ApiService;
import com.h.goodweather.bean.DailyResponse;
import com.h.mvplibrary.base.BasePresenter;
import com.h.mvplibrary.base.BaseView;
import com.h.mvplibrary.newnet.NetworkApi;
import com.h.mvplibrary.newnet.observer.BaseObserver;

/**
 * 更多天气预报订阅器
 *
 * @author h
 */
public class MoreDailyContract {

    public static class MoreDailyPresenter extends BasePresenter<IMoreDailyView> {

        /**
         * 更多天气预报  V7
         *
         * @param location 城市id
         */
        @SuppressLint("CheckResult")
        public void dailyWeather(String location) {
            ApiService service = NetworkApi.createService(ApiService.class, 3);
            service.dailyWeather("15d", location).compose(NetworkApi.applySchedulers(new BaseObserver<DailyResponse>() {
                @Override
                public void onSuccess(DailyResponse dailyResponse) {
                    if (getView() != null) {
                        getView().getMoreDailyResult(dailyResponse);
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

    public interface IMoreDailyView extends BaseView {

        //更多天气预报返回数据 V7
        void getMoreDailyResult(DailyResponse response);

        //错误返回
        void getDataFailed();
    }
}
