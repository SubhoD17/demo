package com.subho.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subho.entities.Address;
import com.subho.entities.Vendor;
import com.subho.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;

//	http://localhost:8080/addresses
	@RequestMapping("/addresses")
	public List<Address> readAllAddress() {
		return addressService.getAddress();
	}

//	http://localhost:8080/addresses/10
	@RequestMapping("/addresses/{addressId}")
	public Address getAddressById(@PathVariable("addressId") String id) {
		Optional<Address> searchResult = addressService.getSingleAddress(id);
		if(!searchResult.isPresent() ) {
			return new Address((long)0,"","","","","");  // if the vendor is not present it should give me an empty record, instead of Whitelabel Error Page
		}
		return searchResult.get();
	}
	
	
//	http://localhost:8080/addresses
	@PostMapping("/addresses")
	public Address createAddress(@RequestBody Address myPostBody) {
		return addressService.createAddress(myPostBody);
	}
}
