package domain;

import javax.persistence.*;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_balance")
    private Long accountBalance;


    @ManyToOne
    @JoinColumn(name = "account_owner_id")
    private User accountOwner;

    @OneToOne(cascade = CascadeType.ALL)
    private BankCart cart;


    @ManyToOne
    @JoinColumn(name = "bank_branch_id")
    private BankBranch bankBranch;
    @Column(length = 4)
    private String password;



    public BankAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public User getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(User accountOwner) {
        this.accountOwner = accountOwner;
    }

    public BankCart getCart() {
        return cart;
    }

    public void setCart(BankCart cart) {
        this.cart = cart;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountBalance=" + accountBalance +
                ", bankBranch=" + bankBranch +
                '}';
    }
}
