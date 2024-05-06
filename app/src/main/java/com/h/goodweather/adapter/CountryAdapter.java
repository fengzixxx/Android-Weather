package com.h.goodweather.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.h.goodweather.R;
import com.h.mvplibrary.bean.Country;

import java.util.List;

/**
 * 国家列表适配器
 *
 * @author h
 */

public class CountryAdapter extends BaseQuickAdapter<Country, BaseViewHolder> {
    public CountryAdapter(int layoutResId, @Nullable List<Country> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Country item) {
        //设置名称
        helper.setText(R.id.tv_country_name, item.getName());
    }
}
