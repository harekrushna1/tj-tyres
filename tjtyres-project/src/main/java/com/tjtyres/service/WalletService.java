package com.tjtyres.service;

import com.tjtyres.model.Fleet;
import com.tjtyres.model.Wallet;

public interface WalletService {
	public Wallet save(Wallet wallet);
	public Wallet updateWallet(Wallet wallet);
	public Wallet updateWalletDetails(int id,Wallet wallet);
	public Wallet retriveWalletDetailsById(int id);

}
