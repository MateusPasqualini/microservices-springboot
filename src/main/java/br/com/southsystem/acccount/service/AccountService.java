package br.com.southsystem.acccount.service;

import br.com.southsystem.acccount.entity.Account;
import br.com.southsystem.acccount.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account create(Account account) throws Exception {
        if (Objects.isNull(account.getNumber())) {
            throw new Exception("Account number null");
        }
        return repository.save(account);
    }

    public Page<Account> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public Optional<Account> find(String id) {
        return repository.findById(id);
    }

    public Account update(String id, Account account) throws Exception {
        Optional<Account> dbAccount = repository.findById(id);
        if (!dbAccount.isPresent()){
            throw new Exception("Account not found");
        }
        Account accountDb = dbAccount.get();
        accountDb.setNumber(account.getNumber());
        accountDb.setAgency(account.getAgency());
        accountDb.setCpf(account.getCpf());
        return repository.save(accountDb);
    }
}
