package com.qa.persistence.repository;

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
	public String createAccount(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAccount(Long id, String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
