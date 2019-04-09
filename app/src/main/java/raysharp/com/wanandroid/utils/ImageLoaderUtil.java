package raysharp.com.wanandroid.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import raysharp.com.wanandroid.R;

public class ImageLoaderUtil {

    public static void loadImage(Context context, String url, ImageView iv) {
        GlideApp.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .transition(DrawableTransitionOptions.withCrossFade())  //过渡动画
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(iv);
    }
}
