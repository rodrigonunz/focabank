package com.foca.model.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "wallet")
public class Wallet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -967883097297421061L;

	@Id
	private String uid;

	@Column
	@NotNull
	private String owner;

	@Column
	@NotNull
	private BigDecimal balance;

	@Column
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date creationDate;

	public Wallet(String uid, String owner, BigDecimal balance, Date creationDate) {
		super();
		this.uid = uid;
		this.owner = owner;
		this.balance = balance;
		this.creationDate = creationDate;
	}

	public Wallet() {
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wallet other = (Wallet) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	public static class WalletBuilder {
		private String uid;
		private String owner;

		public WalletBuilder uid(String uid) {
			this.uid = uid;
			return this;
		}

		public WalletBuilder owner(String owner) {
			this.owner = owner;
			return this;
		}

		public Wallet build() {
			return new Wallet(uid, owner, BigDecimal.ZERO, new Date());
		}

	}

}
