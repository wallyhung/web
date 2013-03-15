package com.telcom.bean;

/**
 * AbstractPhoneNum entity provides the base persistence definition of the
 * PhoneNum entity. @author MyEclipse Persistence Tools
 */

public class PhoneNum implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 5390410420521718418L;
	private String number;

	// Constructors

	/** default constructor */
	public PhoneNum() {
	}

	/** full constructor */
	public PhoneNum(String number) {
		this.number = number;
	}

	// Property accessors

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}