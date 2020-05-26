package com.tjtyres.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjtyres.exception.FleetNotFoundException;
import com.tjtyres.model.Fleet;
import com.tjtyres.model.Wallet;
import com.tjtyres.repository.WalletRepository;

@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	private WalletRepository walletRepository;

	@Override
	public Wallet save(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	@Override
	public Wallet updateWallet(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	@Override
	public Wallet updateWalletDetails(int id, Wallet wallet) {
		Wallet updateWallet = walletRepository.findById(id)
				.orElseThrow(()-> new FleetNotFoundException("wallet id-" + id));
		updateWallet.setAmount(wallet.getAmount());
		final Wallet updatedWallet = walletRepository.save(updateWallet);
		return updatedWallet;
		
	}

	@Override
	public Wallet retriveWalletDetailsById(int id) {
		Wallet wallet = walletRepository.findById(id)
				.orElseThrow(()-> new FleetNotFoundException("fleet id-" + id));
		
		return wallet;
	}

}
