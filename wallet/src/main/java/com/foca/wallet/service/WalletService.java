package com.foca.wallet.service;

import java.math.BigDecimal;

import com.foca.model.jpa.Wallet;


public interface WalletService {

	void createWallet(String owner);

	BigDecimal balance(String walletId);

	Wallet wallet(String owner);

}
