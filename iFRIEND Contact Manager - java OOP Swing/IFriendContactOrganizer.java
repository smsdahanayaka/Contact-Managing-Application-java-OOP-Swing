import java.time.LocalDate;
import java.util.*;

class IFriendContactOrganizer{
	ContactList contactList=new ContactList();
//listing by birthday.....
	public void listingByBirthday(){
		Scanner input=new Scanner(System.in);
	
		clearConsole();
		System.out.println("=================================================");
		System.out.println("+                                               +");
		System.out.println("|                List by Birth Day              |");
		System.out.println("+                                               +");
		System.out.println("=================================================\n");
		
		int i=0;
		ContactDetails[] tempYear=new ContactDetails[contactList.size()];
		for(int j=contactList.size()-1;j>0;j--){
			for(int k=0;k<j;k++){
				String st1=contactList.get(k).getBirthDay();
				String st2=contactList.get(k+1).getBirthDay();
				
				
				int yearInt1=Integer.parseInt(st1.substring(0,4));
				int monthInt1=Integer.parseInt(st1.substring(5,7));
				int dateIn1=Integer.parseInt(st1.substring(8,10));
				
				int yearInt2=Integer.parseInt(st2.substring(0,4));
				int monthInt2=Integer.parseInt(st2.substring(5,7));
				int dateIn2=Integer.parseInt(st2.substring(8,10));
				
							if(yearInt1>yearInt2){
								ContactDetails tempArr1=new ContactDetails();
								tempArr1=contactList.get(i+1);
								contactList.remove(i+1);
								contactList.add(i,tempArr1); 
								
										
							}else if(yearInt1==yearInt2){
								if(monthInt1>monthInt2){
									ContactDetails tempArr1=new ContactDetails();
									tempArr1=contactList.get(i+1);
									contactList.remove(i+1);
									contactList.add(i,tempArr1);
									
									}else if(monthInt1==monthInt2){
										if(dateIn1>dateIn2){
											ContactDetails tempArr1=new ContactDetails();
											tempArr1=contactList.get(i+1);
											contactList.remove(i+1);
											contactList.add(i,tempArr1);
											
											}
										}
								}
								
							}
					}
				
				printArrays();
		}
							
	
//listing by name....
	public void listingByName(){
		Scanner input=new Scanner(System.in);
	
		clearConsole();
		System.out.println("=================================================");
		System.out.println("+                                               +");
		System.out.println("|                List by Name                   |");
		System.out.println("+    (display with simple capital arrangment)   +");
		System.out.println("=================================================\n");
		
		for(int j=contactList.size()-1;j>0;j--){
			for(int i=0;i<j;i++){
				String st1=contactList.get(i).getContactName();
				String st2=contactList.get(i+1).getContactName();
				
				int length1=st1.length();
				int length2=st2.length();
				
				int min=0;
				if(length2>length1){
					min=length1;
				}else{
					min=length2;
				}
				
				for(int k=0;k<1;k++){
					
					int a=st1.charAt(0);
					int b=st2.charAt(0);   

					if(a>b){
						
						ContactDetails tempArr3=new ContactDetails();
						
						tempArr3=contactList.get(i+1);
						contactList.remove(i+1);
						contactList.add(i,tempArr3);
					
						break;
					}else if(a==b){
						
						int a1=st1.charAt(1);
						int b1=st2.charAt(1);
						if(a1>b1){
						ContactDetails tempArr4=new ContactDetails();
						tempArr4=contactList.get(i+1);
						contactList.remove(i+1);
						contactList.add(i,tempArr4);
						
						break;
					}
						
					}
					

					
					
					}
				
				
				}
				
			}
			printArrays();
		
		}
		
//listing by salary....
	public void listingBySalary(){
		Scanner input=new Scanner(System.in);
		
		clearConsole();
		System.out.println("=================================================");
		System.out.println("+                                               +");
		System.out.println("|                List by Salary                 |");
		System.out.println("+                                               +");
		System.out.println("=================================================\n");
		
		for(int j=contactList.size()-1;j>0;j--){
			for(int i=0;i<j;i++){
				ContactDetails tempArr5=new ContactDetails();
				ContactDetails tempArr6=new ContactDetails();
				if(contactList.get(i+1).getSalary()>contactList.get(i).getSalary()){
					
					tempArr5=contactList.get(i+1);
					contactList.remove(i+1);
					contactList.add(i,tempArr5);
					
					
					}
				}
			}
			printArrays();
		
		}
		


//list contact......
	public void listContact(){
		Scanner input=new Scanner(System.in);
	l1:do{
		clearConsole();
		System.out.println("=================================================");
		System.out.println("+                                               +");
		System.out.println("|                List   Contact                 |");
		System.out.println("+                                               +");
		System.out.println("=================================================\n");
		
		System.out.println("[01] Sorting by name \n[02] Sorting by Salary \n[03] Sorting by Birth day \n[04] Main menu");
		
		
		System.out.print("\nEnter an option to continue = ");
		int option=input.nextInt();
		if(option>0 && option<5){
			switch(option){
				case 1:clearConsole();listingByName();break;
				case 2:clearConsole();listingBySalary();break;
				case 3:clearConsole();listingByBirthday();break;
				case 4:clearConsole();mainPage();break;
				
				}
			}else{
				System.out.print("Invalid input. Do you want input again (Y/N) - ");
				String inputChar=input.next();
				
				if(inputChar.equalsIgnoreCase("y")){
					
					continue l1;
				}if(inputChar.equalsIgnoreCase("n")){
					exit();
				}else{
					exit();
					}
				}
				return;
			}while(true);
		}
		
		
//search contact.......
	public void searchContact(){
		Scanner input=new Scanner(System.in);
		l1:do{
		clearConsole();
		System.out.println("=================================================");
		System.out.println("+                                               +");
		System.out.println("|                Search Contact                 |");
		System.out.println("+                                               +");
		System.out.println("=================================================\n");
	
		System.out.print("Search Contact By Name or Phone number :");
		String searchConName=input.next();
		
		int i=serchByNameOrContact(searchConName);
		
		if(i!=-1){
						printSucc(i);
						System.out.print("Do you want search anothr contact again (Y/N) - ");
						String inputChar=input.next();
				
							if(inputChar.equalsIgnoreCase("y")){
								clearConsole();
								continue l1;
							}if(inputChar.equalsIgnoreCase("n")){
								clearConsole();
								mainPage();
							}else{
								exit();
					
						}
			}else{
				
						System.out.println("No contact fund for "+searchConName+"....");
						System.out.print("Do you want input again (Y/N) - ");
						String inputChar=input.next();
				
							if(inputChar.equalsIgnoreCase("y")){
								clearConsole();
								continue l1;
							}if(inputChar.equalsIgnoreCase("n")){
								clearConsole();
								mainPage();
							}else{
								exit();
							}	
				
				
				}
				
			return;	
		}while(true);
	}
// search..

	public int serchByNameOrContact(String searchConName){
		
		for(int i=0;i<contactList.size();i++){
			if(searchConName.equalsIgnoreCase(contactList.get(i).getContactName())||searchConName.equalsIgnoreCase(contactList.get(i).getContactNumber())){
				return i;
				
				}
			}
			return -1;
		} 
	
//delete process...
	public void deletProcess(int index){
		
		if(contactList.size()>0){	
				contactList.remove(index);
			}
		
	}
		
//delet contact.......
	public void deletContact(){
		Scanner input=new Scanner(System.in);
		l1:do{
		System.out.println("=================================================");
		System.out.println("+                                               +");
		System.out.println("|                DELETE Contact                 |");
		System.out.println("+                                               +");
		System.out.println("=================================================\n");
	
		System.out.print("Search Contact By Name or Phone number to delet :");
		String searchConName=input.next();
		int i=serchByNameOrContact(searchConName);
		
		if(i!=-1){
				printSucc(i);
				
				System.out.print("Do you want Delet this contact (Y/N) - ");
				String inputCha=input.next();
				
				if(inputCha.equalsIgnoreCase("y")){
					clearConsole();
					deletProcess(i);
					System.out.println("Successfully deleted......");
							System.out.print("Do you want continue (Y/N) - ");
									String inputCha1=input.next();
				
									if(inputCha1.equalsIgnoreCase("y")){
									clearConsole(); 
									continue l1;
									}if(inputCha1.equalsIgnoreCase("n")){
										clearConsole();
										mainPage();
									}else{
										exit();
									}
				}else if(inputCha.equalsIgnoreCase("n")){
					clearConsole();
					mainPage();
					break;
				}else{
					exit();
				}
			}else{
				
						System.out.println("No contact fund for "+searchConName+"....");
						System.out.print("Do you want input again (Y/N) - ");
						String inputChar=input.next();
				
							if(inputChar.equalsIgnoreCase("y")){
								clearConsole();
								continue l1;
							}if(inputChar.equalsIgnoreCase("n")){
								clearConsole();
								mainPage();
							}else{
								exit();
							}	
				}
		
			return;
		}while(true);
		
	}
//Update contact.........
	public void updateContact(){
		Scanner input=new Scanner(System.in);
		l4:do{
		System.out.println("=================================================");
		System.out.println("+                                               +");
		System.out.println("|                UPDATE Contact                 |");
		System.out.println("+                                               +");
		System.out.println("=================================================\n");
	
		System.out.print("Search Contact By Name or Phone number :");
		String searchConName=input.next();
		
		int i=serchByNameOrContact(searchConName);
		
		if(i==-1){
					System.out.println("Can't find this contact....");
					System.out.print("Do you want input again (Y/N) - ");
									String inputChar=input.next();
				
									if(inputChar.equalsIgnoreCase("y")){
									continue l4;
									}if(inputChar.equalsIgnoreCase("n")){
										clearConsole();
										exit();
									}else{
										exit();
									}
			}else{
				l3:do{
				printSucc(i);
				
				System.out.println("\nWhat do you want to update.....");
				System.out.println("\n[01] Name \n[02]Phone Number \n[03]Company Name \n[04]Salary \n[05]Exit to home page");
				System.out.print("Enter your option to continue.....");
				int x=input.nextInt();
				clearConsole();
				switch(x){
					
					case 1:
							System.out.print("Please Enter your name = ");
							String name=input.next();
							contactList.get(i).setContactName(name);
							System.out.println("\nHas been successfully updated.....\n");
							System.out.print("Do you want continue (Y/N) - ");
									String inputCha=input.next();
				
									if(inputCha.equalsIgnoreCase("y")){
									continue l3;
									}if(inputCha.equalsIgnoreCase("n")){
										clearConsole();
										mainPage();
									}else{
										exit();
									}
						;break;
						
					case 2:
							l1:do{
								System.out.print("Please Enter your mobile number = ");
								String number=input.next();
			
								if(checkContact(number)){
								contactList.get(i).setContactNumber(number);
								System.out.println("\nHas been successfully updated.....\n");
									System.out.print("Do you want continue (Y/N) - ");
									String inputCha1=input.next();
				
									if(inputCha1.equalsIgnoreCase("y")){
									continue l3;
									}if(inputCha1.equalsIgnoreCase("n")){
										clearConsole();
										mainPage();
									}else{
										exit();
									}
								}else{
									System.out.print("Invalid Mobile number. Do you want input again (Y/N) - ");
									String inputChar=input.next();
				
									if(inputChar.equalsIgnoreCase("y")){
									continue l1;
									}if(inputChar.equalsIgnoreCase("n")){
										clearConsole();
										exit();
									}else{
										exit();
									}
								}
							return;
						}while(true);
						
					
					case 3:
							System.out.print("Please Enter your company name = ");
							String comName=input.next();
							
							contactList.get(i).setCompanyName(comName);
							System.out.println("\nHas been successfully updated.....\n");
							System.out.print("Do you want continue (Y/N) - ");
									String inputCha1=input.next();
				
									if(inputCha1.equalsIgnoreCase("y")){
									continue l3;
									}if(inputCha1.equalsIgnoreCase("n")){
										clearConsole();
										mainPage();
									}else{
										exit();
									}
						break;
					case 4:
							double sal=checkSal();
							contactList.get(i).setSalary(sal);
							System.out.println("\nHas been successfully updated.....\n");
							System.out.print("Do you want continue (Y/N) - ");
									String inputCha2=input.next();
				
									if(inputCha2.equalsIgnoreCase("y")){
									continue l3;
									}if(inputCha2.equalsIgnoreCase("n")){
										clearConsole();
										mainPage();
									}else{
										exit();
									}
						break;
						
					case 5:mainPage();break;
					}
					return;
				}while(true);
				
				}
		
			printArrays();
			return;
		}while(true);
			
		}

//genarate contact Id..
	public String genId(){
		int leng=contactList.size();
		String id=String.format("C%04d",leng);
		
		for(int i=0;i<leng;i++){
			if(id.equals(contactList.get(i).getContactId())){
				id=String.format("C%04d",leng+1);
			}
		}
		return id;
		} 

//check mobile number...
	public boolean checkContact(String number1){
		String  number=number1;
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


//check salary....
	public double checkSal(){
		Scanner input=new Scanner(System.in);
		l1:do{
				System.out.print("Please Enter your Salary = ");
				double sal1=input.nextDouble();
				if(sal1>0){
					return sal1; 
					}else{
						System.out.print("Invalid salary. Do you want input again (Y/N) - ");
						String inputChar=input.next();
				
						if(inputChar.equalsIgnoreCase("y")){
							continue l1;
						}if(inputChar.equalsIgnoreCase("n")){
							exit();
						}else{
							exit();
							}
						
						}
				
			}while(true);	
				
		
		}

//print succrssfully add...
	public void printSucc(int index){
		
		System.out.println("\n"+contactList.get(index).getContactId()+"\n========\n");
		System.out.println("Name\t\t:"+contactList.get(index).getContactName());
		System.out.println("Contact number\t:"+contactList.get(index).getContactNumber());
		System.out.println("Birth day\t:"+contactList.get(index).getBirthDay());
		System.out.println("Company name\t:"+contactList.get(index).getCompanyName());
		System.out.println("Salary\t\t:"+contactList.get(index).getSalary());
	}

//verify b ady.....
	public boolean verifyBday(String bday){
		
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
				}
			}
		return false;
		}
	

//add contact..........
	public void addContact(){
		clearConsole();
		Scanner input=new Scanner(System.in);
	l3:do{
		System.out.println("=================================================");
		System.out.println("+                                               +");
		System.out.println("|                 Add Contact                   |");
		System.out.println("+                                               +");
		System.out.println("=================================================\n");
		
		System.out.print("Please Enter your name = ");
		String name=input.next();
	l1:do{
			System.out.print("Please Enter your mobile number = ");
			String number=input.next();
			
			if(checkContact(number)){
				
				double sal=checkSal();
				
			l4:do{
				System.out.print("Please Enter your birth year (YYYY-MM-DD) = ");
				String bday=input.next();
				
				if(verifyBday(bday)){
					System.out.print("Please Enter your company name = ");
					String comName=input.next();
			
							ContactDetails contactDetails=new ContactDetails();
							contactDetails.setContactId(genId());
							contactDetails.setContactName(name);
							contactDetails.setCompanyName(comName);
							contactDetails.setContactBirthDay(bday);
							contactDetails.setContactNumber(number);
							contactDetails.setSalary(sal);
							
							contactList.add(contactDetails);
							clearConsole();
							
							printSucc(contactList.size()-1);
							System.out.println("\n          Contact has been added successfully....");
							
								System.out.print("Do you want Add another contact (Y/N) - ");
								String inputChar=input.next();
				
								if(inputChar.equalsIgnoreCase("y")){
									clearConsole();
									continue l3;
								}if(inputChar.equalsIgnoreCase("n")){
									clearConsole();
									mainPage();
								}else{
									exit();
								}
								
					}else{
					System.out.print("Invalid bDay input.....");
					System.out.print("Do you want Add another Bday (Y/N) - ");
								String inputChar=input.next();
				
								if(inputChar.equalsIgnoreCase("y")){
									clearConsole();
									continue l4;
								}if(inputChar.equalsIgnoreCase("n")){
									clearConsole();
									mainPage();
								}else{
									exit();
								}
						}
						return;
					}while(true);
				}else{
				System.out.print("Invalid Mobile number. Do you want input again (Y/N) - ");
				String inputChar=input.next();
				
				if(inputChar.equalsIgnoreCase("y")){
					continue l1;
				}if(inputChar.equalsIgnoreCase("n")){
					exit();
				}else{
					exit();
					}
				}
				return;
				}while(true);
			
			}while(true);
		
			
		}

//print arrays..
	public void printArrays(){
		Scanner input=new Scanner(System.in);
			System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|\n");
			System.out.println(" Contact Id\t| Contact name\t\t| Contact number\t| Company name\t\t| Birth Day\t\t| Salary\t\t \n");
			System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|\n");
			
			
				for(int i=0;i<contactList.size();i++){
					System.out.printf(" %5S \t\t|%15S \t|%15S \t|%15S \t|%15S \t|"+contactList.get(i).getSalary()+"  \t ",contactList.get(i).getContactId(),contactList.get(i).getContactName(),contactList.get(i).getContactNumber(),contactList.get(i).getCompanyName(),contactList.get(i).getBirthDay());
					
					System.out.println("\n");
					System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|");
					}
					
				System.out.print("Do you want to go main page (Y/N)....");
				String inputChar=input.next();
				
				if(inputChar.equalsIgnoreCase("y")){
					clearConsole();
					mainPage();
					return;
				}if(inputChar.equalsIgnoreCase("n")){
					exit();
					return;
				}else{
					exit();
				}
		
	}

//exit page.....
	public void exit(){
		clearConsole();
		System.out.println("=================================================");
		System.out.println("+                                               +");
		System.out.println("|                 Thank you                     |");
		System.out.println("+                                               +");
		System.out.println("=================================================\n");
		return;
		}

//clear console....
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
			} catch (final Exception e) {
				e.printStackTrace();
		// Handle any exceptions.
	}
}

//main page......
	public void mainPage(){
		Scanner input=new Scanner(System.in);
		
		System.out.println("=================================================");
		System.out.println("+                                               +");
		System.out.println("|                   iFriend                     |");
		System.out.println("|               Contact Organize                |");
		System.out.println("+                                               +");
		System.out.println("+                             (S.M.S Dahanayaka)+");
		System.out.println("=================================================\n");
		
		System.out.println("[01] ADD Contacts \n[02] UPDATE Contacts \n[03] DELETE Contacts \n[04] SEARCH Contacts \n[05] LIST Contacts \n[06] View contact list \n[07] EXIT\n\n");
		
	l1:do{
		
		System.out.print("Enter an option to continue = ");
		int option=input.nextInt();
		if(option>0 && option<8){
			switch(option){
				case 1:clearConsole();addContact();break;
				case 2:clearConsole();updateContact();break;
				case 3:clearConsole();deletContact();break;
				case 4:clearConsole();searchContact();break;
				case 5:clearConsole();listContact();break;
				case 6:clearConsole();printArrays();break;
				case 7:clearConsole();exit();break;
				}
			}else{
				System.out.print("Invalid input. Do you want input again (Y/N) - ");
				String inputChar=input.next();
				
				if(inputChar.equalsIgnoreCase("y")){
					continue l1;
				}if(inputChar.equalsIgnoreCase("n")){
					exit();
				}else{
					exit();
					}
				}
				return;
			}while(true);
		}
		 
//main method........
	public static void main(String[] args){
		IFriendContactOrganizer iFriendContactOrganizer=new IFriendContactOrganizer();
		iFriendContactOrganizer.mainPage();
		
		}

}
