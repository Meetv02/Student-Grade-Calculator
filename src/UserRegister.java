import  java.util.*;
import java.io.Console;
public class UserRegister {
    // Here a List is an ArrayList of ArrayLists
    ArrayList<ArrayList<String> > UserList =new ArrayList<ArrayList<String> >();
    public static boolean isValidPassword(String password) {
        boolean hasLetter = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLetter(c)) {
                hasLetter = true;
            }
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasLetter && hasUpperCase && hasDigit && password.length() >= 6;
    }

    public  void  Register(){
        try {
            Scanner scanner = new Scanner(System.in);
            Console cnl=System.console();
            ArrayList<String> User = new ArrayList<String>();


            // Register
            String FullName,Username;
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.print("| Full Name: ");
            FullName = scanner.nextLine();
            System.out.println("-------------------------");
            //Name Validation
            while (FullName.length() < 1) {
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("| Error: Please Enter the Name    |");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.print("| Full Name: ");
                FullName = scanner.nextLine();
                System.out.println("-------------------------");
            }
            System.out.print("| Username: ");
            Username = scanner.next();
            System.out.println("-------------------------");
            //Username Validation
            while (Username.length() < 6) {
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("| Error: Name must be at least 6 characters long and only alphabet.   |");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.print("Username : ");
                Username = scanner.nextLine();
                System.out.println("-------------------------");
            }
            char[] Password = cnl.readPassword("Enter your password:");
            System.out.println("-------------------------");
            for (int i = 0; i <Password.length; i++) {
                System.out.print("*");
            }
            System.out.println();
            //Password Validation
            while (!isValidPassword( new String(Password))){
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("| Error: Password must contain 6 characters long, one lowercase letter, one uppercase letter, and one digit.   |");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                Password = cnl.readPassword("Enter your password:");
                System.out.println("-------------------------");
            }
            User.add(FullName);
            User.add(Username);
            User.add(new String(Password));
            UserList.add(User);

            for (int i = 0; i < UserList.size(); i++) {
                for (int j = 0; j < UserList.get(i).size(); j++) {
                    System.out.print(UserList.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("| Registration Successful!  |");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

        }catch (Exception e){
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("| Registration Error"+e);
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }
    }
}
