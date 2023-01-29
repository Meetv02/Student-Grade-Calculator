import java.io.Console;
import java.util.Scanner;

public class UserLogin {
    UserRegister register;
    UserLogin(UserRegister register){
        this.register = register;
    }

    public void loginMenu(){
        int ch;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Options");
            System.out.println("1 - Enter Credentials");
            System.out.println("2 - Forget Password");
            System.out.println("3 - Back");

            System.out.println("Enter Choice : ");
            ch = sc.nextInt();
            switch(ch){
                case 1 :
                    new UserLogin(this.register).Login();
                    break;
                case 2 :
                    new UserLogin(this.register).forgetPassword();
                    break;
                case 3 :
                    return;
                default:
                    System.out.println("Invalid Input!! Try again...");
                    break;
            }
        }
    }
    public void Login(){
        try{
            Console cnl = System.console();
            String uname;
            String fmt="*";
            //getting username input
            System.out.println("Enter Username : ");
            uname = cnl.readLine();
            //Username Validation
            while (uname.length() < 6) {
                System.out.println("Error: Name must be at least 6 characters long and only alphabet.");
                System.out.print("Enter Username : ");
                uname = cnl.readLine();
            }
            System.out.println("Enter Password : ");
           char[] password = cnl.readPassword(fmt,"Enter Password");
            if(new Authenticate().verifyLogin(uname, new String(password), register)){

            }
        }catch(Exception e){
            System.out.println("Login Error "+e);
        }
    }

    public void forgetPassword(){
        try{
            Console cnl = System.console();
            String uname;

            System.out.println("Enter your Username : ");
            uname = cnl.readLine();
            while (uname.length() < 6) {
                System.out.println("Error: Name must be at least 6 characters long and only alphabet.");
                System.out.println("Enter your Username : ");
                uname = cnl.readLine();
            }
            char[] password = cnl.readPassword("Enter New password:");
            while (!register.isValidPassword( new String(password))){
                System.out.println("Error: Password must contain 6 characters long, one lowercase letter, one uppercase letter, and one digit.");
                password = cnl.readPassword("Enter your password:");
            }
        }catch (Exception e){
            System.out.println("Forget Password Error "+e);
        }
    }

    public static void main(String[] args){

    }
}