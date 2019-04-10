package raysharp.com.wanandroid.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import raysharp.com.wanandroid.R;
import raysharp.com.wanandroid.component.MainConnect;
import raysharp.com.wanandroid.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainConnect.MainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    @BindView(R.id.float_btn)
    FloatingActionButton floatBtn;
    @BindView(R.id.bottom_menu)
    BottomNavigationView bottomMenu;
    @BindView(R.id.nav_menu)
    NavigationView navMenu;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initEventAndData() {

    }

    /**
     * 第三步，初始化View
     */
    @Override
    protected void initView() {
        initDrawerLayout();          //drawerLayout
        showFragment(0);       //展示首页
        initNavigationView();       //侧栏菜单
        initBottomNavigationView(); //底部菜单

    }

    private void initDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
    }

    private void showFragment(int page) {

    }

    private TextView mUserTv;   //用户TextView，显示在标题栏

    /**
     * 左侧菜单栏的点击事件初始化
     */
    private void initNavigationView() {
        navMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.favorite:     //收藏
                        break;
                    case R.id.todo:         //TODO
                        break;
                    case R.id.day_night:    //日夜间模式切换
                        break;
                    case R.id.setting:      //设置
                        break;
                    case R.id.about:        //关于
                        break;
                }
                return true;
            }
        });
        int count = navMenu.getHeaderCount();
        Log.e("hao", "--headerCount-->" + count + " ,childCount = " + navMenu.getChildCount());
        mUserTv = navMenu.getHeaderView(0).findViewById(R.id.tv_login);
        mUserTv.setText(/*mPresenter.getLoginStatus() ? mPresenter.getLoginAccount() : */"登录");
        mUserTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动登录页面
            }
        });
        navMenu.getMenu().findItem(R.id.logout).setVisible(true);   //退出按钮是否显示
        MenuItem menuItem = navMenu.getMenu().findItem(R.id.day_night);    //日夜间模式
        if (/*mPresenter.isDayMode()*/true) {   //日间模式
            menuItem.setIcon(R.drawable.ic_night);
            menuItem.setTitle("夜间模式");
        } else {    //夜间模式
            menuItem.setIcon(R.drawable.ic_day);
            menuItem.setTitle("日间模式");
        }

    }

    /**
     * 底部菜单点击切换
     */
    private void initBottomNavigationView() {
        bottomMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home_page:    //主页
                        showFragment(1);
                        break;
                    case R.id.knowledge:    //知识框架
                        showFragment(2);
                        break;
                    case R.id.navigation:   //导航
                        showFragment(3);
                        break;
                    case R.id.friends:      //公众号
                        showFragment(4);
                        break;
                    case R.id.project:      //项目
                        showFragment(5);
                        break;
                }
                return true;
            }
        });
    }

    /**
     * 第一步在BaseActivity中，onViewCreated()
     * 第二步，初始化toolbar
     */
    @Override
    protected void initToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
//            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
//            toolbar.setTitle("首页");
//            actionBar.setDisplayHomeAsUpEnabled(false);
            toolbarTitle.setText("主页");
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
