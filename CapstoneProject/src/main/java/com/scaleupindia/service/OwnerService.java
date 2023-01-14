package com.scaleupindia.service;

import java.util.List;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.exception.DuplicateOwnerIdException;
import com.scaleupindia.exception.OwnerNotFoundException;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException;

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

	void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

	void deleteOwner(int ownerId) throws OwnerNotFoundException;

	List<OwnerDTO> findAllOwners();
}