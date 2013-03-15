package com.telcom.bean;

import java.sql.Timestamp;

/**
 * AbstractSmsMoMessage entity provides the base persistence definition of the
 * SmsMoMessage entity. @author MyEclipse Persistence Tools
 */

public class SmsMoMessage implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7483545641458791057L;
	private Long id;
	private String spRevId;
	private String spRevPassword;
	private String spId;
	private String san;
	private String transactionId;
	private String linkid;
	private String message;
	private String senderAddress;
	private String smsServiceActivationNumber;
	private Timestamp dt;

	// Constructors

	/** default constructor */
	public SmsMoMessage() {
	}

	/** minimal constructor */
	public SmsMoMessage(Timestamp dt) {
		this.dt = dt;
	}

	/** full constructor */
	public SmsMoMessage(String spRevId, String spRevPassword,
			String spId, String san, String transactionId, String linkid,
			String message, String senderAddress,
			String smsServiceActivationNumber, Timestamp dt) {
		this.spRevId = spRevId;
		this.spRevPassword = spRevPassword;
		this.spId = spId;
		this.san = san;
		this.transactionId = transactionId;
		this.linkid = linkid;
		this.message = message;
		this.senderAddress = senderAddress;
		this.smsServiceActivationNumber = smsServiceActivationNumber;
		this.dt = dt;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpRevId() {
		return this.spRevId;
	}

	public void setSpRevId(String spRevId) {
		this.spRevId = spRevId;
	}

	public String getSpRevPassword() {
		return this.spRevPassword;
	}

	public void setSpRevPassword(String spRevPassword) {
		this.spRevPassword = spRevPassword;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSan() {
		return this.san;
	}

	public void setSan(String san) {
		this.san = san;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getLinkid() {
		return this.linkid;
	}

	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSenderAddress() {
		return this.senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSmsServiceActivationNumber() {
		return this.smsServiceActivationNumber;
	}

	public void setSmsServiceActivationNumber(String smsServiceActivationNumber) {
		this.smsServiceActivationNumber = smsServiceActivationNumber;
	}

	public Timestamp getDt() {
		return this.dt;
	}

	public void setDt(Timestamp dt) {
		this.dt = dt;
	}

}