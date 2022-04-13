package com.subho.controller;

import java.net.http.HttpResponse.PushPromiseHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.subho.entities.Vendor;
import com.subho.service.VendorService;

@RestController
@RequestMapping("/")
public class VendorController {

	@Autowired
	VendorService vendorService;

//	*-- Get multiple Vendors data 
//	ES_GET_ENTITYSET
	@RequestMapping("/vendor")
	public List<Vendor> getVendors() {
		return vendorService.readAllVendors();
	}

//	*-- To Fetch single Vendor data
//	ES_GET_ENTITY
	@RequestMapping("/vendor/{vendorCode}")
	public Vendor getVendorById(@PathVariable("vendorCode") String code) {
		return vendorService.getSingleVendor(code);
	}

//*-- Create Vendor Entity
//	ES_CREATE_ENTITY
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) { // This 'Vendor' is Vendor entity/class obj
		return vendorService.createVendor(myPostBody);
	}
//
	@RequestMapping(method = RequestMethod.PUT, value = "/vendor")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return vendorService.changeVendor(vendor);
	}

	// Test using URL: http://localhost:8080/vendor/search?company=SAP
//	Adding a new service end point to find vendor based on company name
	@RequestMapping("/vendor/search")
	public List<Vendor> searchByCompany(@RequestParam String company) {
		return vendorService.searchByCompanyName(company);
	}
	
	// Test using URL: http://localhost:8080/vendor/lookup?GSTNo= 77
//	@RequestMapping("/vendor/lookup")
//	public List<Vendor> searchVendorByGSTNo(@RequestParam String GSTNo) {
//		return vendorService.lookupVendorByGST(GSTNo);
//	}
	
	// Test using URL: http://localhost:8080/vendor/77
	@RequestMapping("/vendor/lookup/{gstNo}")
	public List<Vendor> searchVendorByGSTNo(@PathVariable("gstNo") String GSTNo) {
		return vendorService.lookupVendorByGST(GSTNo);
	}
	
//	Delete Vendor
//	http://localhost:8080/vendor/5
	@RequestMapping(method=RequestMethod.DELETE, value="/vendor/{id}")
	public String deleteVendor(@PathVariable("id") String Id) {
		return vendorService.deleteVendor(Id);
	}

}
