package com.abhishekvermaa10.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;

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
	void testFindOwnerWhenOwnerFound() throws OwnerNotFoundException {
		ownerServiceImpl.modifyOwnerId(100);
		String expectedMessage = "Found owner with ownerId 100";
		when(ownerRepository.findOwner(100)).thenReturn(expectedMessage);
		String actualMessage = ownerServiceImpl.findOwner();
		verify(ownerRepository, times(1)).findOwner(100);
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	void testFindOwnerWhenOwnerNotFound() throws OwnerNotFoundException {
		ownerServiceImpl.modifyOwnerId(101);
		String expectedMessage = "Can't find owner with ownerId 101";
		when(ownerRepository.findOwner(101)).thenThrow(new OwnerNotFoundException(expectedMessage));
		OwnerNotFoundException actualException = assertThrows(OwnerNotFoundException.class,
				() -> ownerServiceImpl.findOwner());
		verify(ownerRepository, times(1)).findOwner(101);
		assertEquals(expectedMessage, actualException.getMessage());
	}

	@Test
	void testModifyOwnerId() {
		int expectedOwnerId = 101;
		ownerServiceImpl.modifyOwnerId(expectedOwnerId);
		int actualOwnerId = (int) ReflectionTestUtils.getField(ownerServiceImpl, "ownerId");
		assertEquals(expectedOwnerId, actualOwnerId);
	}
}
