package com.abhishekvermaa10.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.abhishekvermaa10.dto.PetDTO;
import com.abhishekvermaa10.exception.PetNotFoundException;
import com.abhishekvermaa10.repository.PetRepository;
import com.abhishekvermaa10.service.PetService;

/**
 * @author abhishekvermaa10
 *
 */
@Service
public class PetServiceImpl implements PetService {
	private final PetRepository petRepository;
	private final String petNotFound;

	public PetServiceImpl(PetRepository petRepository, @Value("${pet.not.found}") String petNotFound) {
		this.petRepository = petRepository;
		this.petNotFound = petNotFound;
	}

	@Override
	public PetDTO findPet(int petId) throws PetNotFoundException {
		return petRepository.findById(petId)
				.orElseThrow(() -> new PetNotFoundException(String.format(petNotFound, petId)));
	}
}
