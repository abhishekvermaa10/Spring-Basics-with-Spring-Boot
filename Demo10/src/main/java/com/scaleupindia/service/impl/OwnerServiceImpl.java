package com.scaleupindia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
@Service
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	private OwnerRepository ownerRepository;
	@Value("${owner.id}")
	private int ownerId;

	public OwnerServiceImpl() {
		System.out.println("OwnerServiceImpl bean created.");
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String findOwner() throws OwnerNotFoundException {
		return ownerRepository.findOwner(ownerId);
	}
}
