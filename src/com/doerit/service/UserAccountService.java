package com.doerit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doerit.dao.UserAccountMapper;
import com.doerit.model.UserAccount;
import com.doerit.util.State;

@Service
public class UserAccountService {

	@Autowired
	private UserAccountMapper userAccountMapper;
	
	public int save(UserAccount u) {
		return userAccountMapper.insert(u);
	}
	
	public UserAccount viewByEmailAndPassword(String email, String password) {
		return userAccountMapper.findByEmailPasswordAndState(email, password, State.ACTIVE.getDatabaseValue());
	}
	
}
