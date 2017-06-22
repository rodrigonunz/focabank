package com.foca.wallet.queue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import com.foca.model.jpa.Status;
import com.foca.model.jpa.Transaction;
import com.foca.model.payload.Constants;

@RabbitListener(queues = Constants.queueWallet)
public class TransactionReceiver {
	
	@Autowired
	TransactionSender sender;
	
	public TransactionReceiver() {
	}

	@RabbitHandler
	public void receive(Transaction transaction) throws InterruptedException {
		StopWatch watch = new StopWatch();
		watch.start();
		System.out.println("instance [x] Received ");
		doWork(transaction);
		watch.stop();
		System.out.println("instance [x] Done in " + watch.getTotalTimeSeconds() + "s");
	}

	private void doWork(Transaction transaction) throws InterruptedException {
		transaction.setStatus(Status.CONFIRMED);
		sender.send(transaction);
		
	}

}
