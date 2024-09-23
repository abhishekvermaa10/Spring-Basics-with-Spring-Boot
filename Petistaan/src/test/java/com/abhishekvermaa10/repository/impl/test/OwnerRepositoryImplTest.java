package com.abhishekvermaa10.repository.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.abhishekvermaa10.dto.DomesticPetDTO;
import com.abhishekvermaa10.dto.OwnerDTO;
import com.abhishekvermaa10.repository.impl.OwnerRepositoryImpl;

@SpringBootTest(classes = OwnerRepositoryImpl.class)
class OwnerRepositoryImplTest {
	@Autowired
	private OwnerRepositoryImpl ownerRepositoryImpl;
	private List<OwnerDTO> ownerDTOList;

	@BeforeEach
	public void setUp() {
		ownerDTOList = (List<OwnerDTO>) ReflectionTestUtils.getField(ownerRepositoryImpl, "ownerDTOList");
		ownerDTOList.clear();
	}

	@Test
	void testSave() {
		OwnerDTO expectedOwnerDTO = new OwnerDTO();
		expectedOwnerDTO.setId(1);
		ownerDTOList.add(expectedOwnerDTO);
		ownerRepositoryImpl.save(expectedOwnerDTO);
		assertEquals(expectedOwnerDTO, ownerDTOList.get(0));
	}

	@Test
	void testFindByIdWhenFound() {
		OwnerDTO expectedOwnerDTO = new OwnerDTO();
		expectedOwnerDTO.setId(1);
		ownerDTOList.add(expectedOwnerDTO);
		Optional<OwnerDTO> actualOptionalOwnerDTO = ownerRepositoryImpl.findById(1);
		assertEquals(expectedOwnerDTO, actualOptionalOwnerDTO.get());
	}

	@Test
	void testFindByIdWhenNotFound() {
		Optional<OwnerDTO> expectedOptionalOwnerDTO = Optional.empty();
		Optional<OwnerDTO> actualOptionalOwnerDTO = ownerRepositoryImpl.findById(1);
		assertEquals(expectedOptionalOwnerDTO, actualOptionalOwnerDTO);
	}
	
	@Test
	void testUpdatePetDetailsWhenFound() {
		OwnerDTO expectedOwnerDTO = new OwnerDTO();
		expectedOwnerDTO.setId(1);
		DomesticPetDTO expectedPetDTO = new DomesticPetDTO();
		expectedPetDTO.setId(1);
		expectedPetDTO.setName("Max");
		expectedOwnerDTO.setPetDTO(expectedPetDTO);
		ownerDTOList.add(expectedOwnerDTO);
		ownerRepositoryImpl.updatePetDetails(1, "Tom");
		assertEquals("Tom", expectedOwnerDTO.getPetDTO().getName());
	}
	
	@Test
	void testUpdatePetDetailsWhenNotFound() {
		OwnerDTO expectedOwnerDTO = new OwnerDTO();
		expectedOwnerDTO.setId(1);
		DomesticPetDTO expectedPetDTO = new DomesticPetDTO();
		expectedPetDTO.setId(1);
		expectedPetDTO.setName("Max");
		expectedOwnerDTO.setPetDTO(expectedPetDTO);
		ownerDTOList.add(expectedOwnerDTO);
		ownerRepositoryImpl.updatePetDetails(2, "Tom");
		assertEquals("Max", expectedOwnerDTO.getPetDTO().getName());
	}

	@Test
	void testDeleteByIdWhenFound() {
		OwnerDTO expectedOwnerDTO = new OwnerDTO();
		expectedOwnerDTO.setId(1);
		ownerDTOList.add(expectedOwnerDTO);
		ownerRepositoryImpl.deleteById(1);
		assertEquals(0, ownerDTOList.size());
	}
	
	@Test
	void testDeleteByIdWhenNotFound() {
		ownerRepositoryImpl.deleteById(2);
		assertEquals(0, ownerDTOList.size());
	}

	@Test
	void testFindAll() {
		List<OwnerDTO> actualOwnerDTOList = ownerRepositoryImpl.findAll();
		assertNotNull(actualOwnerDTOList);
	}
}
