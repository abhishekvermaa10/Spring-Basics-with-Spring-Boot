package com.abhishekvermaa10.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.abhishekvermaa10.dto.OwnerDTO;
import com.abhishekvermaa10.exception.DuplicateOwnerIdException;
import com.abhishekvermaa10.exception.OwnerNotFoundException;
import com.abhishekvermaa10.repository.OwnerRepository;
import com.abhishekvermaa10.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
@Service
public class OwnerServiceImpl implements OwnerService {
	
	private final OwnerRepository ownerRepository;
	private final String ownerAlreadyExists;
	private final String ownerNotFound;

	public OwnerServiceImpl(OwnerRepository ownerRepository,
			@Value("${owner.already.exists}") String ownerAlreadyExists,
			@Value("${owner.not.found}") String ownerNotFound) {
		this.ownerRepository = ownerRepository;
		this.ownerAlreadyExists = ownerAlreadyExists;
		this.ownerNotFound = ownerNotFound;
	}

	@Override
	public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException {
		if (ownerRepository.findById(ownerDTO.getId()).isPresent()) {
			throw new DuplicateOwnerIdException(String.format(ownerAlreadyExists, ownerDTO.getId()));
		} else {
			ownerRepository.save(ownerDTO);
		}
	}

	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
		return ownerRepository.findById(ownerId)
				.orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound, ownerId)));
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
		OwnerDTO ownerDTO = ownerRepository.findById(ownerId)
				.orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound, ownerId)));
		ownerDTO.getPetDTO().setName(petName);
		ownerRepository.save(ownerDTO);
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		Optional<OwnerDTO> optionalOwner = ownerRepository.findById(ownerId);
		if (optionalOwner.isEmpty()) {
			throw new OwnerNotFoundException(String.format(ownerNotFound, ownerId));
		} else {
			ownerRepository.deleteById(ownerId);
		}
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		return ownerRepository.findAll();
	}
	
	@Override
	public List<Object[]> findIdAndFirstNameAndLastNameAndPetNameOfPaginatedOwners(int pageNumber,
			int numberOfRecordsPerPage) {
		return ownerRepository.findIdAndFirstNameAndLastNameAndPetName(pageNumber, numberOfRecordsPerPage);
	}
	
}
