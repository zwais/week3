package mcdull.com.week3.presenter;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import mcdull.com.week3.CallBack.ICallBack;
import mcdull.com.week3.bean.ShopBean;
import mcdull.com.week3.model.ShopModel;
import mcdull.com.week3.view.ShopView;

public class ShopPresenter {
    private ShopView sv;
    private ShopModel model;
    public void attach(ShopView sv){
        this.sv=sv;
        model=new ShopModel();
    }

    public void getData(){
        Type type=new TypeToken<ShopBean>(){}.getType();
        model.getData(new ICallBack() {
            @Override
            public void successful(Object o) {
                ShopBean data= (ShopBean) o;
                if (data!=null & "0000".equals(data.getStatus())){
                    sv.successful(data);
                }
            }

            @Override
            public void failed(Exception e) {
                sv.failed(e);
            }
        },type);
    }

    public void detach(){
        if (sv!=null){
            sv=null;
        }
    }
}
