package com.scaleupindia.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.enums.Gender;
import com.scaleupindia.enums.PetType;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.util.InputUtil;

import jakarta.annotation.PostConstruct;

/**
 * @author abhishekvermaa10
 *
 */
@Repository
public class OwnerRepositoryImpl implements OwnerRepository {
	private static List<OwnerDTO> ownerDTOList;

	@PostConstruct
	private static List<OwnerDTO> initializeOwnerList() {
		ownerDTOList = new ArrayList<>();
		OwnerDTO ownerDTO = new OwnerDTO();
		ownerDTO.setId(1);
		ownerDTO.setFirstName("Abhihsek");
		ownerDTO.setLastName("Verma");
		ownerDTO.setGender(Gender.M);
		ownerDTO.setCity("Chandigarh");
		ownerDTO.setState("Chandigarh");
		ownerDTO.setMobileNumber("9876543210");
		ownerDTO.setEmailId("abhishekvermaa10@gmail.com");
		PetDTO petDTO = new PetDTO();
		petDTO.setType(PetType.BIRD);
		petDTO.setId(1);
		petDTO.setName("Mitthu");
		petDTO.setBirthDate(InputUtil.convertStringToDate("07-03-2022"));
		petDTO.setGender(Gender.M);
		ownerDTO.setPetDTO(petDTO);
		ownerDTOList.add(ownerDTO);
		return ownerDTOList;
	}

	@Override
	public void saveOwner(OwnerDTO ownerDTO) {
		ownerDTOList.add(ownerDTO);
	}

	@Override
	public Optional<OwnerDTO> findOwner(int ownerId) {
		return ownerDTOList.stream().filter(owner -> owner.getId() == ownerId).findFirst();
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) {
		ownerDTOList.stream().filter(ownerDTO -> ownerDTO.getId() == ownerId).findFirst().ifPresent(ownerDTO -> {
			PetDTO petDTO = ownerDTO.getPetDTO();
			petDTO.setName(petName);
			ownerDTO.setPetDTO(petDTO);
		});
	}

	@Override
	public void deleteOwner(int ownerId) {
		ownerDTOList.removeIf(ownerDTO -> ownerDTO.getId() == ownerId);
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		return ownerDTOList;
	}
}
