package com.scaleupindia.exception;

/**
 * @author abhishekvermaa10
 *
 */
public class DuplicateOwnerIdException extends Exception {
	private static final long serialVersionUID = 1L;

	public DuplicateOwnerIdException(String message) {
		super(message);
	}
}
