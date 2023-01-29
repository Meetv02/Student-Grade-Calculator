import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeCard {
    Map<String,Integer> markData = new HashMap<String,Integer>();

    public void getInput(){
        int studID,noOfSub,marks;
        String subName;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student ID : ");
        studID = sc.nextInt();

        System.out.println("Enter No. of Subjects : ");
        noOfSub = sc.nextInt();

        for(int i=0;i<noOfSub;i++){
            System.out.println("Enter Subject Name : ");
            subName = sc.nextLine();
            System.out.println("Enter Marks : ");
            marks = sc.nextInt();
            markData.put(subName,marks);
        }

        displayData();
    }

    public void displayData(){
        System.out.println("Marks In Each Subject");
        int total=0;

        for(Map.Entry<String,Integer> entry : markData.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
            total+=entry.getValue();
        }
        System.out.println("\nTotal Marks Obtained : "+total);
        marksMenu();

    }
    public void marksMenu(){
        int ch;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Options");
            System.out.println("1 - Show Percentage");
            System.out.println("2 - Show Grades");
            System.out.println("3 - Show Status");
            System.out.println("4 - Log Out");
            System.out.println("5 - Back");

            System.out.println("Enter Choice : ");
            ch = sc.nextInt();
            switch(ch){
                case 1 :
                    getPercentage();
                    break;
                case 2 :
                    System.out.println("Your Grade is : "+getGrades());
                    break;
                case 3 :
                    if(getStatus()){
                        System.out.println("Your status is : PASS");
                    }else{
                        System.out.println("Your status is : FAIL");
                    }
                    break;
                case 4 :
                    new Main().homeMenu();
                    return;
                case 5 :
                    return;
                default:
                    System.out.println("Invalid Input!! Try again...");
                    break;
            }
        }
    }

    public int getPercentage(){
        int total=0;

        for(Map.Entry<String,Integer> entry : markData.entrySet()){
            total+=entry.getValue();
        }

        return total/markData.size();
    }

    public char getGrades(){
        int percentage = getPercentage();

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
    }

    public boolean getStatus(){
        int percentage = getPercentage();
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
    }
}
