package com.abhishekvermaa10.service.mock.impl;

import com.abhishekvermaa10.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
public class OwnerServiceImpl implements OwnerService {
	private int ownerId;

	public OwnerServiceImpl(int ownerId) {
		this.ownerId = ownerId;
		System.out.println("OwnerServiceImpl mock object created.");
	}

	@Override
	public String findOwner() {
		return String.format("Found owner from service with ownerId %s", ownerId);
	}
}
