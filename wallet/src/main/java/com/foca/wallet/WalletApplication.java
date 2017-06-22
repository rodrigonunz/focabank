package com.foca.wallet;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.foca.model.jpa.Wallet;
import com.foca.model.payload.Constants;
import com.foca.wallet.queue.TransactionReceiver;

@SpringBootApplication
@EntityScan(basePackageClasses = Wallet.class)
@EnableRabbit
public class WalletApplication {
	
	@Bean
	public TransactionReceiver receiver() {
		return new TransactionReceiver();
	}
	
	@Bean
    public Queue queueWallet() {
        return new Queue(Constants.queueTransactions);
    }

	public static void main(String[] args) {
		SpringApplication.run(WalletApplication.class, args);
	}
}
