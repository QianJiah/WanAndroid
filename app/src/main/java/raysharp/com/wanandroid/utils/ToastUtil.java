package raysharp.com.wanandroid.utils;

import android.content.Context;
import android.widget.Toast;

import com.blankj.utilcode.util.StringUtils;

/**
 * 自定Toast
 */
public class ToastUtil {

    private static Toast mToast;

    /**
     * 不重复显示Toast
     * @param context
     * @param text
     * @param duration
     */
    public static void showToast(Context context, String text, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }

    public static void showToast(Context context, int resId, int duration) {
        showToast(context, StringUtils.getString(resId), duration);
    }

    /**
     * 默认Toast.Length_short
     * @param context
     * @param text
     */
    public static void showToast(Context context, String text) {
        showToast(context, text, Toast.LENGTH_SHORT);
    }

}
