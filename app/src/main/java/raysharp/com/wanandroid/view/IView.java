package raysharp.com.wanandroid.view;

public interface IView {

    void showErrorMsg(String errMsg);

    void showLoading();

    void hideLoading();

    void showError();

    void showNoNetWork();

    void showEmpty();

    void showContent();

    void handleLoginSuccess();

    void handleLogoutSuccess();
}
