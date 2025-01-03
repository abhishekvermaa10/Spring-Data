package com.abhishekvermaa10.util;

import java.util.Scanner;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author abhishekvermaa10
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputUtil {

	public static int acceptMenuOption(Scanner scanner) {
		System.out.println("Press 1 to update pet details of owner.");
		System.out.println("Press 2 to find specific details using pagination.");
		System.out.println("Press 3 to find average age of pet.");
		int menuOption = scanner.nextInt();
		if (menuOption >= 1 && menuOption <= 3) {
			return menuOption;
		} else {
			System.out.println("Invalid option entered.");
			return acceptMenuOption(scanner);
		}
	}

	public static boolean wantToContinue(Scanner scanner) {
		System.out.println("Press Y to continue and N to exit.");
		char choice = scanner.next().toUpperCase().charAt(0);
		return 'Y' == choice;
	}

	public static int acceptOwnerIdToOperate(Scanner scanner) {
		System.out.println("Enter id of owner:");
		return scanner.nextInt();
	}

	public static String acceptPetDetailsToUpdate(Scanner scanner) {
		System.out.println("Enter updated name of pet:");
		return scanner.next();
	}

	public static int acceptPageSizeToOperate(Scanner scanner) {
		System.out.println("Enter page size:");
		int pageSize = scanner.nextInt();
		if (pageSize > 0) {
			return pageSize;
		} else {
			System.out.println("Page size must be greater than 0.");
			return acceptPageSizeToOperate(scanner);
		}
	}

	public static int acceptPageNumberToOperate(Scanner scanner) {
		System.out.println("Enter page number:");
		int pageNumber = scanner.nextInt();
		if (pageNumber > 0) {
			return pageNumber;
		} else {
			System.out.println("Page number must be greater than 0.");
			return acceptPageNumberToOperate(scanner);
		}
	}

}
