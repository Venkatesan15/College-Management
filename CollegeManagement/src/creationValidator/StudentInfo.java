package creationValidator;

import middleLayer.StudentsProfile;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class StudentInfo {
    Scanner sc=new Scanner(System.in);
    StudentsProfile studentsProfileObj =new StudentsProfile();
    public String enterRollNumber()
    {
        System.out.print("Please Enter Student Roll Number : ");
        String rollNumber=sc.nextLine();
        if(studentsProfileObj.isRollNumberOrNameExists(rollNumber))
        {
            System.out.println("This Roll Number Already Registered");
            return  enterRollNumber();
        }
        return rollNumber;
    }
    public String enterName()
    {
        System.out.print("Please enter Student Name only in CAPITAL letters : ");
        String name=sc.nextLine();
        if(Validator.checkValidName(name))
        {
            if(studentsProfileObj.isRollNumberOrNameExists(name))
            {
                System.out.println("This Name Is Already Registered");
                return enterName();
            }
        }
        else
        {
            System.out.println("Please enter valid name");
            return enterName();
        }
        return name;
    }
    public String enterGender()
    {
        int gender;
        System.out.println("Male------>1");
        System.out.println("Female---->2");
        System.out.println("Other----->3");
        gender= OnlyInt.onlyInt();
        if(Validator.checkValidGender(gender))
        {
            if(gender==1) {
                return "Male";
            }
            else if(gender==2)
            {
                return "Female";
            }
            else
            {
                return "Other";
            }
        }
        else {
            System.out.println("Please Select Valid gender : ");
            return enterGender();
        }
    }
    public String enterPhoneNumber()
    {
        System.out.print("Please enter ur phone number must be 10 digits  : ");
        Scanner scan=new Scanner(System.in);
        String phoneNumber= scan.nextLine();
        boolean isValidPhNo= Validator.isPhNoHaveTenDigit(phoneNumber);
        if(isValidPhNo) {
            return phoneNumber;
        }
        else
        {
            System.out.print("Please enter valid Phone number : ");
            return enterPhoneNumber();
        }
    }
    public String studentDOB()
    {
        System.out.print("Please enter Student Date Of Birth like yyyy-mm-dd : ");
        return getDate();
    }
    public String getDate()
    {
        String date =sc.nextLine();
        boolean isValidDate= Validator.checkValidDate(date);
        if(isValidDate)
        {
            return date;
        }
        else {
            System.out.print("Please Enter valid Date : ");
            return getDate();
        }
    }
    public int getAge(String dob)
    {
        LocalDate birthDate= LocalDate.parse(dob);
        LocalDate todayDate=LocalDate.now();
        if((birthDate!=null)&&(todayDate!=null))
        {
            return Period.between(birthDate,todayDate).getYears();
        }
        else {
            return 0;
        }
    }
}
