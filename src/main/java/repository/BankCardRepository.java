package repository;

import domain.BankCart;

public interface BankCardRepository extends BaseRepository<BankCart, Long> {

    BankCart findById(Long id);
}
