package EmailApplication;

import java.util.Scanner;

public class Email {
    
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "aeycompany.com";

	// Constructor to receive the first name and last name
	// instead of defining the variable outright we are defining it through this API
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		// System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

		// call a method asking from the Department = return the department
		this.department = setDepartment();
		// System.out.println("Department: " + this.department);

		// call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);

		// combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		// System.out.println("Your email is: " + email);
	}

	// Ask for the department

	private String setDepartment() {
		System.out.println("New Worker: " + firstName
				+ ". DEPARTMENT CODES:\n1 for Sales\n2 for Development \n3 for Accouting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "Sales";
		} else if (depChoice == 2) {
			return "dev";
		} else if (depChoice == 3) {
			return "acct";
		} else {
			return "";
		}
	}

	// General a random password

	private String randomPassword(int length) {
		// The algorithm here is to generate a random number and look at this as an
		// array and find the value of this array at any given number
		// generating a random number basically with in the scope of string passwrodSet
		// then we are going to take the character
		// at that random number and pass that into the array one at a time
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// Set the mailbox capacity
	// This is encapsulation ; making it public so some properties can be set; and
	// we are hiding the actual properties
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// set alternate email

	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// Change the password
	public void changePassword(String password) {
		this.password = password;

	}

	// implementing get methods
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	public String showInfo() {
		return "Display NAME: " + firstName + " " + lastName + "\nCompany Email: " + email + "\nMAILBOX CAPACITY: "
				+ mailboxCapacity + "mb";
	}

}