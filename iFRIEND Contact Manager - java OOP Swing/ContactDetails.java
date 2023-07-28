import java.time.LocalDate;
import java.util.*;


public class ContactDetails{
	private String contactId;
	private String contactName;
	private String contactNumber;
	private String companyName;
	private String birthDay;
	private double salary;
	
	ContactDetails(String contactId,String contactName,String contactNumber,String companyName,String birthDay,double salary){
		this.contactId=contactId;
		this.contactName=contactName;
		this.contactNumber=contactNumber;
		this.companyName=companyName;
		this.birthDay=birthDay;
		this.salary=salary;
		}
		
	public void setContactId(String contactId){
		this.contactId=contactId;
		}
		
	public void setContactName(String contactName){
		this.contactName=contactName;
		}
		
	public void setContactNumber(String contactNumber){
		this.contactNumber=contactNumber;
		}
		
	public void setCompanyName(String companyName){
		this.companyName=companyName;
		}
	public void setContactBirthDay(String birthDay){
		this.birthDay=birthDay;
		}
		
	public void setSalary(double salary){
		this.salary=salary;
		}

	public String getContactId(){
		return contactId;
		}
		
	public String getContactName(){
		return contactName;
		}
		
	public String getContactNumber(){
		return contactNumber;
		}
		
	public String getCompanyName(){
		return companyName;
		}
	public String getBirthDay(){
		return birthDay;
		}
	
	public double getSalary(){
		return salary;
		}
	
	}
