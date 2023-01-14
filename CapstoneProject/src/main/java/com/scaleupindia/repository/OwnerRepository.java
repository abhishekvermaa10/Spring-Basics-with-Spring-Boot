package com.scaleupindia.repository;

import java.util.List;
import java.util.Optional;

import com.scaleupindia.dto.OwnerDTO;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerRepository {
	void saveOwner(OwnerDTO ownerDTO);

	Optional<OwnerDTO> findOwner(int ownerId);

	void updatePetDetails(int ownerId, String petName);

	void deleteOwner(int ownerId);

	List<OwnerDTO> findAllOwners();
}
