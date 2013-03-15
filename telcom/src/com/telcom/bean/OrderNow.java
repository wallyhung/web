package com.telcom.bean;

import java.sql.Timestamp;

/**
 * AbstractOrderNow entity provides the base persistence definition of the
 * OrderNow entity. @author MyEclipse Persistence Tools
 */

public class OrderNow implements java.io.Serializable {

	private static final long serialVersionUID = 6209905046669070015L;
	private OrderNowId id;
	private Timestamp orderDate;
	private Integer status;

	// Constructors

	/** default constructor */
	public OrderNow() {
	}

	/** full constructor */
	public OrderNow(OrderNowId id, Timestamp orderDate, Integer status) {
		this.id = id;
		this.orderDate = orderDate;
		this.status = status;
	}

	// Property accessors

	public OrderNowId getId() {
		return this.id;
	}

	public void setId(OrderNowId id) {
		this.id = id;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}