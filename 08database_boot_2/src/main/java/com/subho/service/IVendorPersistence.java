package com.subho.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.subho.entities.Vendor;

public interface IVendorPersistence extends JpaRepository<Vendor, String>{

	List <Vendor> findByCompanyName(String companyName);
	
//	Custom Query
	@Query(nativeQuery = true, 
			value = "SELECT * FROM public.vendor where lower(GST_NO) like %?1% ")
//	 %1 is a place holder and we can add upto 256 place holders inside a custom query
	List<Vendor> lookupVendorByGST(String GSTNo);
	
}
