package model;

public class Department {
    private int departmentID;
    private String departmentName;

    public Department(int newDepartmentID, String newDepartmentName){
        departmentID = newDepartmentID;
        departmentName = newDepartmentName;
    }

    public int getDepartmentID(){
        return(departmentID);
    }
    public void setDepartmentID(int newDepartmentID){
        departmentID = newDepartmentID;
    }
    public String getDepartmentName(){
        return(departmentName);
    }
    public void setDepartmentName(String newDepartmentName){
        departmentName = newDepartmentName;
    }

    public String printDepartment(){
        String stringDepartment = "{";
        stringDepartment = stringDepartment.concat("Department ID: ");
        stringDepartment = stringDepartment.concat(String.valueOf(departmentID));
        stringDepartment = stringDepartment.concat(",Department Name: ");
        stringDepartment = stringDepartment.concat(departmentName);
        stringDepartment = stringDepartment.concat("}");

        return(stringDepartment);
    }
}
