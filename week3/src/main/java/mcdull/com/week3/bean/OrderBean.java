package mcdull.com.week3.bean;

import java.util.List;

public class OrderBean {
     private String status;
     private String message;
     private List<Resultorder> result;
       public class Resultorder{
           private String orderId;
           private int userId;
           private int payMethod;
           private String payAmount;
           private String expressCompName;
           private long orderTime;
           private String expressSn;
           private int orderStatus;
           private List<DetailList>detailList;
               public class DetailList{
                   private int orderDetailId;
                   private int commodityId;
                   private String commodityName;
                   private int commodityCount;
                   private String commodityPic;
                   private String commodityPrice;
                   private int commentStatus;

                   public int getOrderDetailId() {
                       return orderDetailId;
                   }

                   public void setOrderDetailId( int orderDetailId ) {
                       this.orderDetailId = orderDetailId;
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

                   public int getCommodityCount() {
                       return commodityCount;
                   }

                   public void setCommodityCount( int commodityCount ) {
                       this.commodityCount = commodityCount;
                   }

                   public String getCommodityPic() {
                       return commodityPic;
                   }

                   public void setCommodityPic( String commodityPic ) {
                       this.commodityPic = commodityPic;
                   }

                   public String getCommodityPrice() {
                       return commodityPrice;
                   }

                   public void setCommodityPrice( String commodityPrice ) {
                       this.commodityPrice = commodityPrice;
                   }

                   public int getCommentStatus() {
                       return commentStatus;
                   }

                   public void setCommentStatus( int commentStatus ) {
                       this.commentStatus = commentStatus;
                   }
               }

           public String getOrderId() {
               return orderId;
           }

           public void setOrderId( String orderId ) {
               this.orderId = orderId;
           }

           public int getUserId() {
               return userId;
           }

           public void setUserId( int userId ) {
               this.userId = userId;
           }

           public int getPayMethod() {
               return payMethod;
           }

           public void setPayMethod( int payMethod ) {
               this.payMethod = payMethod;
           }

           public String getPayAmount() {
               return payAmount;
           }

           public void setPayAmount( String payAmount ) {
               this.payAmount = payAmount;
           }

           public String getExpressCompName() {
               return expressCompName;
           }

           public void setExpressCompName( String expressCompName ) {
               this.expressCompName = expressCompName;
           }

           public long getOrderTime() {
               return orderTime;
           }

           public void setOrderTime( long orderTime ) {
               this.orderTime = orderTime;
           }

           public String getExpressSn() {
               return expressSn;
           }

           public void setExpressSn( String expressSn ) {
               this.expressSn = expressSn;
           }

           public int getOrderStatus() {
               return orderStatus;
           }

           public void setOrderStatus( int orderStatus ) {
               this.orderStatus = orderStatus;
           }

           public List<DetailList> getDetailList() {
               return detailList;
           }

           public void setDetailList( List<DetailList> detailList ) {
               this.detailList = detailList;
           }
       }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

    public List<Resultorder> getResult() {
        return result;
    }

    public void setResult( List<Resultorder> result ) {
        this.result = result;
    }
}
