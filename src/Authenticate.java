import java.util.ArrayList;

public class Authenticate {

    //function to verify username and password
    public int verifyLogin(String userName, String password, UserRegister register){
        try{
         for(int i=0;i<register.UserList.size();i++){
             //checking if username exist or not
            if(register.UserList.get(i).indexOf(userName)==1){
                //matching password if username exist
                if(register.UserList.get(i).get(2).equals(password)){
                    //returning 1 if both username and password matches
                    return 1;
                }else{
                    //returning 2 if password does not match
                    return 2;
                }
            }
        }
         //returning 0 if username not exist
         return 0;
         }catch(Exception e){
            System.out.println("something went wrong"+e);
             return 0;
         }
    }

    //function to verify username   for forget password
    public int verifyUsername(String userName, UserRegister register){
        try{
            for(int i=0;i<register.UserList.size();i++) {
                if (register.UserList.get(i).indexOf(userName) == 1) {
                    //returning index where username found
                    return i;
                }
            }
            //returning -1 if username does not match
            return -1;
         }catch(Exception e){
            System.out.println("something went wrong"+e);
            return -1;
         }
    }
    public static void main(String[] argv){

    }
}
