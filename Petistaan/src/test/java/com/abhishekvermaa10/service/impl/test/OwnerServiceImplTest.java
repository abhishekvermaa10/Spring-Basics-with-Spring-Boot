package com.abhishekvermaa10.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import com.abhishekvermaa10.dto.DomesticPetDTO;
import com.abhishekvermaa10.dto.OwnerDTO;
import com.abhishekvermaa10.exception.DuplicateOwnerIdException;
import com.abhishekvermaa10.exception.OwnerNotFoundException;
import com.abhishekvermaa10.repository.OwnerRepository;
import com.abhishekvermaa10.service.impl.OwnerServiceImpl;

/**
 * @author abhishekvermaa10
 *
 */
@TestPropertySource("classpath:messages.properties")
@SpringBootTest(classes = OwnerServiceImpl.class)
class OwnerServiceImplTest {
	@Autowired
	private OwnerServiceImpl ownerServiceImpl;
	@MockBean
	private OwnerRepository ownerRepository;

	@Test
	void testSaveOwnerWhenNewOwnerId() throws DuplicateOwnerIdException {
		OwnerDTO expectedOwnerDTO = new OwnerDTO();
		expectedOwnerDTO.setId(1);
		Optional<OwnerDTO> optionalOwnerDTO = Optional.empty();
		when(ownerRepository.findById(1)).thenReturn(optionalOwnerDTO);
		ownerServiceImpl.saveOwner(expectedOwnerDTO);
		verify(ownerRepository, times(1)).findById(1);
		verify(ownerRepository, times(1)).save(expectedOwnerDTO);
	}

	@Test
	void testSaveOwnerWhenExistingOwnerId() {
		String expectedMessage = "Owner already exists with ownerId 2";
		OwnerDTO expectedOwnerDTO = new OwnerDTO();
		expectedOwnerDTO.setId(2);
		Optional<OwnerDTO> optionalOwnerDTO = Optional.of(expectedOwnerDTO);
		when(ownerRepository.findById(2)).thenReturn(optionalOwnerDTO);
		DuplicateOwnerIdException actualException = assertThrows(DuplicateOwnerIdException.class,
				() -> ownerServiceImpl.saveOwner(expectedOwnerDTO));
		assertEquals(expectedMessage, actualException.getMessage());
		verify(ownerRepository, times(1)).findById(2);
	}

	@Test
	void testFindOwnerWhenFound() throws OwnerNotFoundException {
		OwnerDTO expectedOwnerDTO = new OwnerDTO();
		expectedOwnerDTO.setId(1);
		Optional<OwnerDTO> optionalOwnerDTO = Optional.of(expectedOwnerDTO);
		when(ownerRepository.findById(1)).thenReturn(optionalOwnerDTO);
		OwnerDTO actualOwnerDTO = ownerServiceImpl.findOwner(1);
		assertEquals(expectedOwnerDTO, actualOwnerDTO);
		verify(ownerRepository, times(1)).findById(1);
	}

	@Test
	void testFindOwnerWhenNotFound() {
		String expectedMessage = "Can't find owner with ownerId 2";
		Optional<OwnerDTO> optionalOwnerDTO = Optional.empty();
		when(ownerRepository.findById(2)).thenReturn(optionalOwnerDTO);
		OwnerNotFoundException actualException = assertThrows(OwnerNotFoundException.class,
				() -> ownerServiceImpl.findOwner(2));
		assertEquals(expectedMessage, actualException.getMessage());
		verify(ownerRepository, times(1)).findById(2);
	}

	@Test
	void testUpdatePetDetailsWhenFound() throws OwnerNotFoundException {
		OwnerDTO expectedOwnerDTO = new OwnerDTO();
		expectedOwnerDTO.setId(1);
		DomesticPetDTO expectedPetDTO = new DomesticPetDTO();
		expectedPetDTO.setId(1);
		expectedPetDTO.setName("Max");
		expectedOwnerDTO.setPetDTO(expectedPetDTO);
		Optional<OwnerDTO> optionalOwnerDTO = Optional.of(expectedOwnerDTO);
		when(ownerRepository.findById(1)).thenReturn(optionalOwnerDTO);
		ownerServiceImpl.updatePetDetails(1, "Tom");
		assertEquals(expectedOwnerDTO.getPetDTO().getName(), optionalOwnerDTO.get().getPetDTO().getName());
		verify(ownerRepository, times(1)).findById(1);
	}

	@Test
	void testUpdatePetDetailsWhenNotFound() {
		String expectedMessage = "Can't find owner with ownerId 2";
		Optional<OwnerDTO> optionalOwnerDTO = Optional.empty();
		when(ownerRepository.findById(2)).thenReturn(optionalOwnerDTO);
		OwnerNotFoundException actualException = assertThrows(OwnerNotFoundException.class,
				() -> ownerServiceImpl.updatePetDetails(2, "Tom"));
		assertEquals(expectedMessage, actualException.getMessage());
		verify(ownerRepository, times(1)).findById(2);
	}

	@Test
	void testDeleteOwnerWhenFound() throws OwnerNotFoundException {
		OwnerDTO expectedOwnerDTO = new OwnerDTO();
		expectedOwnerDTO.setId(1);
		Optional<OwnerDTO> optionalOwnerDTO = Optional.of(expectedOwnerDTO);
		when(ownerRepository.findById(1)).thenReturn(optionalOwnerDTO);
		ownerServiceImpl.deleteOwner(1);
		verify(ownerRepository, times(1)).findById(1);
		verify(ownerRepository, times(1)).deleteById(1);
	}

	@Test
	void testDeleteOwnerWhenNotFound() {
		String expectedMessage = "Can't find owner with ownerId 2";
		Optional<OwnerDTO> optionalOwnerDTO = Optional.empty();
		when(ownerRepository.findById(2)).thenReturn(optionalOwnerDTO);
		OwnerNotFoundException actualException = assertThrows(OwnerNotFoundException.class,
				() -> ownerServiceImpl.deleteOwner(2));
		assertEquals(expectedMessage, actualException.getMessage());
		verify(ownerRepository, times(1)).findById(2);
	}

	@Test
	void testFindAllOwners() {
		List<OwnerDTO> expectedOwnerDTOList = new ArrayList<>();
		when(ownerRepository.findAll()).thenReturn(expectedOwnerDTOList);
		List<OwnerDTO> actualOwnerDTOList = ownerServiceImpl.findAllOwners();
		assertNotNull(actualOwnerDTOList);
		verify(ownerRepository, times(1)).findAll();
	}
}
