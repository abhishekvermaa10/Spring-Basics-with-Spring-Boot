package com.abhishekvermaa10.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import com.abhishekvermaa10.dto.DomesticPetDTO;
import com.abhishekvermaa10.dto.PetDTO;
import com.abhishekvermaa10.exception.PetNotFoundException;
import com.abhishekvermaa10.repository.PetRepository;
import com.abhishekvermaa10.service.impl.PetServiceImpl;

/**
 * @author abhishekvermaa10
 *
 */
@TestPropertySource("classpath:messages.properties")
@SpringBootTest(classes = PetServiceImpl.class)
class PetServiceImplTest {
	@Autowired
	private PetServiceImpl petServiceImpl;
	@MockBean
	private PetRepository petRepository;

	@Test
	void testFindPetWhenFound() throws PetNotFoundException {
		DomesticPetDTO expectedPetDTO = new DomesticPetDTO();
		Optional<PetDTO> optionalPetDTO = Optional.of(expectedPetDTO);
		when(petRepository.findById(1)).thenReturn(optionalPetDTO);
		PetDTO actualPetDTO = petServiceImpl.findPet(1);
		assertEquals(expectedPetDTO, actualPetDTO);
		verify(petRepository, times(1)).findById(1);
	}

	@Test
	void testFindPetWhenNotFound() {
		String expectedMessage = "Can't find pet with petId 2";
		Optional<PetDTO> optionalPetDTO = Optional.empty();
		when(petRepository.findById(2)).thenReturn(optionalPetDTO);
		PetNotFoundException actualException = assertThrows(PetNotFoundException.class,
				() -> petServiceImpl.findPet(2));
		assertEquals(expectedMessage, actualException.getMessage());
		verify(petRepository, times(1)).findById(2);
	}
}
