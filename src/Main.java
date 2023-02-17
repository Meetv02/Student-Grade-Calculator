import java.util.Scanner;

public class Main {
    public static void homeMenu(){
         try{
                 Scanner sc = new Scanner(System.in);
                 UserRegister register=new UserRegister();
        while(true){
//            System.out.println("\033\143");
            System.out.println("**************************");
            System.out.println("|          Menu          |");
            System.out.println("**************************");
            System.out.println("--------------------------");
            System.out.println("| 1 - Login              |");
            System.out.println("| 2 - Register           |");
            System.out.println("| 3 - Exit               |");
            System.out.println("--------------------------");

            //Taking choice input from user
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.print("| Enter Your Choice : ");
            int ch = sc.nextInt();
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
            switch(ch){
                case 1 :
                    //calling Login Function with register object which contains user data
                    UserLogin userLogin = new UserLogin(register);
                    userLogin.loginMenu();
                    break;
                case 2 :
                    //calling register function To register new user
                    register.Register();
                    break;
                case 3 :
                    //Exiting from Application
                    System.exit(0);
                    break;
                default:
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    System.out.println("| Wrong choice!! Try Again...   |");
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    break;
            }
        }
         }catch(Exception e){
            System.out.println("something went wrong"+e);
         }
    }
    public static void main(String[] args) {
        //calling homeMenu function where Main menu will be displayed
        homeMenu();
    }
}