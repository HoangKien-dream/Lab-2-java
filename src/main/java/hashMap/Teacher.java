package hashMap;

import java.util.Date;

public class Teacher {
    private String rollNumber;
    private String nameTeacher;
    private Date date;
    private int amount;

    public Teacher() {
    }

    public Teacher(String rollNumber, String nameTeacher, String dateString, int amount) {
        this.rollNumber = rollNumber;
        this.nameTeacher = nameTeacher;
        this.date = DateTimeUtil.parseDateString(dateString);
        this.amount = amount;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getDateString(){
        return DateTimeUtil.formatDateToString(date);
    }
    @Override
    public String toString() {
        return String.format("%5s%20s%5s | %1s%21s%14s | %8s%10s%8s \n",
                "",getRollNumber(), "",
                "",getNameTeacher(), "",
                "",getAmount(), "");
    }
}

