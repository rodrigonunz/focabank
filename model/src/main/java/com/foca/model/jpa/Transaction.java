package com.foca.model.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "transaction")
public class Transaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3163102723426585019L;
	
	@Id
	private String uid;
	
	@Column
	@NotNull
	private String walletC;
	
	@Column
	@NotNull
	private String walletD;
	
	@Column(length = 256)
	private String paymentId;
	
	@Column
	@NotNull
	private BigDecimal value;
	
	@Column
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date date;
	
	@Column
	@NotNull
	private BigDecimal fee;
	
	@Enumerated(EnumType.ORDINAL)
	private Status status; 
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getWalletC() {
		return walletC;
	}

	public void setWalletC(String walletC) {
		this.walletC = walletC;
	}

	public String getWalletD() {
		return walletD;
	}

	public void setWalletD(String walletD) {
		this.walletD = walletD;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
