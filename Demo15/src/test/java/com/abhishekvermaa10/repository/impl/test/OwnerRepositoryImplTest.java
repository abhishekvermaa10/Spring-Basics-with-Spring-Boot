package com.abhishekvermaa10.repository.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.abhishekvermaa10.exception.OwnerNotFoundException;
import com.abhishekvermaa10.repository.impl.OwnerRepositoryImpl;

/**
 * @author abhishekvermaa10
 *
 */
@TestPropertySource("classpath:messages.properties")
@SpringBootTest(classes = OwnerRepositoryImpl.class)
class OwnerRepositoryImplTest {
	@Autowired
	private OwnerRepositoryImpl ownerRepositoryImpl;

	@Test
	void testFindOwnerWhenOwnerFound() throws OwnerNotFoundException {
		String expectedMessage = "Found owner with ownerId 100";
		String actualMessage = ownerRepositoryImpl.findOwner(100);
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	void testFindOwnerWhenOwnerNotFound() {
		String expectedMessage = "Can't find owner with ownerId 101";
		OwnerNotFoundException actualException = assertThrows(OwnerNotFoundException.class,
				() -> ownerRepositoryImpl.findOwner(101));
		assertEquals(expectedMessage, actualException.getMessage());
	}
}
