package uiLayer;

public class TimeTableCl {
    private int dayOrder;
    private String firstPeriod;
    private String secondPeriod;
    private String thirdPeriod;
    private String fourthPeriod;

    public TimeTableCl(int dayOrder, String firstPeriod, String secondPeriod, String thirdPeriod, String fourthPeriod) {
        this.dayOrder = dayOrder;
        this.firstPeriod = firstPeriod;
        this.secondPeriod = secondPeriod;
        this.thirdPeriod = thirdPeriod;
        this.fourthPeriod = fourthPeriod;
    }

    public int getDayOrder() {
        return dayOrder;
    }

    public String getFirstPeriod() {
        return firstPeriod;
    }

    public String getSecondPeriod() {
        return secondPeriod;
    }

    public String getThirdPeriod() {
        return thirdPeriod;
    }

    public String getFourthPeriod() {
        return fourthPeriod;
    }
}
