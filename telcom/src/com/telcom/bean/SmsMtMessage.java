package com.telcom.bean;

import java.sql.Timestamp;

/**
 * AbstractSmsMtMessage entity provides the base persistence definition of the
 * SmsMtMessage entity. @author MyEclipse Persistence Tools
 */

public class SmsMtMessage implements java.io.Serializable {


	private static final long serialVersionUID = -6946187956517097885L;
	private Long id;
	private String spId;
	private String spPassword;
	private String timeStamp;
	private String productId;
	private String san;
	private String transactionId;
	private String transEnd;
	private String linkid;
	private String oa;
	private String fa;
	private String multicastMessaging;
	private String senderName;
	private String addresses;
	private String message;
	private String charging;
	private String interfaceName;
	private String endPoint;
	private String correlator;
	private String res;
	private Timestamp dt;

	// Constructors

	/** default constructor */
	public SmsMtMessage() {
	}

	/** minimal constructor */
	public SmsMtMessage(Timestamp dt) {
		this.dt = dt;
	}

	/** full constructor */
	public SmsMtMessage(String spId, String spPassword,
			String timeStamp, String productId, String san,
			String transactionId, String transEnd, String linkid, String oa,
			String fa, String multicastMessaging, String senderName,
			String addresses, String message, String charging,
			String interfaceName, String endPoint, String correlator,
			String res, Timestamp dt) {
		this.spId = spId;
		this.spPassword = spPassword;
		this.timeStamp = timeStamp;
		this.productId = productId;
		this.san = san;
		this.transactionId = transactionId;
		this.transEnd = transEnd;
		this.linkid = linkid;
		this.oa = oa;
		this.fa = fa;
		this.multicastMessaging = multicastMessaging;
		this.senderName = senderName;
		this.addresses = addresses;
		this.message = message;
		this.charging = charging;
		this.interfaceName = interfaceName;
		this.endPoint = endPoint;
		this.correlator = correlator;
		this.res = res;
		this.dt = dt;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpId() {
		return this.spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	public String getSpPassword() {
		return this.spPassword;
	}

	public void setSpPassword(String spPassword) {
		this.spPassword = spPassword;
	}

	public String getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getTransEnd() {
		return this.transEnd;
	}

	public void setTransEnd(String transEnd) {
		this.transEnd = transEnd;
	}

	public String getLinkid() {
		return this.linkid;
	}

	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}

	public String getOa() {
		return this.oa;
	}

	public void setOa(String oa) {
		this.oa = oa;
	}

	public String getFa() {
		return this.fa;
	}

	public void setFa(String fa) {
		this.fa = fa;
	}

	public String getMulticastMessaging() {
		return this.multicastMessaging;
	}

	public void setMulticastMessaging(String multicastMessaging) {
		this.multicastMessaging = multicastMessaging;
	}

	public String getSenderName() {
		return this.senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getAddresses() {
		return this.addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCharging() {
		return this.charging;
	}

	public void setCharging(String charging) {
		this.charging = charging;
	}

	public String getInterfaceName() {
		return this.interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getEndPoint() {
		return this.endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getCorrelator() {
		return this.correlator;
	}

	public void setCorrelator(String correlator) {
		this.correlator = correlator;
	}

	public String getRes() {
		return this.res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public Timestamp getDt() {
		return this.dt;
	}

	public void setDt(Timestamp dt) {
		this.dt = dt;
	}

}