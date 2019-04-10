package raysharp.com.wanandroid.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;
import raysharp.com.wanandroid.R;

public abstract class AbstractSimpleActivity extends SupportActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("hao","======layoutID===="+getLayoutId());
        setContentView(getLayoutId());
        ImmersionBar.with(this)
                .statusBarView(findViewById(R.id.status_bar_view))
                .keyboardEnable(true)
                .init();
        unbinder = ButterKnife.bind(this);
        onViewCreated();
        initToolbar();
        initView();
        initEventAndData();
    }

    /**
     * 初始化事件和数据
     */
    protected abstract void initEventAndData();

    protected abstract void initView();

    /**
     * 初始化ToolBar
     */
    protected abstract void initToolbar();

    protected abstract void onViewCreated();

    /**
     *
     * @return 获取当前布局的id
     */
    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();  //防止内存泄露
        if (unbinder != null && unbinder != Unbinder.EMPTY) {   //解绑ButterKnife
            unbinder.unbind();
            unbinder = null;
        }
    }
}
