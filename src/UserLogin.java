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
            String password,uname;
            String fmt="*";
            //getting username input
            System.out.println("Enter Username : ");
            uname = cnl.readLine();
            System.out.println("Enter Password : ");
            password = cnl.readPassword(fmt,"enter password").toString();

            if(new Authenticate().verifyLogin(uname, password, register)){

            }
        }catch(Exception e){
            System.out.println("Login Error "+e);
        }
    }

    public void forgetPassword(){
        try{
            Console cnl = System.console();
            String password,uname;

            System.out.println("Enter your Username : ");
            uname = cnl.readLine();
            System.out.println("Enter New Password : ");
            password = cnl.readPassword().toString();
        }catch (Exception e){
            System.out.println("Forget Password Error "+e);
        }
    }

    public static void main(String[] args){

    }
}