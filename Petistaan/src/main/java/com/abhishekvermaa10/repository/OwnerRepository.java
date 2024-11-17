package com.abhishekvermaa10.repository;

import java.util.List;
import java.util.Optional;

import com.abhishekvermaa10.dto.OwnerDTO;

/**
 * @author abhishekvermaa10
 *
 */
public interface OwnerRepository {
	
	void save(OwnerDTO ownerDTO);

	Optional<OwnerDTO> findById(int ownerId);

	void updatePetDetails(int ownerId, String petName);

	void deleteById(int ownerId);

	List<OwnerDTO> findAll();
	
	List<Object[]> findIdAndFirstNameAndLastNameAndPetName(int pageNumber, int pageSize);
	
}
