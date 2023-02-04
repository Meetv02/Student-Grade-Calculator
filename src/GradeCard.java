import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeCard {
    Map<String,Integer> markData = new HashMap<String,Integer>();

    public void getInput(){
        try{

        //System.out.println("\033\143");
        int studID,noOfSub,marks;
        String subName;
        Scanner sc = new Scanner(System.in);

        System.out.print("| Enter Student ID : ");
        studID = sc.nextInt();
        System.out.println("-------------------------");
        System.out.print("| Enter No. of Subjects : ");
        noOfSub = sc.nextInt();
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");

        for(int i=0;i<noOfSub;i++){
            sc.nextLine();
            System.out.print("Enter Subject Name : ");
            subName = sc.nextLine();
            System.out.print("Enter Marks : ");
            marks = sc.nextInt();
            if(marks<0 || marks>100){
                System.out.println("Enter marks between 0 and 100");
                i--;
            }else{
                markData.put(subName,marks);
            }
            System.out.println("-------------------------");
        }

        displayData();

         }catch(Exception e){
            System.out.println("something went wrong"+e);
         }
    }

    public void displayData(){
       try{
           System.out.println("Marks In Each Subject");
           int total=0;

           for(Map.Entry<String,Integer> entry : markData.entrySet()){
               System.out.println(entry.getKey() + " = " + entry.getValue());
               total+=entry.getValue();
           }
           System.out.println("\nTotal Marks Obtained : "+total);
           marksMenu();
         }catch(Exception e){
            System.out.println("something went wrong"+e);
         }

    }
    public void marksMenu(){

         try{
             int ch;
            Scanner sc = new Scanner(System.in);
            while(true){
            //System.out.println("\033\143");
                System.out.println("*************************");
                System.out.println("| Options               |");
                System.out.println("*************************");
                System.out.println("-------------------------");
                System.out.println("| 1 - Show Percentage   |");
                System.out.println("| 2 - Show Grades       |");
                System.out.println("| 3 - Show Status       |");
                System.out.println("| 4 - Log Out           |");
                System.out.println("| 5 - Back              |");
                System.out.println("-------------------------");

                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.print("| Enter Choice : ");
                ch = sc.nextInt();
                switch(ch){
                    case 1 :
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                        System.out.println("| Your Percentage is : " + getPercentage() + "%" + " |");
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                        break;
                    case 2 :
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                        System.out.println("| Your Grade is : "+getGrades() +" |");
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                        break;
                    case 3 :
                        if(getStatus()){
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                            System.out.println("| Your status is : PASS           |");
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                        }else{
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                            System.out.println("| Your status is : FAIL         |");
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                        }
                        break;
                    case 4 :
                        new Main().homeMenu();
                        return;
                    case 5 :
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
    public float getPercentage(){
        try{
            int total=0;
            for(Map.Entry<String,Integer> entry : markData.entrySet()){
                total+=entry.getValue();
            }
            return total/markData.size();
         }catch(Exception e){
            System.out.println("something went wrong"+e);
         }
        return 0;
    }

    public char getGrades(){
        try{        
            float percentage = getPercentage();
            if(percentage>=90){
                return 'A';
            }else if(percentage>=80){
                return 'B';
            }else if(percentage>=70){
                return 'C';
            }else if(percentage>=60){
                return 'D';
            }else if(percentage>=40){
                return 'E';
            }
            return 'F';
         }catch(Exception e){
            System.out.println("something went wrong"+e);
            return ' ';
         }
    }

    public boolean getStatus(){
        try{
            float percentage = getPercentage();
            boolean flag=true;

            for(Map.Entry<String,Integer> entry : markData.entrySet()){
                if(entry.getValue()<35){
                    flag=false;
                    break;
                }
            }
            if(flag && percentage>=40){
                return true;
            }
            return false;
         }catch(Exception e){
            System.out.println("something went wrong"+e);
            return false;
         }

       
    }
}
