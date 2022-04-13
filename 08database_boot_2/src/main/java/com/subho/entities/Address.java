package com.subho.entities;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Address {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernet.id.UUIDGenerator")
	@Column(nullable = false, name="TYPE")
	private Long addressId;
	private String addressType;
	@Column(name= "STREET")
	private String street;
	@Column(name= "CITY" )
	private String city;
	@Column(name= "COUNTRY")
	private String country;
	@Column(name= "REGION")
	private String region;
	
	
	public Address() {
		
	}
	
	public Address(Long addressId, String addressType, String street, String city, String country, String region) {
		super();
		this.addressId = addressId;
		this.addressType = addressType;
		this.street = street;
		this.city = city;
		this.country = country;
		this.region = region;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
}
