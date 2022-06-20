package service;

import domain.BankAccount;
import domain.Turnover;

import java.time.LocalDate;
import java.util.List;

public interface TurnoverService {
    void turnoverCommit(Turnover turnover);



}
