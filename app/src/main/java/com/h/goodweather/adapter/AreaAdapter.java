package com.h.goodweather.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.h.goodweather.R;
import com.h.goodweather.bean.CityResponse;

import java.util.List;

/**
 * 区/县列表适配器
 *
 * @author h
 */
public class AreaAdapter extends BaseQuickAdapter<CityResponse.CityBean.AreaBean, BaseViewHolder> {
    public AreaAdapter(int layoutResId, @Nullable List<CityResponse.CityBean.AreaBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, CityResponse.CityBean.AreaBean item) {
        //区/县的名称
        helper.setText(R.id.tv_city, item.getName());
    }
}
