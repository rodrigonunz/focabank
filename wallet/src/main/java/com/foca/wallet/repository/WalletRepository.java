package com.foca.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foca.model.jpa.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {
	
	Wallet findByOwner(String owner);
	
}
