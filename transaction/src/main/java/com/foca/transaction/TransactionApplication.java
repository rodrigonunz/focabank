package com.foca.transaction;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.foca.model.jpa.Wallet;
import com.foca.model.payload.Constants;
import com.foca.transaction.queue.TransactionReceiver;

@SpringBootApplication
@EntityScan(basePackageClasses = Wallet.class)
@EnableRabbit
public class TransactionApplication {

	@Bean
	public TransactionReceiver receiver() {
		return new TransactionReceiver();
	}
	
	@Bean
    public Queue queueWallet() {
        return new Queue(Constants.queueWallet);
    }

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}
}
