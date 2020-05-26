package com.tjtyres.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tjtyres.exception.FleetNotFoundException;
import com.tjtyres.model.Address;
import com.tjtyres.model.Fleet;
import com.tjtyres.model.Wallet;
import com.tjtyres.service.AddressService;
import com.tjtyres.service.FleetService;
import com.tjtyres.service.WalletService;

@RestController
@RequestMapping("api")
public class FleetController {
	
	@Autowired
	private FleetService fleetService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private WalletService  walletService;
	
	@PostMapping("v1/fleet")
	public ResponseEntity<Fleet> createFleet(@RequestBody Fleet theFleetOwner){
		Fleet savedFleet = fleetService.save(theFleetOwner);
		URI location= ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedFleet.getFleet_id()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("v1/fleet")
	public List<Fleet> retriveAllFleet(){
		return fleetService.retriveAllFleet();
	}
	
	@GetMapping("v1/fleet/{id}")
	public Optional<Fleet> retriveFleet(@PathVariable long id){
		return fleetService.retriveFleetById(id);
	}
	
	@PutMapping("v1/fleet/{id}")
	public ResponseEntity<Fleet> updateFleetdetails(@PathVariable long id,@RequestBody Fleet fleetOwner) {
		Fleet updatedFleet = fleetService.updateFleet(id,fleetOwner);
		return ResponseEntity.ok(updatedFleet);
		
	}
	@DeleteMapping("v1/fleet/{id}")
	public Map<String, Boolean> deleteFleet(@PathVariable long id){
		Map<String, Boolean>  response = fleetService.deleteById(id);
		return response;
	}
	@PostMapping("v1/fleet/{id}/address")
	public ResponseEntity<Fleet> createAddress(@PathVariable int id, @RequestBody Address theAddress){
		Optional<Fleet> fleet = fleetService.retriveFleetById(id);
		if(!fleet.isPresent()) {
			throw new FleetNotFoundException("id-" + id);
		}
		Fleet fleetUser = fleet.get();
		theAddress.setFleet(fleetUser);
		Address savedAddress = addressService.save(theAddress);
		URI location= ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedAddress.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PostMapping("v1/fleet/{id}/wallet")
	public ResponseEntity<Wallet> createWallet(@PathVariable int id, @RequestBody Wallet theWallet){
		Optional<Fleet> fleet = fleetService.retriveFleetById(id);
		if(!fleet.isPresent()) {
			throw new FleetNotFoundException("id-" + id);
		}
		Fleet fleetUser = fleet.get();
		theWallet.setFleet(fleetUser);
		Wallet savedWallet = walletService.save(theWallet);
		return ResponseEntity.ok(savedWallet);
	}
	@PutMapping("v1/fleet/{id}/wallet")
	public ResponseEntity<Wallet> updateWalletdetails(@PathVariable long id,@RequestBody Wallet wallet) {
		Optional<Fleet> fleet = fleetService.retriveFleetById(id);
		if(!fleet.isPresent()) {
			throw new FleetNotFoundException("id-" + id);
		}
		Fleet fleetUser = fleet.get();
		wallet.setFleet(fleetUser);
		Wallet savedWallet = walletService.save(wallet);
		return ResponseEntity.ok(savedWallet);
	}
	@PutMapping("v1/wallet/{id}")
	public ResponseEntity<Wallet> updateWallet(@PathVariable int id,@RequestBody Wallet wallet) {
		Wallet updatedWallet = walletService.updateWalletDetails(id, wallet);
		return ResponseEntity.ok(updatedWallet);
	}
	@GetMapping("v1/wallet/{id}")
	public ResponseEntity<Wallet> retriveWalletDetails(@PathVariable int id) {
		Wallet updatedWallet = walletService.retriveWalletDetailsById(id);
		return ResponseEntity.ok(updatedWallet);
	}
		

}
