package raysharp.com.wanandroid.presenter;

import raysharp.com.wanandroid.view.IView;

public interface IPresenter<T extends IView> {

    void attachView(T view);

    void detachView();

    void reload();

    void registerEventBus();

    void unregisterEventBus();

    void setLoginStatus(boolean isLogin);

    boolean getLoginStatus();

    void setLoginAccount(String account);

    String getLoginAccount();

}
