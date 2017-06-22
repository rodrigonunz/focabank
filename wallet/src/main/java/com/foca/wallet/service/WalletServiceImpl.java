package com.foca.wallet.service;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foca.model.jpa.Wallet;
import com.foca.model.jpa.Wallet.WalletBuilder;
import com.foca.wallet.repository.WalletRepository;

@Service
@Transactional
public class WalletServiceImpl implements WalletService {

	@Autowired
	WalletRepository repo;
	
	public void createWallet(String owner) {
		String walletId = UUID.randomUUID().toString();
		repo.save(new WalletBuilder().owner(owner).uid(walletId).build());
	}
	
	public BigDecimal balance(String walletId){
		Wallet find = repo.findOne(walletId);
		return find.getBalance();
	}
	
	public Wallet wallet(String owner){
		return repo.findByOwner(owner);
	}
	
	public void withdraw(String walletId, BigDecimal value){
		Wallet wallet = repo.findOne(walletId);
	}
	
	public void deposit(String walletId, BigDecimal value){
		
	}
	
}
