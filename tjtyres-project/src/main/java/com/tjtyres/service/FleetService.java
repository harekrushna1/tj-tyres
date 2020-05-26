package com.tjtyres.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.tjtyres.model.Fleet;

public interface FleetService {
	
	public List<Fleet> retriveAllFleet();
	public Fleet save(Fleet fleetOwner);
	public Optional<Fleet> retriveFleetById(long id);
	public Fleet updateFleet(long id,Fleet fleetOwner);
	public Map<String, Boolean> deleteById(long id);

}
