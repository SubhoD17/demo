package com.subho.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.subho.entities.Address;

public interface IAddressPersistence extends JpaRepository<Address, String>{

}
