package mcdull.com.week3.model;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import mcdull.com.week3.CallBack.ICallBack;
import mcdull.com.week3.utile.OkHttpUtils;
import mcdull.com.week3.utile.UtilsUrl;

public class ShopModel {
    Handler handler=new Handler();
    public void getData( final ICallBack callBack, final Type type){
        OkHttpUtils.enqueuGet(UtilsUrl.shopCartUrl, new Callback() {
            @Override
            public void onFailure( Call call, final IOException e ) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.failed(e);
                    }
                });
            }

            @Override
            public void onResponse( Call call, Response response ) throws IOException {
                String result = response.body().string();
                Gson gson=new Gson();
                final Object o = gson.fromJson(result, type);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.successful(o);
                    }
                });
            }
        },type);
    }
}
