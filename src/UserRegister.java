import  java.util.Scanner;
public class UserRegister {

    public  void  Register(){
        try {
            Scanner scanner = new Scanner(System.in);
            // Register
            System.out.print("Full Name: ");
            String FullName = scanner.nextLine();             
            System.out.print("Username: ");
            String Username = scanner.next();
            System.out.print("Password: ");
            String Password = scanner.next();            
            System.out.println("Registration Successful!");
        }catch (Exception e){
            System.out.println("Registration Error"+e);
        }
    }
}
