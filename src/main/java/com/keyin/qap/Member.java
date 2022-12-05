package com.keyin.qap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Date;


//Entity identifies that this class is to be an entity in the db
@Entity
public class Member {
    //following code used by persistence to create PK's
    @Id
    @SequenceGenerator(name = "member-sequence", sequenceName = "member-sequence", allocationSize = 1)
    @GeneratedValue(generator = "member-sequence")
    private long id;

    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private Date membershipStartDate;
    private double membershipDuration;
    private String fullName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFullName(String newFullName){
        this.fullName = newFullName;

    }
    public String getFullName(){
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(Date membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public double getMembershipDuration() {
        return membershipDuration;
    }

    public void setMembershipDuration(double membershipDuration) {
        this.membershipDuration = membershipDuration;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", membershipStartDate=" + membershipStartDate +
                ", membershipDuration=" + membershipDuration +
                '}';
    }
}
