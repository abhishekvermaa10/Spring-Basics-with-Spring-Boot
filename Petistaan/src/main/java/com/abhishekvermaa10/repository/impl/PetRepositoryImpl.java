package com.abhishekvermaa10.repository.impl;

import static com.abhishekvermaa10.enums.Gender.F;
import static com.abhishekvermaa10.enums.Gender.M;
import static com.abhishekvermaa10.enums.PetType.CAT;
import static com.abhishekvermaa10.enums.PetType.DOG;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.abhishekvermaa10.dto.DomesticPetDTO;
import com.abhishekvermaa10.dto.OwnerDTO;
import com.abhishekvermaa10.dto.PetDTO;
import com.abhishekvermaa10.dto.WildPetDTO;
import com.abhishekvermaa10.repository.PetRepository;

import jakarta.annotation.PostConstruct;

/**
 * @author abhishekvermaa10
 *
 */
@Repository
public class PetRepositoryImpl implements PetRepository {
	
	private List<PetDTO> petDTOList;

	public PetRepositoryImpl() {
		this.petDTOList = new ArrayList<>();
	}

	@PostConstruct
	public void init() {
		DomesticPetDTO domesticPetDTO = new DomesticPetDTO();
		domesticPetDTO.setId(1);
		domesticPetDTO.setName("Max");
		domesticPetDTO.setGender(M);
		domesticPetDTO.setType(DOG);
		domesticPetDTO.setBirthDate(LocalDate.of(2018, 7, 26));
		OwnerDTO ownerDTO = new OwnerDTO();
		ownerDTO.setId(1);
		ownerDTO.setFirstName("John");
		ownerDTO.setLastName("Doe");
		ownerDTO.setGender(M);
		ownerDTO.setCity("Hyderabad");
		ownerDTO.setState("Andhra Pradesh");
		ownerDTO.setMobileNumber("9009009001");
		ownerDTO.setEmailId("john.doe@abhishekvermaa10.com");
		domesticPetDTO.setOwnerDTO(ownerDTO);
		petDTOList.add(domesticPetDTO);
		WildPetDTO wildPetDTO = new WildPetDTO();
		wildPetDTO.setId(2);
		wildPetDTO.setName("Fluffy");
		wildPetDTO.setGender(F);
		wildPetDTO.setType(CAT);
		wildPetDTO.setBirthPlace("Jim Corbett National Park");
		ownerDTO = new OwnerDTO();
		ownerDTO.setId(2);
		ownerDTO.setFirstName("Jane");
		ownerDTO.setLastName("Smith");
		ownerDTO.setGender(F);
		ownerDTO.setCity("Vishakhapatnam");
		ownerDTO.setState("Andhra Pradesh");
		ownerDTO.setMobileNumber("9009009002");
		ownerDTO.setEmailId("jane.smith@abhishekvermaa10.com");
		wildPetDTO.setOwnerDTO(ownerDTO);
		petDTOList.add(wildPetDTO);
	}

	@Override
	public Optional<PetDTO> findById(int petId) {
		return petDTOList.stream()
				.filter(pet -> pet.getId() == petId)
				.findFirst();
	}

	@Override
	public Optional<Double> findAverageAgeOfPet() {
		 return petDTOList.stream()
		            .filter(pet -> pet instanceof DomesticPetDTO)
		            .map(pet -> ((DomesticPetDTO) pet).getBirthDate())
		            .mapToDouble(birthDate -> Period.between(birthDate, LocalDate.now()).getYears())
		            .average()
		            .stream()
		            .boxed()
		            .findFirst();
	}
	
}
