package com.scaleupindia.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.dto.PetDTO;
import com.scaleupindia.enums.Gender;
import com.scaleupindia.enums.PetType;

/**
 * @author abhishekvermaa10
 *
 */
public class InputUtil {
	private InputUtil() {

	}

	public static int acceptMenuOption(Scanner scanner) {
		System.out.println("Press 1 to add new owner.");
		System.out.println("Press 2 to fetch owner details.");
		System.out.println("Press 3 to updated pet details of owner.");
		System.out.println("Press 4 to delete owner details.");
		System.out.println("Press 5 to fetch all owners.");
		System.out.println("Press 6 to fetch owner by initials of first name of owner.");
		System.out.println("Press 7 to fetch owner details by pet id.");
		System.out.println("Press 8 to fetch owner details whose pets born within a time period.");
		System.out.println("Press 9 to fetch owners by their cities.");
		int menuOption = scanner.nextInt();
		if (menuOption == 1 || menuOption == 2 || menuOption == 3 || menuOption == 4 || menuOption == 5
				|| menuOption == 6 || menuOption == 7 || menuOption == 8 || menuOption == 9) {
			return menuOption;
		} else {
			return acceptMenuOption(scanner);
		}
	}

	public static boolean wantToContinue(Scanner scanner) {
		System.out.println("Press Y to continue and N to exit.");
		char choice = scanner.next().toUpperCase().charAt(0);
		return 'Y' == choice;
	}

	public static OwnerDTO acceptOwnerDetailsToSave(Scanner scanner) {
		System.out.println("Enter first name of owner:");
		String firstName = scanner.next();
		System.out.println("Enter last name of owner:");
		String lastName = scanner.next();
		System.out.println("Enter gender of owner:" + Arrays.asList(Gender.values()).toString());
		String gender = scanner.next().toUpperCase();
		System.out.println("Enter city of owner:");
		String city = scanner.next();
		System.out.println("Enter state of owner:");
		String state = scanner.next();
		System.out.println("Enter mobile number of owner:");
		String mobileNumber = scanner.next();
		System.out.println("Enter email id of owner:");
		String emailId = scanner.next();
		try {
			OwnerDTO ownerDTO = new OwnerDTO();
			ownerDTO.setFirstName(firstName);
			ownerDTO.setLastName(lastName);
			ownerDTO.setGender(Gender.valueOf(gender));
			ownerDTO.setCity(city);
			ownerDTO.setState(state);
			ownerDTO.setMobileNumber(mobileNumber);
			ownerDTO.setEmailId(emailId);
			return ownerDTO;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return acceptOwnerDetailsToSave(scanner);
		}
	}

	public static PetDTO acceptPetDetailsToSave(Scanner scanner) {
		System.out.println("Enter name of pet:");
		String petName = scanner.next();
		System.out.println("Enter date of birth of pet (dd-MM-yyyy):");
		String petDateOfBirth = scanner.next();
		System.out.println("Enter gender of pet:" + Arrays.asList(Gender.values()).toString());
		String petGender = scanner.next().toUpperCase();
		System.out.println("Enter pet type:" + Arrays.asList(PetType.values()).toString());
		String petType = scanner.next().toUpperCase();
		try {
			PetDTO petDTO = new PetDTO();
			petDTO.setName(petName);
			petDTO.setBirthDate(convertStringToDate(petDateOfBirth));
			petDTO.setGender(Gender.valueOf(petGender));
			petDTO.setType(PetType.valueOf(petType));
			return petDTO;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return acceptPetDetailsToSave(scanner);
		}
	}

	public static String acceptPetDetailsToUpdate(Scanner scanner) {
		System.out.println("Enter updated name of pet:");
		return scanner.next();
	}

	public static int acceptOwnerIdToOperate(Scanner scanner) {
		System.out.println("Enter id of owner:");
		return scanner.nextInt();
	}

	public static String acceptOwnerInititialsToOperate(Scanner scanner) {
		System.out.println("Enter initials of first name of owner:");
		return scanner.next();
	}

	public static int acceptPetIdToOperate(Scanner scanner) {
		System.out.println("Enter id of pet:");
		return scanner.nextInt();
	}

	public static LocalDate acceptFromPetBirthDateToOperate(Scanner scanner) {
		System.out.println("Enter start date of birth of pet (dd-MM-yyyy):");
		return convertStringToDate(scanner.next());
	}

	public static LocalDate acceptToPetBirthDateToOperate(Scanner scanner) {
		System.out.println("Enter end date of birth of pet (dd-MM-yyyy):");
		return convertStringToDate(scanner.next());
	}

	public static List<String> acceptOwnerCitiesToOperate(Scanner scanner) {
		List<String> cities = new ArrayList<>();
		char choice;
		do {
			System.out.println("Enter city of owner:");
			cities.add(scanner.next());
			System.out.println("Press Y to enter another city.");
			choice = scanner.next().toUpperCase().charAt(0);
		} while ('Y' == choice);
		return cities;
	}

	public static LocalDate convertStringToDate(String stringDate) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(stringDate, format);
	}
}
