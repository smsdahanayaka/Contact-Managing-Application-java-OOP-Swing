
import java.time.LocalDate;
import java.util.*;

//controler.........


public class ContactList{
	private Node first;
	
	public void add(ContactDetails contactDetails){
		Node tempNode=new Node(contactDetails);
		
		if(first==null){
			first=tempNode;
			}else{
				Node lastNode=first;
				while(lastNode.next!=null){
					lastNode=lastNode.next;
					}
					lastNode.next=tempNode;
				
				}
		
		}
	
	public int size(){
		Node lastNode=first;
		int count=0;
		
		while(lastNode!=null){
			lastNode=lastNode.next;
			count++;
			}
		
		return count;
		}
		
	private boolean isValidIndex(int index){
		if(index>=0 || index<size()){
			return true;
			}else{
				return false;
				}
			
		}
	public void add(int index ,ContactDetails contactDetails){
		Node tempNode=new Node(contactDetails);
		if(index>=0 && index<size()){
			if(index==0){
			tempNode.next=first;
			first=tempNode;
			
			}else{
				Node lastNode=first;
				for(int i=0;index-1>i;i++){
					lastNode=lastNode.next;
					}
				tempNode.next=lastNode.next;
				lastNode.next=tempNode;
				}
			
			}
		
			
		
		}
		
	public void remove(int index){
		if(index>=0 && index<size()){
			if(index==0){
			first=first.next;
			
			}else{
				Node lastNode=first;
				for(int i=0;index-1>i;i++){
					lastNode=lastNode.next;
					}
				lastNode.next=lastNode.next.next;
				
				}
			}
		
		}
		
	public void remove(ContactDetails contactDetails){
		remove(indexOf(contactDetails));
	}
	public void remove(int startIndex, int endIndex){
		
	}
	
	public int indexOf(ContactDetails contactDetails){
		Node temp=first;
		int index=-1;
		while(temp!=null){
			index++;
			if(temp.contactDetails.equals(contactDetails)){
				return index;
			}
			temp=temp.next;
		}
		return -1;
	}
	public boolean contains(ContactDetails contactDetails){
		return indexOf(contactDetails)!=-1;
	}

	public void printList(){
		System.out.println(toString());
	}
	
	public void clear(){
		first=null;
	}

	public ContactDetails get(int index){
				Node last=first;
				int count=0;
		
		for(int i=0;last!=null && index>count;i++){
			last=last.next;
			count++;
		}
		return last.contactDetails;
				
		}
	
	public void set(int index , ContactDetails contactDetails){
		Node tempNode=new Node(contactDetails);
		if(index>=0 && index<size()){
			if(index==0){
			tempNode.next=first;
			first=tempNode;
			
			}else{
				Node lastNode=first;
				for(int i=0;index-1>i;i++){
					lastNode=lastNode.next;
					}
				tempNode.next=lastNode.next;
				lastNode.next=tempNode;
				}
			 
			}
		}
		
	class Node{
		private Node next;
		
		private ContactDetails contactDetails;
		
		Node(ContactDetails contactDetails){
			this.contactDetails=contactDetails;
			
			}
		
		}
	}
