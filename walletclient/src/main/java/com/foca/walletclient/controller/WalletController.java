package com.foca.walletclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wallet")
public class WalletController {
	
	private static final String walletView = "wallet";

	@RequestMapping
	public String wallet(){
		return walletView;
	}
	
}
