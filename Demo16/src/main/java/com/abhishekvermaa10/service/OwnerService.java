package com.abhishekvermaa10.service;

import com.abhishekvermaa10.exception.OwnerNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerService {
	String findOwner() throws OwnerNotFoundException;

	void modifyOwnerId(int ownerId);
}