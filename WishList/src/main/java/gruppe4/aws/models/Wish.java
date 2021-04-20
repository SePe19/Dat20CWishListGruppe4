package gruppe4.aws.models;

public class Wish {
    private int wishID;
    private String wishName;
    private String wishComment;
    private String wishLink;
    private int wishRank;
    private double wishPrice;
    private String accountName;

    public Wish(int wishID, String wishName, String wishComment, String wishLink, int wishRank, double wishPrice, String accountName) {
        this.wishID = wishID;
        this.wishName = wishName;
        this.wishComment = wishComment;
        this.wishLink = wishLink;
        this.wishRank = wishRank;
        this.wishPrice = wishPrice;
        this.accountName = accountName;
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

    public int getWishRank() {
        return wishRank;
    }

    public void setWishRank(int wishRank) {
        this.wishRank = wishRank;
    }

    public double getWishPrice() {
        return wishPrice;
    }

    public void setWishPrice(double wishPrice) {
        this.wishPrice = wishPrice;
    }

    public int getWishID() {
        return wishID;
    }

    public void setWishID(int wishID) {
        this.wishID = wishID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "wishID=" + wishID +
                ", wishName='" + wishName + '\'' +
                ", wishComment='" + wishComment + '\'' +
                ", wishLink='" + wishLink + '\'' +
                ", wishRank=" + wishRank +
                ", wishPrice=" + wishPrice +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
