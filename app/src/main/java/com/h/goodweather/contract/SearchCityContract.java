package com.h.goodweather.contract;

import android.annotation.SuppressLint;

import com.h.goodweather.api.ApiService;
import com.h.goodweather.bean.NewSearchCityResponse;
import com.h.mvplibrary.base.BasePresenter;
import com.h.mvplibrary.base.BaseView;
import com.h.mvplibrary.newnet.NetworkApi;
import com.h.mvplibrary.newnet.observer.BaseObserver;

/**
 * 搜索城市订阅器  V7
 *
 * @author h
 */
public class SearchCityContract {

    public static class SearchCityPresenter extends BasePresenter<ISearchCityView> {
        /**
         * 搜索城市  V7版本中  模糊搜索  返回10条相关数据
         *
         * @param location 城市名
         */
        @SuppressLint("CheckResult")
        public void newSearchCity(String location) {//注意这里的4表示新的搜索城市地址接口
            ApiService service = NetworkApi.createService(ApiService.class, 4);//指明访问的地址
            service.newSearchCity(location, "exact")
                    .compose(NetworkApi.applySchedulers(new BaseObserver<NewSearchCityResponse>() {
                        @Override
                        public void onSuccess(NewSearchCityResponse newSearchCityResponse) {
                            if (getView() != null) {
                                getView().getNewSearchCityResult(newSearchCityResponse);
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

    public interface ISearchCityView extends BaseView {
        //搜索城市返回数据  V7
        void getNewSearchCityResult(NewSearchCityResponse response);

        //错误返回
        void getDataFailed();
    }
}
