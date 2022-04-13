package com.subho.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.subho.entities.Vendor;

@RepositoryRestResource(collectionResourceRel ="vendor", path = "newVendor" )
public interface vendorControllerNew extends JpaRepository<Vendor, Long>{

}
