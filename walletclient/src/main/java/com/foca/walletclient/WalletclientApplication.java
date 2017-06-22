package com.foca.walletclient;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.foca.model.payload.Constants;

@SpringBootApplication
public class WalletclientApplication {
	
	@Bean
    public Queue queueWallet() {
        return new Queue(Constants.queueTransactions);
    }

	public static void main(String[] args) {
		SpringApplication.run(WalletclientApplication.class, args);
	}
}
