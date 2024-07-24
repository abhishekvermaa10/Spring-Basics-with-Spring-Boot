package com.abhishekvermaa10.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.abhishekvermaa10.repository.OwnerRepository;
import com.abhishekvermaa10.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
@Service("specialService")
public class OwnerServiceImpl2 implements OwnerService {
	@Qualifier("specialRepository")
	@Autowired
	private OwnerRepository ownerRepository;
	@Value("20")
	private int ownerId;

	public OwnerServiceImpl2() {
		System.out.println("OwnerServiceImpl special bean created.");
	}

	@Override
	public String findOwner() {
		return ownerRepository.findOwner(ownerId);
	}
}
