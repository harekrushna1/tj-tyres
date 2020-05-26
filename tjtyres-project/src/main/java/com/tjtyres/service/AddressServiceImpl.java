package com.tjtyres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjtyres.model.Address;
import com.tjtyres.repository.AddressRepository;
import com.tjtyres.repository.FleetRepository;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private FleetRepository fleetRepository;

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

}
