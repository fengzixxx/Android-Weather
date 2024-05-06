package com.h.mvplibrary.mvp;

import android.os.Bundle;

import androidx.viewbinding.ViewBinding;

import com.h.mvplibrary.base.BasePresenter;
import com.h.mvplibrary.base.vb.BaseVBActivity;
import com.h.mvplibrary.base.BaseView;

/**
 * 适用于需要访问网络接口的Activity
 *
 * @author h
 */

public abstract class MvpVBActivity<T extends ViewBinding, P extends BasePresenter> extends BaseVBActivity<T> {

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
