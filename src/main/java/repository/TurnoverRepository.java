package repository;

import domain.BankAccount;
import domain.Turnover;

import java.time.LocalDate;
import java.util.List;

public interface TurnoverRepository extends BaseRepository<Turnover, Integer> {
    List<Turnover> viewTurnoversWithCustomDate(Long sourceBankAccountId, LocalDate dateFrom);


}
