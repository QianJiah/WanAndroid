package raysharp.com.wanandroid.presenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import raysharp.com.wanandroid.view.IView;

public class BasePresenter<T extends IView> implements IPresenter<T> {

    protected T mView;

    private CompositeDisposable compositeDisposable;


    @Override
    public void attachView(T view) {
        this.mView = view;
        registerEventBus();
    }

    @Override
    public void detachView() {
        this.mView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
        unregisterEventBus();
    }

    @Override
    public void reload() {

    }

    @Override
    public void registerEventBus() {

    }

    @Override
    public void unregisterEventBus() {

    }

    @Override
    public void setLoginStatus(boolean isLogin) {

    }

    @Override
    public boolean getLoginStatus() {
        return false;
    }

    @Override
    public void setLoginAccount(String account) {

    }

    @Override
    public String getLoginAccount() {
        return null;
    }

    /**
     * 添加订阅关系到一次性容器
     * @param disposable
     */
    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
}
