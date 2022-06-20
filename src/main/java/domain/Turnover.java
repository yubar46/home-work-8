package domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Turnover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "transaction_amount")
    private Long transactionAmount;


    @ManyToOne(cascade = CascadeType.ALL)
    private BankAccount source;


    @OneToOne(cascade = CascadeType.ALL)
    private BankAccount destination;

    @Column
    private LocalDate date ;

    private LocalTime time;

    public Turnover() {
        this.time = LocalTime.now();
        this.date = LocalDate.now();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public BankAccount getSource() {
        return source;
    }

    public void setSource(BankAccount source) {
        this.source = source;
    }

    public BankAccount getDestination() {
        return destination;
    }

    public void setDestination(BankAccount destination) {
        this.destination = destination;
    }


    @Override
    public String toString() {
        return "Turnover{" +
                "transactionAmount=" + transactionAmount +
                ", destination=" + destination.getCart().getId() +
                ", owner card=" + destination.getAccountOwner().getFirstName() + " "+destination.getAccountOwner().getLastName()+
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
