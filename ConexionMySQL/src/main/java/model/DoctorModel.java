package model;

import java.sql.Date;

public class DoctorModel {
    private int doctorID;
    private String name;
    private Date birthdate;
    private String sex;
    private String nationality;
    private String civilStatus;
    private String address;
    private int phoneNumber;
    private String email;

    public DoctorModel(int doctorID, String name, Date birthdate, String sex, String nationality, String civilStatus, String address, int phoneNumber, String email) {
        this.doctorID = doctorID;
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        this.nationality = nationality;
        this.civilStatus = civilStatus;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSexo(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
