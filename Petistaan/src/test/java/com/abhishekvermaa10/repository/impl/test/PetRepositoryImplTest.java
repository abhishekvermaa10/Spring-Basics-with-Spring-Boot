package com.abhishekvermaa10.repository.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.abhishekvermaa10.dto.DomesticPetDTO;
import com.abhishekvermaa10.dto.PetDTO;
import com.abhishekvermaa10.repository.impl.PetRepositoryImpl;

/**
 * @author abhishekvermaa10
 *
 */
@SpringBootTest(classes = PetRepositoryImpl.class)
class PetRepositoryImplTest {
	@Autowired
	private PetRepositoryImpl petRepositoryImpl;
	private List<PetDTO> petDTOList;

	@BeforeEach
	public void setUp() {
		petDTOList = (List<PetDTO>) ReflectionTestUtils.getField(petRepositoryImpl, "petDTOList");
		petDTOList.clear();
	}

	@Test
	void testFindPetWhenFound() {
		DomesticPetDTO expectedPetDTO = new DomesticPetDTO();
		expectedPetDTO.setId(1);
		petDTOList.add(expectedPetDTO);
		Optional<PetDTO> actualOptionalPetDTO = petRepositoryImpl.findById(1);
		assertEquals(expectedPetDTO, actualOptionalPetDTO.get());
	}

	@Test
	void testFindPetWhenNotFound() {
		Optional<PetDTO> expectedOptionalPetDTO = Optional.empty();
		Optional<PetDTO> actualOptionalPetDTO = petRepositoryImpl.findById(2);
		assertEquals(expectedOptionalPetDTO, actualOptionalPetDTO);
	}
}
