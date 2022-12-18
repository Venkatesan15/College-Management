package uiLayer;

public class AttendanceCl {
    private String rollNumber;
    private String date;
    private String status;



    public AttendanceCl(String rollNumber, String date, String status) {
        this.rollNumber = rollNumber;
        this.date = date;
        this.status = status;
    }
    public String getRollNumber() {
        return rollNumber;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

}
