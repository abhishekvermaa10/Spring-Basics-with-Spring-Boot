package com.scaleupindia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
@Service
@Scope("singleton")
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	private OwnerRepository ownerRepository;
	@Value("10")
	private int ownerId;

	public OwnerServiceImpl() {
		System.out.println("OwnerServiceImpl bean created.");
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String findOwner() {
		return ownerRepository.findOwner(ownerId);
	}
}
