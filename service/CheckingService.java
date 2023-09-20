package service;

import java.math.BigDecimal;

import pojo.Account;
import pojo.Checking;
import repository.AccountRepository;

public class CheckingService implements AccountService {
        
    AccountRepository accountRepository;

    public CheckingService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Checking account) {
        this.accountRepository.createAccount(account);
    }

    public Account retrieveAccount(String id) {
        return (Checking)this.accountRepository.retrieveAccount(id);
    }

    public void updateAccount(Checking account) {
       this.accountRepository.updateAccount(account);
    }

    public void deleteAccount(String id) {
        this.accountRepository.deleteAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        Checking checking = (Checking)this.retrieveAccount(id);
        checking.setBalance(checking.getBalance().add(amount));
        this.updateAccount(checking);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
       Checking checking = (Checking)this.retrieveAccount(id);
       checking.setBalance(checking.getBalance().subtract(amount));
       this.updateAccount(checking);
    }


}
