package com.foca.walletclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foca.model.jpa.Transaction;
import com.foca.walletclient.queue.TransactionSender;

@Service
public class TransactionService {
	
	@Autowired
	TransactionSender sender;

	public void processarTransacao(Transaction t) {
		//executa regras aqui
		sender.send(t);
	}
	
	

}
