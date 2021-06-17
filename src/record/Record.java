package record;
import model.*;
import java.util.*;
import java.text.*;

public class Record {
    private ArrayList<Employee> employee;
    private ArrayList<Integer> employeeIDs;
    private int noOfEmployees;

    public Record(){
        employee = new ArrayList<Employee>();
        employeeIDs = new ArrayList<Integer>();
        noOfEmployees = 0;
    }

    private List<Employee> getEmployee(){
        return(employee);
    }
    private int getNoOfEmployees(){
        return(noOfEmployees);
    }

    private int enterInt(){
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
    private String enterString(){
        Scanner s = new Scanner(System.in);
        String newString;
        while(!s.hasNextLine()){
            System.out.println("Does not match required input format enter again:");
            s.next();
        }
        newString = s.nextLine();
        return(newString);
    }
    private double enterDouble(){
        Scanner s = new Scanner(System.in);
        double newDouble;
        while(!s.hasNextDouble()){
            System.out.println("Does not match required input format enter again:");
            s.next();
        }
        newDouble = s.nextDouble();
        String temp = s.nextLine();
        return(newDouble);
    }
    private long enterLong(){
        Scanner s = new Scanner(System.in);
        long newLong;
        while(!s.hasNextLong()){
            System.out.println("Does not match required input format enter again:");
            s.next();
        }
        newLong = s.nextLong();
        String temp = s.nextLine();
        return(newLong);
    }

    private int enterID(){
        System.out.println("Enter ID:");
        int newID = enterInt();
        return(newID);
    }
    private String enterName(){
        System.out.println("Enter Name:");
        String newName = enterString();
        return(newName);
    }
    private Address enterAddress(){
        System.out.println("Enter Address ID:");
        int newAddressID = enterInt();

        System.out.println("Enter Address Line1:");
        String newAddressLine1 = enterString();

        System.out.println("Enter Address Line2:");
        String newAddressLine2 = enterString();

        System.out.println("Enter Landmark:");
        String newLandmark = enterString();

        System.out.println("Enter City:");
        String newCity = enterString();

        System.out.println("Enter State:");
        String newState = enterString();

        System.out.println("Enter Pin:");
        int newPin = enterInt();

        Address newAddress = new Address(newAddressID,newAddressLine1,newAddressLine2,newLandmark,newCity,newState,newPin);
        return(newAddress);
    }
    private ContactInformation enterContactInformation(){
        System.out.println("Enter Contact Information ID:");
        int newContactInformationID = enterInt();

        System.out.println("Enter Phone Number:");
        long newPhoneNo = enterLong();

        System.out.println("Enter Email ID");
        String newEmailID = enterString();

        ContactInformation newContactInformation = new ContactInformation(newContactInformationID,newPhoneNo,newEmailID);
        return(newContactInformation);
    }
    private Department enterDepartment(){
        System.out.println("Enter Department ID:");
        int newDepartmentID = enterInt();

        System.out.println("Enter Department Name");
        String newDepartmentName = enterString();

        Department newDepartment = new Department(newDepartmentID,newDepartmentName);
        return(newDepartment);
    }
    private double enterSalary() {
        System.out.println("Enter Salary:");
        double newSalary = enterDouble();
        return (newSalary);
    }
    private String enterDesignation(){
        System.out.println("Enter Designation");
        String newDesignation = enterString();
        return(newDesignation);
    }
    private Date enterDateOfJoining() throws ParseException {
        System.out.println("Enter date of joining in dd/mm/yyyy format(Default is \'01/01/2021\' if incorrect date is entered)");
        String stringDate = enterString();
        Date newDateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021");
        try {
            newDateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return(newDateOfJoining);
    }
    private ArrayList<String> enterTechnologies(){
        System.out.println("Enter technologies (enter \'end\' to end entering technologies):");
        ArrayList<String> newTechnologies = new ArrayList<String>();
        while(true){
            String temp = enterString();
            temp = temp.toLowerCase();
            if(temp.equalsIgnoreCase("end")){
                break;
            }
            else{
                if(newTechnologies.contains(temp)){
                    System.out.println("Already present");
                }
                else {
                    newTechnologies.add(temp);
                }
            }
        }
        return(newTechnologies);
    }
    private Employee enterManager(){
        System.out.println("Enter Manager ID:");
        int newManagerID = enterInt();
        Employee newManager = null;
        if(newManagerID!=-1) {
            while(true) {
                int indexOfManager = employeeIDs.indexOf(newManagerID);
                if(indexOfManager != -1) {
                    newManager = employee.get(indexOfManager);
                    break;
                }
                else{
                    System.out.println("Manager not found try again");
                    System.out.println("Enter Manager ID:");
                    newManagerID = enterInt();
                    if(newManagerID == -1){
                        break;
                    }
                }
            }
        }
        return(newManager);
    }

    public void printNoOfEmployee(){
        System.out.println(noOfEmployees);
    }
    public void printRecord(){
        for(Employee itr : employee){
            System.out.println(itr.printEmployee());
        }
    }
    public void addEmployee(){
        System.out.println("Ensure that you have entered manager details before entering employee details");
        System.out.println("Choose a command:");
        System.out.println("1: Proceed to add employee");
        System.out.println("Any other number: Cancel adding employee");
        int input = enterInt();
        if(input == 1) {
            while(true) {
                int newID = enterID();
                if (newID == -1) {
                    System.out.println("Cannot enter -1 as ID");
                } else if (!employeeIDs.contains(newID)) {
                    String newName = enterName();
                    Address newAddress = enterAddress();
                    ContactInformation newContactInformation = enterContactInformation();
                    Department newDepartment = enterDepartment();
                    double newSalary = enterSalary();
                    String newDesignation = enterDesignation();
                    Date newDateOfJoining = null;
                    try {
                        newDateOfJoining = enterDateOfJoining();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    ArrayList<String> newTechnologies = enterTechnologies();
                    Employee newManager = enterManager();
                    ArrayList<Employee> newReportees = new ArrayList<Employee>();

                    Employee newEmployee = new Employee(newID, newName, newAddress, newContactInformation, newDepartment, newSalary, newDesignation, newDateOfJoining, newTechnologies, newManager, newReportees);
                    noOfEmployees++;
                    employee.add(newEmployee);
                    employeeIDs.add(newID);
                    if (newManager != null) {
                        newManager.addReportee(newEmployee);
                    }

                    System.out.println("Employee added successfully");
                    break;
                } else {
                    System.out.println("ID already present. Try adding employee again");
                }
            }
        }
    }
    public void getDetails(){
        System.out.println("Enter Employee ID");
        int ID = enterInt();
        if(employeeIDs.contains(ID)){
            int indexOfEmployee = employeeIDs.indexOf(ID);
            Employee newEmployee = employee.get(indexOfEmployee);
            System.out.println(newEmployee.printEmployee());
        }
        else{
            System.out.println("No User with employee ID "+ID+" found in the Record");
        }
    }
    public void editDetails(){
        System.out.println("Enter Employee ID");
        int ID = enterInt();
        if(employeeIDs.contains(ID)){
            int indexOfEmployee = employeeIDs.indexOf(ID);
            Employee newEmployee = employee.get(indexOfEmployee);
            while(true) {
                System.out.println("Which field do you want to edit?");
                System.out.println("1: Edit ID");
                System.out.println("2: Edit Name");
                System.out.println("3: Edit Address");
                System.out.println("4: Edit Contact Information");
                System.out.println("5: Edit Department");
                System.out.println("6: Edit Salary");
                System.out.println("7: Edit Designation");
                System.out.println("8: Edit Date of Joining");
                System.out.println("9: Edit Technologies");
                System.out.println("10: Edit Manager");
                System.out.println("11: Go Back");
                int editCommand =enterInt();
                if (editCommand == 1) {
                    int newID;
                    while(true) {
                        newID = enterID();
                        if (employeeIDs.contains(newID)) {
                            System.out.println("ID already present try again");
                        }
                        else if(newID == -1){
                            System.out.println("Cannot enter -1 as ID");
                        }
                        else{
                            break;
                        }
                    }
                    employeeIDs.remove(employeeIDs.indexOf(newEmployee.getID()));
                    employee.remove(newEmployee);
                    newEmployee.setID(newID);
                    employeeIDs.add(newEmployee.getID());
                    employee.add(newEmployee);
                }
                else if (editCommand == 2) {
                    String newName = enterName();
                    newEmployee.setName(newName);
                }
                else if (editCommand == 3) {
                    Address newAddress = enterAddress();
                    newEmployee.setAddress(newAddress);
                }
                else if (editCommand == 4) {
                    ContactInformation newContactInformation = enterContactInformation();
                    newEmployee.setContactInformation(newContactInformation);
                }
                else if (editCommand == 5) {
                    Department newDepartment = enterDepartment();
                    newEmployee.setDepartment(newDepartment);
                }
                else if (editCommand == 6) {
                    double newSalary = enterSalary();
                    newEmployee.setSalary(newSalary);
                }
                else if (editCommand == 7) {
                    String newDesignation = enterDesignation();
                    newEmployee.setDesignation(newDesignation);
                }
                else if (editCommand == 8) {
                    Date newDateOfJoining = null;
                    try {
                        newDateOfJoining = enterDateOfJoining();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    newEmployee.setDateOfJoining(newDateOfJoining);
                }
                else if (editCommand == 9) {
                    ArrayList<String> newTechnologies = enterTechnologies();
                    newEmployee.setTechnologies(newTechnologies);
                }
                else if (editCommand == 10) {
                    Employee newManager = newEmployee.getManager();
                    int newManagerID = enterID();
                    if (employeeIDs.contains(newManagerID)) {
                        if (newManagerID == newEmployee.getID()) {
                            System.out.println("Same person cannot be its owm manager");
                        }
                        else {
                            int check = -1;
                            for (Employee itr : newEmployee.getReportees()) {
                                if (newManagerID == itr.getID()) {
                                    System.out.println("Employee's reportee cannot be employers manager");
                                    check = 1;
                                    break;
                                }
                            }
                            if (check == -1) {
                                if (newManager != null){
                                    ArrayList<Employee> newManagerReportees = newManager.getReportees();
                                    newManagerReportees.remove(newEmployee);
                                }
                                int newManagerIndex = employeeIDs.indexOf(newManagerID);
                                newManager = employee.get(newManagerIndex);
                                ArrayList<Employee> newManagerReportees = newManager.getReportees();
                                newManagerReportees.add(newEmployee);
                                newEmployee.setManager(newManager);
                            }
                        }
                    }
                    else {
                        if (newManagerID == -1) {
                            if (newManager != null){
                                ArrayList<Employee> newManagerReportees = newManager.getReportees();
                                newManagerReportees.remove(newEmployee);
                            }
                            newManager = null;
                            newEmployee.setManager(newManager);
                        }
                        else {
                            System.out.println("This manager ID not in records please proceed again");
                        }
                    }
                }
                else if (editCommand == 11) {
                    break;
                }
                else{
                    System.out.println("Enter correct Command");
                }
            }
        }
        else{
            System.out.println("No User with employee ID "+ID+" found in the Record");
        }
    }
    public void deleteEmployee(){
        int newEmployeeID = enterID();
        if(employeeIDs.contains(newEmployeeID)) {
            Employee newEmployee = employee.get(employeeIDs.indexOf(newEmployeeID));
            Employee newEmployeeManager = newEmployee.getManager();
            if (newEmployeeManager != null)
            {
                ArrayList<Employee> newEmployeeManagerReportees = newEmployeeManager.getReportees();
                newEmployeeManagerReportees.remove(newEmployee);
                ArrayList<Employee> newEmployeeReportees = newEmployee.getReportees();
                for (Employee itr : newEmployeeReportees) {
                    Employee newEmployeeReporteeManager = newEmployeeManager;
                    newEmployeeManagerReportees.add(itr);
                    itr.setManager(newEmployeeReporteeManager);
                }
            }
            else{
                ArrayList<Employee> newEmployeeReportees = newEmployee.getReportees();
                for (Employee itr : newEmployeeReportees) {
                    Employee newEmployeeReporteeManager = null;
                    itr.setManager(newEmployeeReporteeManager);
                }
            }
            employee.remove(employeeIDs.indexOf(newEmployeeID));
            employeeIDs.remove(employeeIDs.indexOf(newEmployeeID));
            noOfEmployees--;
        }
        else{
            System.out.println("Employee ID not found try again");
        }
    }
}
