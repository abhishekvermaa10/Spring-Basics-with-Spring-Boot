package com.abhishekvermaa10;

import com.abhishekvermaa10.repository.OwnerRepository;
import com.abhishekvermaa10.repository.impl.OwnerRepositoryImpl;
import com.abhishekvermaa10.service.OwnerService;
import com.abhishekvermaa10.service.impl.OwnerServiceImpl;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo {
	public static void main(String[] args) {
		OwnerRepository ownerRepository = new OwnerRepositoryImpl();
		OwnerService ownerService = new OwnerServiceImpl(ownerRepository, 10);
		System.out.println(ownerService.findOwner());
	}
}
