package com.abhishekvermaa10.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.abhishekvermaa10.exception.OwnerNotFoundException;
import com.abhishekvermaa10.repository.OwnerRepository;
import com.abhishekvermaa10.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
@Service
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	private OwnerRepository ownerRepository;
	@Value("10")
	private int ownerId;

	public OwnerServiceImpl() {
		System.out.println("OwnerServiceImpl bean created.");
	}

	@Override
	public String findOwner() throws OwnerNotFoundException {
		return ownerRepository.findOwner(ownerId);
	}

	@Override
	public void modifyOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
}
