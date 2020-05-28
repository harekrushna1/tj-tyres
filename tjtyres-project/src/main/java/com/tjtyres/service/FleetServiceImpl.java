package com.tjtyres.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjtyres.exception.FleetNotFoundException;
import com.tjtyres.model.Address;
import com.tjtyres.model.Fleet;
import com.tjtyres.repository.FleetRepository;

@Service
public class FleetServiceImpl implements FleetService{
	
	@Autowired
	private FleetRepository fleetRepository;

	@Override
	public List<Fleet> retriveAllFleet() {
		return fleetRepository.findAll();
	}

	@Override
	public Fleet save(Fleet fleet) {
		Address address = fleet.getAddress();
		if(address != null) {	
			address.setFleet(fleet);
		}
		Fleet savedFleetOwner = fleetRepository.save(fleet);
		return savedFleetOwner;
	}

	@Override
	public Optional<Fleet> retriveFleetById(long id) {
		Optional<Fleet> fleetOwner = fleetRepository.findById(id);
		if(!fleetOwner.isPresent()) {
			throw new FleetNotFoundException("fleetId-" + id);
		}
		return fleetOwner;
	}

	
	@Override
	public Fleet updateFleet(long id,Fleet fleetOwner)throws FleetNotFoundException {
	Fleet fleet = fleetRepository.findById(id)
			.orElseThrow(()-> new FleetNotFoundException("fleet id-" + id));
	fleet.setPhone_number(fleetOwner.getPhone_number());
	fleet.setName(fleetOwner.getName());
	
	final Fleet updatedFleet = fleetRepository.save(fleet);
	return updatedFleet;	
	}

	@Override
	public Map<String, Boolean> deleteById(long id) throws FleetNotFoundException{
		Fleet fleet = fleetRepository.findById(id)
				.orElseThrow(()-> new FleetNotFoundException("fleet id-" + id));
		fleetRepository.delete(fleet);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", true);
		return response;
	}
	
	


}
