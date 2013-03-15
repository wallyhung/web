package com.telcom.bean;

/**
 * AbstractOrderNowId entity provides the base persistence definition of the
 * OrderNowId entity. @author MyEclipse Persistence Tools
 */

public class OrderNowId implements java.io.Serializable {

	private static final long serialVersionUID = -8879368333009134220L;
	private String pn;
	private String productId;

	// Constructors

	/** default constructor */
	public OrderNowId() {
	}

	/** full constructor */
	public OrderNowId(String pn, String productId) {
		this.pn = pn;
		this.productId = productId;
	}

	// Property accessors

	public String getPn() {
		return this.pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderNowId))
			return false;
		OrderNowId castOther = (OrderNowId) other;

		return ((this.getPn() == castOther.getPn()) || (this.getPn() != null
				&& castOther.getPn() != null && this.getPn().equals(
				castOther.getPn())))
				&& ((this.getProductId() == castOther.getProductId()) || (this
						.getProductId() != null
						&& castOther.getProductId() != null && this
						.getProductId().equals(castOther.getProductId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPn() == null ? 0 : this.getPn().hashCode());
		result = 37 * result
				+ (getProductId() == null ? 0 : this.getProductId().hashCode());
		return result;
	}

}