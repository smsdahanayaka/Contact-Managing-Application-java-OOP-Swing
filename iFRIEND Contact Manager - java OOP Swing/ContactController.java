import java.time.LocalDate;
import java.util.*;
public class ContactController{
	public static boolean addContact(ContactDetails contactDetails){
		
		ContactList contactList=DBConnection.getInstance().getCustomerList();
		contactList.add(contactDetails);
		return true;
	}
	public static boolean addContact(int i,ContactDetails contactDetails){
		
		ContactList contactList=DBConnection.getInstance().getCustomerList();contactList.set(i,contactDetails);
		contactList.remove(i+1);
		return true;
	}
	public static ContactDetails[] getAllContacts(){
		ContactList contactList=DBConnection.getInstance().getCustomerList();
		ContactDetails[] tempContactArray=new ContactDetails[contactList.size()];
		for (int i = 0; i < contactList.size(); i++){
			tempContactArray[i]=contactList.get(i);
		}
		return tempContactArray;
	}
	
	public static String genId(){
		ContactList contactList=DBConnection.getInstance().getCustomerList();
		int leng=contactList.size();
		String id=String.format("C%04d",leng);
		
		for(int i=0;i<leng;i++){
			if(id.equals(contactList.get(i).getContactId())){
				id=String.format("C%04d",leng+1);
			}
		}
		return id;
		} 
		
	public static boolean checkContact(String number1){
		String  number=number1;
		ContactList contactList=DBConnection.getInstance().getCustomerList();
		for(int j=0;j<contactList.size();j++){
			if(number1.equals(contactList.get(j).getContactNumber())){
				return false;
				}else{
				number=number1;
					}
			}
		
		char ch=number.charAt(0);
		if(ch!='0'){
	
			return false;
		}else{
			int x=number.length();
			if(x!=10){
				
				return false;
			}else{
				for(int i=0;i<x;i++){
					if(!Character.isDigit(number.charAt(i))){
							
							return false;
							}
						}
					}
			}
			return true;
		}
		
	public static boolean verifyBday(String bday){
		
		int yearInt=Integer.parseInt(bday.substring(0,4));
		int monthInt=Integer.parseInt(bday.substring(5,7));
		int dateInt=Integer.parseInt(bday.substring(8,10));
		
		
		LocalDate today=LocalDate.now();
		int curentYear=2023;//today.getYear();
		int curentMonth=12;//today.getMonthValue();
		int curentDay=30;//today.getDayOfMonth();
		
		
		if(yearInt<=curentYear){
			if(monthInt>0 && monthInt<=curentMonth){
				if(dateInt>0 && dateInt<=curentDay){
					return true;
					}
					return false;
				}
				return false;
			}
		return false;
		}
	
	public static boolean checkSal(double sall){
					
					if(sall>0){
						return true; 
						}else{
							return false;
							}	
					
			
			}

	
	public static int serchByNameOrContact(String searchConName){
		
		ContactList contactList=DBConnection.getInstance().getCustomerList();
		for(int i=0;i<contactList.size();i++){
			if(searchConName.equalsIgnoreCase(contactList.get(i).getContactName())||searchConName.equalsIgnoreCase(contactList.get(i).getContactNumber())){
				return i;
				
				}
			}
			return -1;
		} 	

	public static ContactDetails getById(int index){
		ContactList contactList=DBConnection.getInstance().getCustomerList();
		return contactList.get(index);
		}
		
	public static boolean deletContact(int index){
		
		ContactList contactList=DBConnection.getInstance().getCustomerList();
		contactList.remove(index);
		return true;
		} 
		
	public static ContactDetails[] listByName(){
		ContactList contactList=DBConnection.getInstance().getCustomerList();
		ContactDetails[] allContact=getAllContacts();
		
		for(int j=contactList.size()-1;j>0;j--){
			for(int i=0;i<j;i++){
				String st1=allContact[i].getContactName();
				String st2=allContact[i+1].getContactName();
				
				
				for(int k=0;k<1;k++){
					
					int a=st1.charAt(0);
					int b=st2.charAt(0);   

					if(a>b){
						
						ContactDetails tempArr3;
						
						tempArr3=allContact[i];
						allContact[i]=allContact[i+1];
						allContact[i+1]=tempArr3;
					}else if(a==b){
						
						ContactDetails tempArr4;;
						
						tempArr4=allContact[i];
						allContact[i]=allContact[i+1];
						allContact[i+1]=tempArr4;
					}
						
				}
			
			
					
					
				}
				
				
				}
			return allContact;	
			}


	public static ContactDetails[] listBySalary(){
		ContactList contactList=DBConnection.getInstance().getCustomerList();
		ContactDetails[] allContact=getAllContacts();
		
		for(int j=contactList.size()-1;j>0;j--){
			for(int i=0;i<j;i++){
				
				if(allContact[i].getSalary()>allContact[i+1].getSalary()){
					
						ContactDetails tempArr3;
						
						tempArr3=allContact[i];
						allContact[i]=allContact[i+1];
						allContact[i+1]=tempArr3;
					
					}
				}
			}
			return allContact;
		}
		
	public static ContactDetails[] listByBirthDay(){
		ContactList contactList=DBConnection.getInstance().getCustomerList();
		ContactDetails[] allContact=getAllContacts();
		int i=0;
		ContactDetails[] tempYear=new ContactDetails[contactList.size()];
		for(int j=contactList.size()-1;j>0;j--){
			for(int k=0;k<j;k++){
				String st1=allContact[k].getBirthDay();
				String st2=allContact[k+1].getBirthDay();
				
				
				int yearInt1=Integer.parseInt(st1.substring(0,4));
				int monthInt1=Integer.parseInt(st1.substring(5,7));
				int dateIn1=Integer.parseInt(st1.substring(8,10));
				
				int yearInt2=Integer.parseInt(st2.substring(0,4));
				int monthInt2=Integer.parseInt(st2.substring(5,7));
				int dateIn2=Integer.parseInt(st2.substring(8,10));
				
							if(yearInt1>yearInt2){
								ContactDetails tempArr3;
								tempArr3=allContact[i];
								allContact[i]=allContact[i+1];
								allContact[i+1]=tempArr3; 
								
										
							}else if(yearInt1==yearInt2){
								if(monthInt1>monthInt2){
									ContactDetails tempArr2;
									tempArr2=allContact[i];
									allContact[i]=allContact[i+1];
									allContact[i+1]=tempArr2; 
									
									}else if(monthInt1==monthInt2){
										if(dateIn1>dateIn2){
											ContactDetails tempArr1;
											tempArr1=allContact[i];
											allContact[i]=allContact[i+1];
											allContact[i+1]=tempArr1; 
											
											}
										}
								}
								
							}
					}
					return allContact;
		
		}
		
		
}
	
