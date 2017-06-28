package com.foca.walletclient;

import java.util.Locale;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import com.foca.model.payload.Constants;

@SpringBootApplication
public class WalletclientApplication {
	
	@Bean
    public Queue queueWallet() {
        return new Queue(Constants.queueTransactions);
    }
	
	@Bean
	public LocaleResolver localeResolver(){
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
	
	@Configuration
	public static class MvcConfig extends WebMvcConfigurerAdapter{
		
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/wallet");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(WalletclientApplication.class, args);
	}
	
	
}
