import java.util.ArrayList;

public class Authenticate {

    public int verifyLogin(String userName, String password, UserRegister register){
        try{
         for(int i=0;i<register.UserList.size();i++){
            if(register.UserList.get(i).indexOf(userName)==1){
                if(register.UserList.get(i).get(2).equals(password)){
                    return 1;
                }else{
                    return 2;
                }
            }
        }
         return 0;
         }catch(Exception e){
            System.out.println("something went wrong"+e);
             return 0;
         }
    }

    public int verifyUsername(String userName, UserRegister register){
        try{
            for(int i=0;i<register.UserList.size();i++) {
                if (register.UserList.get(i).indexOf(userName) == 1) {
                    return i;
                }
            }
            return -1;
         }catch(Exception e){
            System.out.println("something went wrong"+e);
            return -1;
         }
    }
    public static void main(String[] argv){

    }
}
