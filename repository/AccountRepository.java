package repository;

import java.util.HashMap;
import java.util.Map;

import pojo.Account;
import pojo.Checking;
import pojo.Credit;

public class AccountRepository {

    private Map<String, Account> datastore = new HashMap<>();

    public void createAccount(Account account) {
       this.datastore.put(account.getId(), account.clone());
    }

    public Account retrieveAccount(String id) {
        return this.datastore.get(id).clone();
    }

    public void updateAccount(Account account) {
        this.datastore.put(account.getId(), account.clone());
    }

    public void deleteAccount(String id) {
        this.datastore.remove(id);
    }

    public void print(){
        this.datastore.forEach((a, b)-> {
            if(b instanceof Checking) {
                  System.out.println(b.getClass().getSimpleName() + ", " + b.getId() + ": " + ((Checking)b).getBalance());
            } else {
                System.out.println(b.getClass().getSimpleName() + ", " + b.getId() + ": " + ((Credit)b).getCredit());
            }
        });
    }

}

