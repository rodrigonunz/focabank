package com.foca.walletclient.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foca.model.jpa.Transaction;
import com.foca.walletclient.queue.WalletSender;
import com.foca.walletclient.service.TransactionService;

@Controller
@RequestMapping("transacao")
public class TransactionController {
	
	private static final String CADASTRO_VIEW = "novaTransacao";
	
	@Autowired
	WalletSender sender;
	
	@Autowired
	TransactionService service;
	
	
	@RequestMapping("/novo")
	public String novo() {
		Transaction t = new Transaction();
		t.setWalletC("A");
		t.setWalletD("B");
		t.setDate(new Date());
		service.processarTransacao(t);
		
		return CADASTRO_VIEW;
	}

}
