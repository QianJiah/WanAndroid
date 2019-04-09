package raysharp.com.wanandroid;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);       //初始化AndroidUtilCode库
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
