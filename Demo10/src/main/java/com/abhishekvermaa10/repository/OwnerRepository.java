package com.abhishekvermaa10.repository;

import com.abhishekvermaa10.exception.OwnerNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerRepository {
	String findOwner(int ownerId) throws OwnerNotFoundException;
}
