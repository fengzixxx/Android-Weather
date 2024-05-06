package com.h.goodweather.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.h.goodweather.R;
import com.h.goodweather.bean.CityResponse;

import java.util.List;

/**
 * 省列表适配器
 *
 * @author h
 */
public class ProvinceAdapter extends BaseQuickAdapter<CityResponse, BaseViewHolder> {
    public ProvinceAdapter(int layoutResId, @Nullable List<CityResponse> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CityResponse item) {
        //省名称
        helper.setText(R.id.tv_city, item.getName());
    }
}
