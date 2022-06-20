package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class BankBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    @OneToOne

    Employee chief;



    public BankBranch() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getChief() {
        return chief;
    }

    public void setChief(Employee chief) {
        this.chief = chief;
    }

    @Override
    public String toString() {
        return "BankBranch{" +
                "id=" + id +
                ", chief=" + chief +
                '}';
    }
}
