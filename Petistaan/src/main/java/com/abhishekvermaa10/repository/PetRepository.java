package com.abhishekvermaa10.repository;

import java.util.Optional;

import com.abhishekvermaa10.dto.PetDTO;

/**
 * @author abhishekvermaa10
 *
 */
public interface PetRepository {
	Optional<PetDTO> findById(int petId);
}
