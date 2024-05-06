package com.h.mvplibrary.mvp;

import android.os.Bundle;

import com.h.mvplibrary.base.BaseActivity;
import com.h.mvplibrary.base.BasePresenter;
import com.h.mvplibrary.base.BaseView;

/**
 * 适用于需要访问网络接口的Activity
 *
 * @author h
 */

public abstract class MvpActivity<P extends BasePresenter> extends BaseActivity {
    protected P mPresent;

    @Override
    public void initBeforeView(Bundle savedInstanceState) {
        mPresent = createPresent();
        mPresent.attach((BaseView) this);
    }

    protected abstract P createPresent();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresent.detach((BaseView) this);
    }

}
