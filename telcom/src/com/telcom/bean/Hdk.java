package com.telcom.bean;

/**
 * AbstractHdk entity provides the base persistence definition of the Hdk
 * entity. @author MyEclipse Persistence Tools
 */

public class Hdk implements java.io.Serializable {

	private static final long serialVersionUID = -8015045808750552068L;
	private String hd;
	private String qh;
	private String shi;
	private String sheng;

	// Constructors

	/** default constructor */
	public Hdk() {
	}

	/** full constructor */
	public Hdk(String hd, String qh, String shi, String sheng) {
		this.hd = hd;
		this.qh = qh;
		this.shi = shi;
		this.sheng = sheng;
	}

	// Property accessors

	public String getHd() {
		return this.hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public String getQh() {
		return this.qh;
	}

	public void setQh(String qh) {
		this.qh = qh;
	}

	public String getShi() {
		return this.shi;
	}

	public void setShi(String shi) {
		this.shi = shi;
	}

	public String getSheng() {
		return this.sheng;
	}

	public void setSheng(String sheng) {
		this.sheng = sheng;
	}

}