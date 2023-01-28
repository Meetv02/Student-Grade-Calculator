import  java.util.Scanner;
public class UserRegister {

    public  void  Register(){
        try {
            Scanner scanner = new Scanner(System.in);
            // Register
            System.out.print("Full Name: ");
            String FullName = scanner.nextLine();

            if(scanner.hasNext("[A-Za-z]*")) {
                input = sc.next();
                System.out.println("You entered a string value "+input);
            }else {
                System.out.println("Please Enter a Valid Value");
            }
            System.out.print("Username: ");
            String Username = scanner.next();
            System.out.print("Password: ");
            String Password = scanner.next();

            // validate username
            if (Username.trim().isEmpty()) {
                System.out.println("Username cannot be blank.");
                //return;
            }
            System.out.println("Registration Successful!");
        }catch (Exception e){
            System.out.println("Registration Error"+e);
        }


    }


}
