package com.subho.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.subho.entities.Vendor;

@Component
public class VendorService {
	@Autowired
	IVendorPersistence vendor;

	public List<Vendor> readAllVendors() {
		return vendor.findAll(); // This will return a internal table of type List
	}

//	public Vendor getSingleVendorById(String vendorCode) {
//		return (Vendor) vendors.get(vendorCode);
//	}

	public Vendor getSingleVendor(String vendorId) {
//		return vendor.findById(vendorId);
		Optional<Vendor> searchResult = vendor.findById(vendorId);
		if(!searchResult.isPresent() ) {
			return new Vendor((String)"","","","","","","",null);  // if the vendor is not present it should give me an empty record, instead of Whitelabel Error Page
		}
		return searchResult.get();
	} // findById may find the vendor or not so need to use Optional
//
//	public Vendor changeVendor(Vendor vendor) {
//		return vendor;
//	}

	public Vendor createVendor(Vendor vendorobj) { // This 'Vendor' is Vendor entity/class obj
		return vendor.save(vendorobj);
	}

	public List<Vendor> searchByCompanyName(String companyName) {
		return vendor.findByCompanyName(companyName);
	}

	public List<Vendor> lookupVendorByGST(String GSTNo) {
		return vendor.lookupVendorByGST(GSTNo);
	}

	public Vendor changeVendor(Vendor payload) {
		Optional<Vendor> myVendor = vendor.findById(payload.getId());
		if (!myVendor.isPresent()) {
			return new Vendor((String)"", "", "", "", "", "", "", null);
		}
		return vendor.save(payload);
	}
	
	public String deleteVendor(String vendorId) {
		vendor.deleteById(vendorId);
		return "Vendor got Deleted Successfully";
	}
}
