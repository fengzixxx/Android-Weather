package com.h.goodweather.adapter;


import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.h.goodweather.R;
import com.h.mvplibrary.bean.ResidentCity;

import java.util.List;

/**
 * 主页面左右滑动切换常用城市列表适配器
 *
 * @author h
 */
public class MainChangeCommonlyCityAdapter extends BaseQuickAdapter<ResidentCity, BaseViewHolder> {
    public MainChangeCommonlyCityAdapter(int layoutResId, @Nullable List<ResidentCity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ResidentCity item) {
        helper.setText(R.id.tv_city, item.getLocation());
    }
}
