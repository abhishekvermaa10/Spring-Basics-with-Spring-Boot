package com.scaleupindia;

import com.scaleupindia.service.OwnerService;
import com.scaleupindia.service.impl.OwnerServiceImpl;

/**
 * @author abhishekvermaa10
 *
 */
public class Demo {
	public static void main(String[] args) {
		OwnerService ownerService = new OwnerServiceImpl(10);
		System.out.println(ownerService.findOwner());
	}
}
