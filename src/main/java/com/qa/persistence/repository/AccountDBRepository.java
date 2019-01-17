package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED; 
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllAccounts() {
		Query query = manager.createQuery("SELECT a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(Account account) {
		manager.persist(account);
		return "{\"message\": \"account sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(String accountNumber) {
		Account accountInDB = findAccount(accountNumber);
		if (accountInDB != null) {
			manager.remove(accountInDB);
			return "{\"message\": \"account sucessfully deleted\"}";
		}
		return "{\"message\": \"account does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Account account) {
		Account accountInDB = findAccount(account.getAccountNumber());
		if (accountInDB != null) {
			manager.remove(accountInDB);
			manager.persist(account);
			return "{\"message\": \"account sucessfully updated\"}";
		}
		return "{\"message\": \"account does not exist\"}";
	}
	
	private Account findAccount(String accountNumber) {
		Query query = manager.createQuery("SELECT a FROM Account a WHERE accountNumber = " + accountNumber);
		return (Account) query.getSingleResult();
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;		
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}
