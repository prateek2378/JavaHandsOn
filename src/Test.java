import record.*;
import java.util.*;

public class Test {
    private static int noOfRecords = 0;
    private static List<Record> records = new ArrayList<Record>();
    private static int activeRecord = -1;

    private static void createNewRecord(){
        noOfRecords++;
        Record temp = new Record();
        records.add(temp);
    }
    private static void printAllRecords(){
        for(int i=0;i<noOfRecords;i++){
            System.out.println(i+1+": Record"+(i+1));
        }
    }

    private static int enterInt(){
        Scanner s = new Scanner(System.in);
        int newInt;
        while(!s.hasNextInt()){
            System.out.println("Does not match required input format enter again:");
            s.next();
        }
        newInt = s.nextInt();
        String temp = s.nextLine();
        return(newInt);
    }

    public static void main(String[] args){
        while(true){
            System.out.println("Enter commands from the list below");
            if(noOfRecords == 0){
                System.out.println("1: Create new Record");
                System.out.println("2: Exit");
                int input = enterInt();
                if(input == 1){
                    createNewRecord();
                }
                else if(input == 2){
                    break;
                }
                else{
                    System.out.println("Wrong Input");
                }
            }
            else{
                System.out.println("1: Create new Record");
                System.out.println("2: Enter a record");
                System.out.println("3: Exit");
                int input = enterInt();
                if(input == 1){
                    createNewRecord();
                }
                else if(input == 2){
                    Record currentRecord;
                    while(true) {
                        System.out.println("Which record do you want to access?");
                        printAllRecords();
                        System.out.println(noOfRecords + 1 + ": Go Back");
                        int recordInput = enterInt();
                        if (recordInput <= noOfRecords) {
                            activeRecord = recordInput;
                            System.out.println("Entered Record" + activeRecord);
                            currentRecord = records.get(recordInput - 1);
                            while(true) {
                                System.out.println("Choose a command for this record");
                                System.out.println("1: No of employees in Record");
                                System.out.println("2: Print all Employees in Record");
                                System.out.println("3: Add an Employee");
                                System.out.println("4: Get Employee Details");
                                System.out.println("5: Edit an Employee's record");
                                System.out.println("6: Delete an Employee's record");
                                System.out.println("7: Go back");
                                int recordCommand = enterInt();
                                if(recordCommand == 1){
                                    currentRecord.printNoOfEmployee();
                                }
                                else if(recordCommand == 2){
                                    currentRecord.printRecord();
                                }
                                else if(recordCommand == 3){
                                    currentRecord.addEmployee();
                                }
                                else if(recordCommand == 4){
                                    currentRecord.getDetails();
                                }
                                else if(recordCommand == 5){
                                    currentRecord.editDetails();
                                }
                                else if(recordCommand == 6){
                                    currentRecord.deleteEmployee();
                                }
                                else if(recordCommand == 7){
                                    currentRecord = null;
                                    activeRecord = -1;
                                    break;
                                }
                                else{
                                    System.out.println("Enter correct Command");
                                }
                            }
                        }
                        else if (recordInput == noOfRecords + 1) {
                            break;
                        }
                        else {
                            System.out.println("Wrong Input");
                        }
                    }
                }
                else if(input == 3){
                    break;
                }
                else{
                    System.out.println("Wrong Input");
                }
            }
        }
    }
}
