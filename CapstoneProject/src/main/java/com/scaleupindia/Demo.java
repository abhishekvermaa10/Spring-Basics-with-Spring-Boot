package com.scaleupindia;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.util.InputUtil;

/**
 * @author abhishekvermaa10
 *
 */
@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class Demo implements CommandLineRunner {
	@Autowired
	private OwnerService ownerService;
	@Value("${greetings.message}")
	private String greetingsMessage;
	@Value("${owner.saved}")
	private String ownerSaved;
	@Value("${owner.found}")
	private String ownerFound;
	@Value("${owner.pet.updated}")
	private String ownerPetUpdated;
	@Value("${owner.removed}")
	private String ownerRemoved;
	@Value("${invalid.option}")
	private String invalidOption;
	private static Logger logger = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println(greetingsMessage);
				int menuOption = InputUtil.acceptMenuOption(scanner);
				switch (menuOption) {
				case 1:
					OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
					PetDTO petDTO = InputUtil.acceptPetDetailsToSave(scanner);
					ownerDTO.setPetDTO(petDTO);
					ownerService.saveOwner(ownerDTO);
					System.out.println(ownerSaved);
					break;
				case 2:
					int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					ownerDTO = ownerService.findOwner(ownerId);
					System.out.println(ownerFound);
					System.out.println(ownerDTO);
					break;
				case 3:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
					ownerService.updatePetDetails(ownerId, petName);
					System.out.println(ownerPetUpdated);
					break;
				case 4:
					ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
					ownerService.deleteOwner(ownerId);
					System.out.println(ownerRemoved);
					break;
				case 5:
					List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
					System.out.println("There are " + ownerDTOList.size() + " owners.");
					ownerDTOList.forEach(System.out::println);
					break;
				default:
					System.out.println(invalidOption);
				}
			} while (InputUtil.wantToContinue(scanner));
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
	}
}
