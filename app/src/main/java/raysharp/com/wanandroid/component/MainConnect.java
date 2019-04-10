package raysharp.com.wanandroid.component;

import raysharp.com.wanandroid.presenter.IPresenter;
import raysharp.com.wanandroid.view.IView;

/**
 * MainActivity的联系纽带，扩展IView和IPresenter
 */
public interface MainConnect {

    interface MainView extends IView {

    }

    interface Presenter extends IPresenter<MainView> {

        boolean isDayMode();   //日间模式
    }

}
