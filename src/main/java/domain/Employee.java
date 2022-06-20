package domain;

import javax.persistence.*;

@Entity
@Table
public class Employee extends User {


    @ManyToOne
    BankBranch bankBranch;


    private Integer workExperience;

    private  String degree;

    private String password;




    public Employee() {
    }

    public Employee (String firstName,String lastName, Integer workExperience , String degree,String password){

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.workExperience = workExperience;
        this.degree = degree;
        this.password = password;

    }


    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
