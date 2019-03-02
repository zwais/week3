package mcdull.com.week3.view;

import mcdull.com.week3.bean.ShopBean;

public interface ShopView {
    void successful(ShopBean data);
    void failed(Exception e);
}
