package net.kzn.onlineshopping.model;

import java.io.Serializable;

import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.User;

public class RegisterModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private Address billing;
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the billing
	 */
	public Address getBilling() {
		return billing;
	}
	/**
	 * @param billing the billing to set
	 */
	public void setBilling(Address billing) {
		this.billing = billing;
	}
		

}
