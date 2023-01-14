package com.scaleupindia.repository;

import com.scaleupindia.exception.OwnerNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerRepository {
	String findOwner(int ownerId) throws OwnerNotFoundException;
}
