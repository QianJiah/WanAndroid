package raysharp.com.wanandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import raysharp.com.wanandroid.R;

/**
 * 启动页
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);     //设置透明动画
        alphaAnimation.setDuration(3000);   //设置动画时间

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("hao", "===animationStart==="+ animation.getStartTime());
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束干嘛呢
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();   //结束当前Activity
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e("hao", "===animationRepeat==="+animation.getStartOffset());
            }
        });
        //最后，控件启动动画
        findViewById(R.id.iv_splash).startAnimation(alphaAnimation);
    }
}
