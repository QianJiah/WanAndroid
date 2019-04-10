package raysharp.com.wanandroid.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.classic.common.MultipleStatusView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import raysharp.com.wanandroid.R;
import raysharp.com.wanandroid.presenter.IPresenter;
import raysharp.com.wanandroid.utils.CommonUtil;
import raysharp.com.wanandroid.utils.ToastUtil;
import raysharp.com.wanandroid.view.IView;

public abstract class BaseActivity<T extends IPresenter> extends AbstractSimpleActivity implements IView{

    private MultipleStatusView multipleStatusView;

    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        AndroidInjection.inject(this);  //注册dagger2
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onViewCreated() {
//        ViewGroup mView = findViewById(R.id.normal_view);
//        if (mView != null) {
//            mView.setVisibility(View.GONE);
//        }
//        multipleStatusView = findViewById(R.id.custom_multiple_status_view);
        if (multipleStatusView != null) {
            multipleStatusView.setOnRetryClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.reload();
                }
            });
        }
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    /**
     * 重写fragmentation中SupportActivity 的返回键方法
     */
    @Override
    public void onBackPressedSupport() {
        CommonUtil.hideSoftKeyBoard(this, this.getWindow().getDecorView().getRootView());   //隐藏软键盘
        super.onBackPressedSupport();
    }


    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();    //解绑
            mPresenter = null;
        }
        hideLoading();  //隐藏Loading控件
        super.onDestroy();
    }

    /**
     * 以下都是实现IView接口的方法
     * @param errMsg
     */
    @Override
    public void showErrorMsg(String errMsg) {
        ToastUtil.showToast(this, errMsg);
    }

    /**
     * 显示加载中视图
     */
    @Override
    public void showLoading() {
        if (multipleStatusView != null) {
            multipleStatusView.showLoading();
        }
    }

    @Override
    public void hideLoading() {

    }

    /**
     * 显示错误视图
     */
    @Override
    public void showError() {
        if (multipleStatusView != null) {
            multipleStatusView.showError();
        }
    }

    /**
     * 显示无网络视图
     */
    @Override
    public void showNoNetWork() {
        if (multipleStatusView != null) {
            multipleStatusView.showNoNetwork();
        }
    }

    /**
     * 显示空视图
     */
    @Override
    public void showEmpty() {
        if (multipleStatusView != null) {
            multipleStatusView.showEmpty();
        }
    }

    /**
     * 显示内容视图
     */
    @Override
    public void showContent() {
        if (multipleStatusView == null) return;
        multipleStatusView.showContent();
    }

    /**
     * 处理登录成功的事件
     */
    @Override
    public void handleLoginSuccess() {

    }

    /**
     * 处理退出成功的事件
     */
    @Override
    public void handleLogoutSuccess() {

    }
}
