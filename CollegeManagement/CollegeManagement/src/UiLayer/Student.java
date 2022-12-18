package UiLayer;

public class Student {
    private String rollNo;
    private String name;
    private String gender;
    private String phNo;
    private String dob;
    private int age;



    public Student(String rollNo, String name, String gender, String phNo, String dob, int age)
    {

        this.rollNo=rollNo;
        this.name=name;
        this.gender=gender;
        this.phNo=phNo;
        this.dob=dob;
        this.age=age;
    }
    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhNo() {
        return phNo;
    }

    public String getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }


}
