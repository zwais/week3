package mcdull.com.week3;

import android.app.Application;
import android.content.Context;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import mcdull.com.week3.utile.OkHttpUtils;

public class ShopApplication extends Application {
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        DiskCacheConfig.Builder builder = DiskCacheConfig.newBuilder(this);
        builder.setBaseDirectoryPath(getCacheDir());
        DiskCacheConfig config = builder.build();
        ImagePipelineConfig build = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(config)
                .build();
        Fresco.initialize(this,build);
        sContext=this;
        initHttpHeader();
    }

    private void initHttpHeader() {

        OkHttpUtils.init();
    }
}
