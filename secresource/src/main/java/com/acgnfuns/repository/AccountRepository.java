package com.acgnfuns.repository;


import com.acgnfuns.domain.Account;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.Optional;

public interface AccountRepository extends Repository<Account, Long> {

    Collection<Account> findAll();
    Optional<Account> findByUsername(String username);
    Optional<Account> findById(Long id);
    Integer countByUsername(String username);
    Account save(Account account);
    void deleteAccountById(Long id);



}
