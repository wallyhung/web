package com.telcom.bean;

import java.sql.Timestamp;

/**
 * AbstractReportMessage entity provides the base persistence definition of the
 * ReportMessage entity. @author MyEclipse Persistence Tools
 */

public class ReportMessage implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4595172973433988607L;
	private Long id;
	private String correlator;
	private String address;
	private String status;
	private Timestamp dt;

	// Constructors

	/** default constructor */
	public ReportMessage() {
	}

	/** minimal constructor */
	public ReportMessage(Timestamp dt) {
		this.dt = dt;
	}

	/** full constructor */
	public ReportMessage(String correlator, String address,
			String status, Timestamp dt) {
		this.correlator = correlator;
		this.address = address;
		this.status = status;
		this.dt = dt;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorrelator() {
		return this.correlator;
	}

	public void setCorrelator(String correlator) {
		this.correlator = correlator;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getDt() {
		return this.dt;
	}

	public void setDt(Timestamp dt) {
		this.dt = dt;
	}

}