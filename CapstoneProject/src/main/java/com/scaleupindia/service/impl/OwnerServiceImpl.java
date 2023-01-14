package com.scaleupindia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.exception.DuplicateOwnerIdException;
import com.scaleupindia.exception.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.service.OwnerService;

/**
 * @author abhishekvermaa10
 *
 */
@Service
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	private OwnerRepository ownerRepository;
	@Value("${owner.not.found}")
	private String ownerNotFound;
	@Value("${owner.already.exists}")
	private String ownerAlreadyExists;

	@Override
	public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException {
		Optional<OwnerDTO> optionalOwner = ownerRepository.findOwner(ownerDTO.getId());
		if (optionalOwner.isPresent()) {
			throw new DuplicateOwnerIdException(ownerAlreadyExists + ownerDTO.getId());
		} else {
			ownerRepository.saveOwner(ownerDTO);
		}
	}

	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
		Optional<OwnerDTO> optionalOwner = ownerRepository.findOwner(ownerId);
		if (optionalOwner.isEmpty()) {
			throw new OwnerNotFoundException(ownerNotFound + ownerId);
		} else {
			return optionalOwner.get();
		}
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
		Optional<OwnerDTO> optionalOwner = ownerRepository.findOwner(ownerId);
		if (optionalOwner.isEmpty()) {
			throw new OwnerNotFoundException(ownerNotFound + ownerId);
		} else {
			ownerRepository.updatePetDetails(ownerId, petName);
		}
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		Optional<OwnerDTO> optionalOwner = ownerRepository.findOwner(ownerId);
		if (optionalOwner.isEmpty()) {
			throw new OwnerNotFoundException(ownerNotFound + ownerId);
		} else {
			ownerRepository.deleteOwner(ownerId);
		}
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		return ownerRepository.findAllOwners();
	}
}
