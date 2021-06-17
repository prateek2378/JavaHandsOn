package model;
import java.util.*;


public class Employee {
    private int ID;
    private String name;
    private Address address;
    private ContactInformation contactInformation;
    private Department department;
    private double salary;
    private String designation;
    private Date dateOfJoining;
    private List<String> technologies;
    private Employee manager;
    private List<Employee> reportees;

    public Employee(int newID, String newName, Address newAddress, ContactInformation newContactInformation, Department newDepartment, double newSalary, String newDesignation, Date newDateOfJoining, ArrayList<String> newTechnologies, Employee newManager, ArrayList<Employee> newReportees){
        ID = newID;
        name = newName;
        address = newAddress;
        contactInformation = newContactInformation;
        department = newDepartment;
        salary = newSalary;
        designation = newDesignation;
        dateOfJoining = newDateOfJoining;
        technologies = newTechnologies;
        manager = newManager;
        reportees = newReportees;
    }

    public int getID(){
        return(ID);
    }
    public void setID(int newID){
        ID = newID;
    }
    public String getName(){
        return(name);
    }
    public void setName(String newName){
        name = newName;
    }
    public Address getAddress(){
        return(address);
    }
    public void setAddress(Address newAddress){
        address = newAddress;
    }
    public ContactInformation getContactInformation() {
        return (contactInformation);
    }
    public void setContactInformation(ContactInformation newContactInformation){
        contactInformation = newContactInformation;
    }
    public Department getDepartment(){
        return(department);
    }
    public void setDepartment(Department newDepartment){
        department = newDepartment;
    }
    public double getSalary(){
        return(salary);
    }
    public void setSalary(double newSalary){
        salary = newSalary;
    }
    public String getDesignation(){
        return(designation);
    }
    public void setDesignation(String newDesignation){
        designation = newDesignation;
    }
    public Date getDateOfJoining(){
        return(dateOfJoining);
    }
    public void setDateOfJoining(Date newDateOfJoining){
        dateOfJoining = newDateOfJoining;
    }
    public ArrayList<String> getTechnologies(){
        return(technologies);
    }
    public void setTechnologies(ArrayList<String> newTechnologies){
        technologies = newTechnologies;
    }
    public Employee getManager(){
        return(manager);
    }
    public void setManager(Employee newManager){
        manager = newManager;
    }
    public ArrayList<Employee> getReportees(){
        return(reportees);
    }
    public void setReportees(ArrayList<Employee> newReportees){
        reportees = newReportees;
    }

    public String printEmployee(){
        String stringEmployee = "{";
        stringEmployee = stringEmployee.concat("ID: ");
        stringEmployee = stringEmployee.concat(String.valueOf(ID));
        stringEmployee = stringEmployee.concat(",Name: ");
        stringEmployee = stringEmployee.concat(name);
        stringEmployee = stringEmployee.concat(",Address: ");
        stringEmployee = stringEmployee.concat(address.printAddress());
        stringEmployee = stringEmployee.concat(",Contact Information: ");
        stringEmployee = stringEmployee.concat(contactInformation.printContactInformation());
        stringEmployee = stringEmployee.concat(",Department: ");
        stringEmployee = stringEmployee.concat(department.printDepartment());
        stringEmployee = stringEmployee.concat(",Salary: ");
        stringEmployee = stringEmployee.concat(String.valueOf(salary));
        stringEmployee = stringEmployee.concat(",Designation: ");
        stringEmployee = stringEmployee.concat(designation);
        stringEmployee = stringEmployee.concat(",Date of Joining: ");
        stringEmployee = stringEmployee.concat(String.valueOf(dateOfJoining));
        stringEmployee = stringEmployee.concat(",technologies: ");
        stringEmployee = stringEmployee.concat("{");
        stringEmployee = stringEmployee.concat(String.join(",",technologies));
        stringEmployee = stringEmployee.concat("}");
        stringEmployee = stringEmployee.concat(",Manager: ");
        if(manager != null) {
            stringEmployee = stringEmployee.concat(String.valueOf(manager.getID()));
        }
        else{
            stringEmployee = stringEmployee.concat("no manager");
        }
        stringEmployee = stringEmployee.concat(",Reportees: ");
        for(Employee itr : reportees){
            stringEmployee = stringEmployee.concat(String.valueOf(itr.getID())+" ");
        }
        stringEmployee = stringEmployee.concat("}");

        return(stringEmployee);
    }
    public void addReportee(Employee newEmployee){
        reportees.add(newEmployee);
    }
}
