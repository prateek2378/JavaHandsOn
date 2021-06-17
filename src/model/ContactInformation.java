package model;

public class ContactInformation {
    private int contactInformationID;
    private long phoneNo;
    private String emailID;

    public ContactInformation(int newContactInformationID, long newPhoneNo, String newEmailID){
        contactInformationID = newContactInformationID;
        phoneNo = newPhoneNo;
        emailID = newEmailID;
    }

    public int getContactInformationID(){
        return(contactInformationID);
    }
    public void setContactInformationID(int newContactInformationID){
        contactInformationID = newContactInformationID;
    }
    public long getPhoneNo(){
        return(phoneNo);
    }
    public void setPhoneNo(long newPhoneNo){
        phoneNo = newPhoneNo;
    }
    public String getEmailID(){
        return(emailID);
    }
    public void setEmailID(String newEmailID){
        emailID = newEmailID;
    }

    public String printContactInformation(){
        String stringContactInformation = "{";
        stringContactInformation = stringContactInformation.concat("Contact Information ID: ");
        stringContactInformation = stringContactInformation.concat(String.valueOf(contactInformationID));
        stringContactInformation = stringContactInformation.concat(",Phone Number: ");
        stringContactInformation = stringContactInformation.concat(String.valueOf(phoneNo));
        stringContactInformation = stringContactInformation.concat(",Email ID: ");
        stringContactInformation = stringContactInformation.concat(emailID);
        stringContactInformation = stringContactInformation.concat("}");

        return(stringContactInformation);
    }
}
