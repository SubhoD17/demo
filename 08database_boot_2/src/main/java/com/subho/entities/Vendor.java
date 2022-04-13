package com.subho.entities;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;


import java.util.*;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "VENDOR")
public class Vendor {

	@Id
	@Column(nullable = false, name="ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernet.id.UUIDGenerator")
	public String id;
	@Column(nullable = false, name="COMPANY_NAME")
	public String companyName;
	@Column(nullable = false, name="FIRST_NAME")
	public String contactName;
	@Column(nullable = false, name="LAST_NAME")
	public String lastName;
	@Column(nullable = false, name="WEBSITE")
	public String website;
	@Column(nullable = false, name="EMAILID")
	public String email;
	@Column(nullable = false, name="STATUS")
	public String status;
	@Column(nullable = false, name="GST_NO")
	public String gstNo;
	
//	start of Class- 7
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor",referencedColumnName = "ID")
	private List<Address> addresses = new ArrayList<>();
	
	
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
//	end of Class- 7	
	public Vendor() {
		
	}
	public Vendor(String id, String companyName, String contactName, String lastName, String website, String email,
			String status, String gstNo) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.contactName = contactName;
		this.lastName = lastName;
		this.website = website;
		this.email = email;
		this.status = status;
		this.gstNo = gstNo;
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
}
