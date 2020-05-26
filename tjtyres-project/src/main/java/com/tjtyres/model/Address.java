package com.tjtyres.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="state")
	private String State;
	@Column(name="city")
	private String city;
	@Column(name="pin_code")
	private String pincode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Fleet fleet;
	
	public Address() {
		
	}
	public Address(String state, String city, String pin_code) {
		State = state;
		this.city = city;
		this.pincode = pin_code;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	public Fleet getFleet() {
		return fleet;
	}
	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}
	@Override
	public String toString() {
		return "Address [State=" + State + ", city=" + city + ", pin_code=" + pincode + "]";
	}
	
	

}
