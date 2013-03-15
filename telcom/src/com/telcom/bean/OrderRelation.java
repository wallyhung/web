package com.telcom.bean;

import java.sql.Timestamp;

/**
 * AbstractOrderRelation entity provides the base persistence definition of the
 * OrderRelation entity. @author MyEclipse Persistence Tools
 */

public class OrderRelation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5457228322033070930L;
	private Long id;
	private String optype;
	private String packageId;
	private String productId;
	private String streamingNo;
	private String userId;
	private String userIdType;
	private String verUserId;
	private Timestamp dt;

	// Constructors

	/** default constructor */
	public OrderRelation() {
	}

	/** minimal constructor */
	public OrderRelation(Timestamp dt) {
		this.dt = dt;
	}

	/** full constructor */
	public OrderRelation(String optype, String packageId,
			String productId, String streamingNo, String userId,
			String userIdType, String verUserId, Timestamp dt) {
		this.optype = optype;
		this.packageId = packageId;
		this.productId = productId;
		this.streamingNo = streamingNo;
		this.userId = userId;
		this.userIdType = userIdType;
		this.verUserId = verUserId;
		this.dt = dt;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOptype() {
		return this.optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public String getPackageId() {
		return this.packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getStreamingNo() {
		return this.streamingNo;
	}

	public void setStreamingNo(String streamingNo) {
		this.streamingNo = streamingNo;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserIdType() {
		return this.userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}

	public String getVerUserId() {
		return this.verUserId;
	}

	public void setVerUserId(String verUserId) {
		this.verUserId = verUserId;
	}

	public Timestamp getDt() {
		return this.dt;
	}

	public void setDt(Timestamp dt) {
		this.dt = dt;
	}

}