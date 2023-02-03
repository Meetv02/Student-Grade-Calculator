import java.io.Console;
import java.util.Scanner;

public class UserLogin {
    UserRegister register;
    UserLogin(UserRegister register){
        this.register = register;
    }

    public void loginMenu(){
         
         try{
            int ch;
            Scanner sc = new Scanner(System.in);
            while(true){
            // System.out.println("\033\143");

                System.out.println("*************************");
                System.out.println("| Options               |");
                System.out.println("*************************");

                System.out.println("-------------------------------------------------");
                System.out.println("| 1 - Enter Credentials (Username And Password) |");
                System.out.println("| 2 - Forget Password                           |");
                System.out.println("| 3 - Back                                      |");
                System.out.println("-------------------------------------------------");

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.print("| Enter Choice :");
                ch = sc.nextInt();
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
                switch(ch){
                    case 1 :
                        Login();
                        break;
                    case 2 :
                        forgetPassword();
                        break;
                    case 3 :
                        return;
                    default:
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                        System.out.println("| Invalid Input!! Try again...  |");
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                        break;
                }
            }
         }catch(Exception e){
            System.out.println("something went wrong"+e);
         }
        
        
        
    }
    public void Login(){
        try{
            Console cnl = System.console();
            String uname;
            String fmt="*";
            //getting username input
            uname = cnl.readLine("| Enter Username : ");
            System.out.println("-------------------------");

            //Username Validation
            while (uname.length() < 6) {

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("| Error: Name must be at least 6 characters long and only alphabet. |");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("| Enter Username :      |");
                uname = cnl.readLine();
                System.out.println("-------------------------");
            }
            char[] password = cnl.readPassword("| Enter Password :      |");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");

            Authenticate auth = new Authenticate();
            int status = auth.verifyLogin(uname, new String(password), register);

            if(status==1){
                new GradeCard().getInput();
            }else if(status==2){
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("| Wrong Password!! Try Again... |");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            }else{
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("| Username does not exist, Please Register First    |\n");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                loginMenu();
            }
        }catch(Exception e){
            System.out.println("*-*-*-*-*-*-*-*-*-*");
            System.out.println("| Login Error "+e);
            System.out.println("*-*-*-*-*-*-*-*-*-*");
        }
    }

    public void forgetPassword(){
        try{
            Console cnl = System.console();
            String uname;

            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("| Enter Your Username :      |");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");

            uname = cnl.readLine();

            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("| Enter New Password : ");
            char[] password = cnl.readPassword();
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");

            int index = new Authenticate().verifyUsername(uname,register);

            if(index>=0){
                register.UserList.get(index).set(2,new String(password));
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("| Password Updated successfully |");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                //System.out.println(register.UserList.get(index).get(2));
            }else{
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("| UserName does not exist!! Try Again...  |");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            }
        }catch (Exception e){
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("| Forget Password Error "+e);
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }
    }
}