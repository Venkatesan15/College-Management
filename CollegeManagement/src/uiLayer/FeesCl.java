package uiLayer;

public class FeesCl {


    private String particular;
    private long amount;
    private String lastDate;

    public FeesCl(String particular, long amount, String lastDate) {
        this.particular = particular;
        this.amount = amount;
        this.lastDate = lastDate;
    }

    public String getParticular() {
        return particular;
    }

    public long getAmount() {
        return amount;
    }

    public String getLastDate() {
        return lastDate;
    }
}
