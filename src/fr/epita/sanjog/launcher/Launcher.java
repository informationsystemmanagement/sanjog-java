/**
 * 
 */
package fr.epita.sanjog.launcher;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import fr.epita.sanjog.datamodel.Identity;
import fr.epita.sanjog.services.Authentication;
import fr.epita.sanjog.services.IdentityJDBC;

/**
 * @author Admin
 *
 */
public class Launcher {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the user name");
		String userName = scanner.nextLine();
		System.out.println("Password :");
		String password = scanner.nextLine();
		
		if (!Authentication.authenticate(userName, password)) {
			System.out.println("unable to authenticate");
			return;
		} else {
			// We are authenticated	
			String answer = "";
				System.out.println("1. Create Identity");
				System.out.println("2. Update Identity");
				System.out.println("3. Delete Identity");
				System.out.println("4. listing");
				System.out.println("5. Quit");
				System.out.println("your choice : ");
				
				 System.out.println("Enter your choice");
				 answer = scanner.nextLine();

			

				switch (answer) {
				case "1":
					// Create Identity
					System.out.println(" you have selected the identity creation");
					System.out.println("Enter name of identity");
					String uname = scanner.nextLine();
					System.out.println("enter the email id of user");
					String uemail = scanner.nextLine();
					
					Identity identity = new Identity( uname, uemail);
					
					IdentityJDBC ident = new IdentityJDBC();
					ident.insert1(identity);
					System.out.println("intity added into database");
					
					break;
				case "2":

					// Update Identity
					System.out.println("Identity Update");
					System.out.println("enter the name for which you edit");
					String unameedit = scanner.nextLine();
					System.out.println("enter the new email you want to update");
					String uemailedit = scanner.nextLine();
                Identity identity1 = new Identity(unameedit, uemailedit);
					IdentityJDBC identupdate = new IdentityJDBC();
					identupdate.update(identity1);
					System.out.println("intity updated into database");
					
					break;
				case "3":

					// Delete Identity
					System.out.println("Identity Deletion");
					System.out.println("you have selected identity deletion");
					System.out.println("Enter the name you want to delete");
					String nametodelete = scanner.nextLine();
					Identity identdelete = new Identity(nametodelete, null );
					IdentityJDBC ijdelete = new IdentityJDBC();
					ijdelete.delete(identdelete);
					System.out.println("You have sucessfully deleted an identity");
					
					break;

				case "4":
					ListIdentity();
					
					break;
					
					
				case "5":
					
					System.out.println("you decided to quit, bye!");
					
					break;
				default:

					System.out.println("unrecognized option : type 1,2,3 or 4 to quit");
					break;
				}

			

		}

	}
	public static void ListIdentity() throws SQLException  {
		System.out.println("Identity Listing");
		IdentityJDBC identityWriter = new IdentityJDBC();

		List<Identity> allIdentities = identityWriter.readAllIdentities();
		//System.out.println(allIdentities);
		for (Identity iden : allIdentities) {
		    System.out.println(iden.getUname()+"--"+iden.getUemail());
		}

		System.out.println(" Succesfully you have listed the identities");

	}

	}


