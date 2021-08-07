
public class Item {
    private String productName;
    private String productDetail;
    private String imageLink;
    private String price;
    private int star;
    private String merchant;

    public Item(String productName, String productDetail, String imageLink, String price, Integer star, String merchant) {
        this.productName = productName;
        this.productDetail = productDetail;
        this.imageLink = imageLink;
        this.price = price;
        this.star = star;
        this.merchant = merchant;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }
}
