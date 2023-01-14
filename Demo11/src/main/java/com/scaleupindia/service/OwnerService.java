package com.scaleupindia.service;

import com.scaleupindia.exception.OwnerNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerService {
	String findOwner() throws OwnerNotFoundException;

	void setOwnerId(int ownerId);
}