package com.foca.wallet.rest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foca.model.jpa.Wallet;
import com.foca.wallet.service.WalletService;

@RestController("/api")
public class WalletController {
	
	@Autowired
	WalletService service;
	
	@RequestMapping(value = "/generate/{owner}", method = RequestMethod.GET)
	public void generate(@PathVariable("owner") String owner) {
		service.createWallet(owner);
	}
	
	@RequestMapping(value = "/balance/{wallet}", method = RequestMethod.GET)
	public BigDecimal balance(@PathVariable("wallet") String wallet){
		return service.balance(wallet);
	}
	
	@RequestMapping(value = "/wallet/{owner}", method = RequestMethod.GET)
	public Wallet wallet(@PathVariable("owner") String owner){
		return service.wallet(owner);
	}

}
