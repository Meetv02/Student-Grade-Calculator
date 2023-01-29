import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserRegister register=new UserRegister();
        while(true){
            System.out.println("Menu");
            System.out.println("-------------------------\n");
            System.out.println("1 - Login");
            System.out.println("2 - Regiter");
            System.out.println("3 - Exit");

            System.out.println("\nEnter Your Choice : ");
            int ch = sc.nextInt();
            switch(ch){
                case 1 :
                    UserLogin userLogin = new UserLogin(register);
                    userLogin.loginMenu();
                    break;
                case 2 :
                    register.Register();
                    break;
                case 3 :
                    return;
                default:
                    System.out.println("Wrong choice!! Try Again...");
                    break;
            }
        }
    }
}