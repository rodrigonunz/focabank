package com.foca.walletclient.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.foca.model.jpa.Transaction;

@Component
public class TransactionSender {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue queue;

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send(Transaction transaction) {
		template.convertAndSend(queue.getName(), transaction);
		System.out.println(" [x] Sent '" + "A" + "'");
	}
}
