package com.tjtyres.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Fleet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fleet_id")
	private Long fleet_id;
	@Column(name="fleet_name")
	private String name;
	@Column(name="phone_number")
	private String phone_number;
	@Column(name="email_id")
	private String email_id;
	@Column(name="user_name")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="fleet_owner_name")
	private String fleetOwnerName;
	@Column(name="fleet_account_number")
	private String fleet_account_number;
	
	@OneToOne(mappedBy = "fleet",cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy = "fleet",cascade = CascadeType.ALL)
	private List<Wallet> walletNumber;
	///private Bank bank;
	
	
	///private Hpcl hpcl;
	
	public Fleet() {
		
	}

	public Fleet(Long fleet_id, String name, String phone_number, String email_id, String username, String fleet_account_number, String fleetOwnerName) {
		this.fleet_id = fleet_id;
		this.name = name;
		this.phone_number = phone_number;
		this.email_id = email_id;
		this.username = username;
		this.fleet_account_number = fleet_account_number;
		this.fleetOwnerName = fleetOwnerName;
	}

	public Long getFleet_id() {
		return fleet_id;
	}

	public void setFleet_id(Long fleet_id) {
		this.fleet_id = fleet_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getFleetOwnerName() {
		return fleetOwnerName;
	}

	public void setFleetOwnerName(String fleetOwnerName) {
		this.fleetOwnerName = fleetOwnerName;
	}
	public String getFleet_account_number() {
		return fleet_account_number;
	}

	public void setFleet_account_number(String fleet_account_number) {
		this.fleet_account_number = fleet_account_number;
	}
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}



	public List<Wallet> getWalletNumber() {
		return walletNumber;
	}

	public void setWalletNumber(List<Wallet> walletNumber) {
		this.walletNumber = walletNumber;
	}

	@Override
	public String toString() {
		return "FleetOwner [fleet_id=" + fleet_id + ", name=" + name + ", phone_number=" + phone_number + ", email_id="
				+ email_id + ", username=" + username + ", password=" + password + ", fleet_account_number="
				+ fleet_account_number + "]";
	}
	
	
	
	

}
