package com.telcom.bean;

import java.sql.Timestamp;

/**
 * AbstractOrderLog entity provides the base persistence definition of the
 * OrderLog entity. @author MyEclipse Persistence Tools
 */

public class OrderLog implements java.io.Serializable {

	private static final long serialVersionUID = 7587808581845563250L;
	private Long id;
	private String pn;
	private Timestamp orderDate;
	private Timestamp quitDate;
	private String productId;

	// Constructors

	/** default constructor */
	public OrderLog() {
	}

	/** full constructor */
	public OrderLog(String pn, Timestamp orderDate, Timestamp quitDate,
			String productId) {
		this.pn = pn;
		this.orderDate = orderDate;
		this.quitDate = quitDate;
		this.productId = productId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPn() {
		return this.pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Timestamp getQuitDate() {
		return this.quitDate;
	}

	public void setQuitDate(Timestamp quitDate) {
		this.quitDate = quitDate;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}