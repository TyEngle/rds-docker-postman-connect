package com.keyin.qap;
//imported to use entity identifier
//imported to use relationship identifier
import javax.persistence.*;

import java.util.Date;
import java.util.List;

//Entity identifies that this class is to be an entity in the db
@Entity
public class Tournament {


    //the next few lines are what creates the PK's
    //for the entitites in the database
    @Id
    @SequenceGenerator(name = "tournament-sequence", sequenceName = "tournament-sequence", allocationSize = 1)
    @GeneratedValue(generator = "tournament_sequence")
    private long id;

    private Date startDate;
    private Date endDate;
    private String location;
    private double entryFee;
    private double prize;
    private String name;



    //a list of member objects called members
    //many members go to many tournaments making Many2Many relationship
    @ManyToMany
    private List<Member> members;
    //accesses member object list called members and returns everything
    public List<Member> getMembers(){

        return members;
    }
    //to set members, we access the list of member objects
    //and add a member through the parameters
    public void setMembers(List<Member> members){

        this.members = members;
    }

    @ManyToMany
    private List<Tournament> tournaments;

    public List<Tournament> getTournaments(){
        return tournaments;
    }
    public void setTournaments(List<Tournament> tournaments){
        this.tournaments = tournaments;
    }

//not an instance variable--created with 'persistence' library
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                ", entryFee=" + entryFee +
                ", prize=" + prize +
                ", members=" + members +
                '}';
    }
}
