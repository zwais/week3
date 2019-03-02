package mcdull.com.week3.utile;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Request;
import okhttp3.Callback;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {
    private static Gson gson=new Gson();
    private static final String MEDIA_TYPE="application/json; charset=utf_8";
    private static final String METHOD_GET="GET";
    private static final String METHOD_POST="POST";
    private static final String METHOD_PUT="PUT";
    private static final String METHOD_DELETE="DELETE";
    private static OkHttpClient okHttpClient;
    private OkHttpUtils(){
    }
    public static void init(){
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.readTimeout(3000, TimeUnit.MILLISECONDS);
        builder.writeTimeout(3000,TimeUnit.MILLISECONDS);
        builder.connectTimeout(3000,TimeUnit.MILLISECONDS);
        builder.addInterceptor(new OKHeaderInterceptor());
        builder.addInterceptor(interceptor);
        okHttpClient=builder.build();
    }
    private static Request createRequest(String url, String method, BaseRequest baseRequest){
        RequestBody requestBody=null;
        if (baseRequest!=null){
            String bodyJson=gson.toJson(baseRequest);
            MediaType JSON=MediaType.parse(MEDIA_TYPE);
            requestBody = RequestBody.create(JSON,bodyJson);
        }
        Request.Builder builder=new Request.Builder().url(url);
        Request request=null;
        switch (method){
            case METHOD_GET:
                request=builder.get().build();
                break;
            case METHOD_POST:
                request=builder.post(requestBody).build();
                break;
            case METHOD_PUT:
                if (requestBody!=null){
                    request=builder.put(requestBody).build();
                }
                break;
            case METHOD_DELETE:
                if (requestBody!=null){
                    request=builder.delete(requestBody).build();
                }else {
                    request=builder.delete().build();
                }
                break;
        }
        return request;
    }
    public static Request createRequestPost(String url, String method, Map<String,String> map){
        FormBody.Builder form=new FormBody.Builder();
        Set set=map.keySet();
        Iterator iterator = set.iterator();
        String logString="";
        while (iterator.hasNext()){
            String next= (String) iterator.next();
            form.add(next,map.get(next));
            logString+=next+":"+map.get(next)+"/n";
        }

        FormBody formBody = form.build();
        Request.Builder builder=new Request.Builder().url(url);
        Request request=null;
        switch (method){
            case METHOD_GET:
                request=builder.get().build();
                break;
            case METHOD_POST:
                request=builder.post(formBody).build();
                break;
            case METHOD_PUT:
                if (formBody!=null){
                    request=builder.put(formBody).build();
                }
                break;
            case METHOD_DELETE:
                if (formBody!=null){
                    request=builder.delete(formBody).build();
                }else {
                    request=builder.delete().build();
                }
                break;
        }
        return request;
    }
    //异步post方法
    public static void enqueuePost(String url, Map map, Callback callback, Type type){
        Request request=createRequestPost(url,METHOD_POST,map);
        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    //异步put方法
    public static void enqueuPut(String url,Map map,Callback callback,Type type){
        Request request=createRequestPost(url,METHOD_PUT,map);
        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    //同步post方法
    public static Response executePost(String url,BaseRequest baseRequest) throws IOException {
        Request request=createRequest(url,METHOD_POST,baseRequest);
        Call call=okHttpClient.newCall(request);
        Response response=call.execute();
        return response;
    }
    //异步get方法
    public static void enqueuGet(String url,Callback callback,Type type){
        Request request=createRequest(url,METHOD_GET,null);
        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    //异步delete方法
    public static void enqueuDelete(String url,Callback callback,Type type){
        Request request=createRequest(url,METHOD_DELETE,null);
        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    //同步get方法
    public static Response executeGet(String url) throws IOException {
        Request request=createRequest(url,METHOD_GET,null);
        Call call=okHttpClient.newCall(request);
        Response response=call.execute();
        return response;
    }
}
