import java.io.Console;
import java.util.Scanner;

public class UserLogin {
    public void Login(){
        Console cnl = System.console();
        String password,uname;
        String fmt="*";
        //getting username input
        System.out.println("Enter Username : ");
        uname = cnl.readLine();
        System.out.println("Enter Password : ");
        password = cnl.readPassword(fmt,"enter password").toString();
    }

    public void forgetPassword(){
        Console cnl = System.console();
        String password,uname;

        System.out.println("Enter your Username : ");
        uname = cnl.readLine();
    }

    public static void main(String[] args){
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
                    new UserLogin().Login();
                    break;
                case 2 :
                    new UserLogin().forgetPassword();
                    break;
                case 3 :
                    return;
                default:
                    System.out.println("Invalid Input!! Try again...");
                    break;
            }
        }
    }
}