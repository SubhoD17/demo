package com.subho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.subho.entities.*;

@Component
public class AddressService {

	@Autowired
	IAddressPersistence address;
	
	
	public List<Address> getAddress(){
		return address.findAll();
	}
	
	public Optional<Address> getSingleAddress(String addressId) {
		return address.findById(addressId);
	} // findById may find the vendor or not so need to use Optional
	

	public Address createAddress(Address payload){
		return address.save(payload);
	}
	
}
