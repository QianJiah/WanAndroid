package raysharp.com.wanandroid.presenter;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

import raysharp.com.wanandroid.component.MainConnect;

public class MainPresenter extends BasePresenter<MainConnect.MainView> implements MainConnect.Presenter{

    @Inject
    public MainPresenter() {

    }

    @Override
    public void registerEventBus() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void unregisterEventBus() {
        EventBus.getDefault().unregister(this);
    }


    @Override
    public boolean isDayMode() {
        return false;
    }
}
