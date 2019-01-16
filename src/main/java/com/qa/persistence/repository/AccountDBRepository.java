package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public boolean createAccount(String firstName, String lastName, String accountNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(REQUIRED)
	public boolean deleteAccount(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(REQUIRED)
	public boolean updateAccount(int id, String firstName, String lastName, String accountNumber) {
		// TODO Auto-generated method stub
		return false;
	}

}
