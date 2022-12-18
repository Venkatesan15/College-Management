package uiLayer;

public class Complaint {
    private String date;
    private String rollNumber;
    private String query;

    public Complaint(String date, String rollNumber, String query) {
        this.date = date;
        this.rollNumber = rollNumber;
        this.query = query;
    }

    public String getDate() {
        return date;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getQuery() {
        return query;
    }
}
