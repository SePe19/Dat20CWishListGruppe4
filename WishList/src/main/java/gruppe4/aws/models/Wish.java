package gruppe4.aws.models;

public class Wish {
    private String wishName;
    private String wishComment;
    private String wishLink;
    private String wishRank;
    private String wishPrice;

    public Wish(String wishName, String wishComment, String wishLink, String wishRank, String wishPrice) {
        this.wishName = wishName;
        this.wishComment = wishComment;
        this.wishLink = wishLink;
        this.wishRank = wishRank;
        this.wishPrice = wishPrice;
    }

    public String getWishName() {
        return wishName;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }

    public String getWishComment() {
        return wishComment;
    }

    public void setWishComment(String wishComment) {
        this.wishComment = wishComment;
    }

    public String getWishLink() {
        return wishLink;
    }

    public void setWishLink(String wishLink) {
        this.wishLink = wishLink;
    }

    public String getWishRank() {
        return wishRank;
    }

    public void setWishRank(String wishRank) {
        this.wishRank = wishRank;
    }

    public String getWishPrice() {
        return wishPrice;
    }

    public void setWishPrice(String wishPrice) {
        this.wishPrice = wishPrice;
    }
}
