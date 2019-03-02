package mcdull.com.week3.bean;

import android.os.Message;

import java.util.List;

public class ShopXQBean {
     private List<ResultBean>results;
     private String Message;
     private String status;
     public class ResultBean{
         private String categoryId;
         private String categoryName;
         private String  commentNum;
         private int commodityId;
         private String commodityName;
         private String describe;
         private String picture;
         private int price;
         private int saleNum;
         private String stock;
         private int weight;

         public String getCategoryId() {
             return categoryId;
         }

         public void setCategoryId( String categoryId ) {
             this.categoryId = categoryId;
         }

         public String getCategoryName() {
             return categoryName;
         }

         public void setCategoryName( String categoryName ) {
             this.categoryName = categoryName;
         }

         public String getCommentNum() {
             return commentNum;
         }

         public void setCommentNum( String commentNum ) {
             this.commentNum = commentNum;
         }

         public int getCommodityId() {
             return commodityId;
         }

         public void setCommodityId( int commodityId ) {
             this.commodityId = commodityId;
         }

         public String getCommodityName() {
             return commodityName;
         }

         public void setCommodityName( String commodityName ) {
             this.commodityName = commodityName;
         }

         public String getDescribe() {
             return describe;
         }

         public void setDescribe( String describe ) {
             this.describe = describe;
         }

         public String getPicture() {
             return picture;
         }

         public void setPicture( String picture ) {
             this.picture = picture;
         }

         public int getPrice() {
             return price;
         }

         public void setPrice( int price ) {
             this.price = price;
         }

         public int getSaleNum() {
             return saleNum;
         }

         public void setSaleNum( int saleNum ) {
             this.saleNum = saleNum;
         }

         public String getStock() {
             return stock;
         }

         public void setStock( String stock ) {
             this.stock = stock;
         }

         public int getWeight() {
             return weight;
         }

         public void setWeight( int weight ) {
             this.weight = weight;
         }
     }

    public List<ResultBean> getResults() {
        return results;
    }

    public void setResults( List<ResultBean> results ) {
        this.results = results;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage( String message ) {
        Message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }
}
