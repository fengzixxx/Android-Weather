package com.h.mvplibrary.mvp;


import android.os.Bundle;
import com.h.mvplibrary.base.BaseFragment;
import com.h.mvplibrary.base.BasePresenter;
import com.h.mvplibrary.base.BaseView;
/**
 * 适用于需要访问网络接口的Fragment
 */
public abstract class MvpFragment<P extends BasePresenter> extends BaseFragment {
    protected P mPresent;
    @Override
    public void initBeforeView(Bundle savedInstanceState) {
        mPresent=createPresent();
        mPresent.attach((BaseView) this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresent!=null){
            mPresent.detach((BaseView) this);
        }
    }

    protected abstract P createPresent();


}
