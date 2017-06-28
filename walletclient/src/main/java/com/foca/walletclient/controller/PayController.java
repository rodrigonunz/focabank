package com.foca.walletclient.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.foca.model.jpa.Status;
import com.foca.model.jpa.Transaction;
import com.foca.walletclient.service.TransactionService;

@Controller
@RequestMapping("pay")
public class PayController {
	
	private static final String payView = "pay";
	
	@Autowired
	TransactionService service;
	
	@RequestMapping
	public ModelAndView newPayment(){
		ModelAndView mv = new ModelAndView(payView);
		mv.addObject("transaction", new Transaction());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String pay(@Validated Transaction transaction, Errors erros, RedirectAttributes attributes){
		if(erros.hasErrors()){
			return payView;
		}
		
		transaction.setDate(new Date());
		transaction.setStatus(Status.NOTCONFIRMED);
		service.processTransaction(transaction);
		
		return "";
	}
	

}
