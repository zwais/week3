package mcdull.com.week3.bean;

import java.util.List;

public class ShopBean {
    private String status;
    private String message;
    private List<Resultlist> result;
    public class Resultlist{
        private int commodityId;
        private String commodityName;
        private String pic;
        private String price;
        private int count;

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

        public String getPic() {
            return pic;
        }

        public void setPic( String pic ) {
            this.pic = pic;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice( String price ) {
            this.price = price;
        }

        public int getCount() {
            return count;
        }

        public void setCount( int count ) {
            this.count = count;
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

    public List<Resultlist> getResult() {
        return result;
    }

    public void setResult( List<Resultlist> result ) {
        this.result = result;
    }
}
