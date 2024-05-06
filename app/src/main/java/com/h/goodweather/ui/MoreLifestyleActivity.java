package com.h.goodweather.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.h.goodweather.R;
import com.h.goodweather.adapter.MoreLifestyleAdapter;
import com.h.goodweather.bean.LifestyleResponse;
import com.h.goodweather.contract.MoreLifestyleContract;
import com.h.goodweather.databinding.ActivityMoreLifestyleBinding;
import com.h.goodweather.utils.CodeToStringUtils;
import com.h.goodweather.utils.Constant;
import com.h.goodweather.utils.StatusBarUtil;
import com.h.goodweather.utils.ToastUtils;
import com.h.mvplibrary.mvp.MvpVBActivity;
import java.util.List;


import static com.h.mvplibrary.utils.RecyclerViewAnimation.runLayoutAnimation;

/**
 * 更多生活指数信息
 *
 * @author h
 */
public class MoreLifestyleActivity extends MvpVBActivity<ActivityMoreLifestyleBinding, MoreLifestyleContract.MoreLifestylePresenter> implements MoreLifestyleContract.IMoreLifestyleView {

    @Override
    public void initData() {
        //透明状态栏
        StatusBarUtil.transparencyBar(context);
        Back(binding.toolbar);
        showLoadingDialog();
        binding.tvTitle.setText(getIntent().getStringExtra("cityName"));
        //更多生活指数
        mPresent.lifestyle(getIntent().getStringExtra("locationId"));
    }

    @Override
    protected MoreLifestyleContract.MoreLifestylePresenter createPresent() {
        return new MoreLifestyleContract.MoreLifestylePresenter();
    }

    /**
     * 更多生活质量数据返回
     */
    @Override
    public void getMoreLifestyleResult(LifestyleResponse response) {
        dismissLoadingDialog();
        if (response.getCode().equals(Constant.SUCCESS_CODE)) {
            List<LifestyleResponse.DailyBean> data = response.getDaily();
            if (data != null && data.size() > 0) {
                MoreLifestyleAdapter adapter = new MoreLifestyleAdapter(R.layout.item_more_lifestyle_list, data);
                binding.rv.setLayoutManager(new LinearLayoutManager(context));
                binding.rv.setAdapter(adapter);
                runLayoutAnimation(binding.rv);
            } else {
                ToastUtils.showShortToast(context, "生活质量数据为空");
            }
        } else {
            ToastUtils.showShortToast(context, CodeToStringUtils.WeatherCode(response.getCode()));
        }
    }

    /**
     * 其他异常返回
     */
    @Override
    public void getDataFailed() {
        dismissLoadingDialog();
        ToastUtils.showShortToast(context, "更多天气数据获取异常");
    }

}
