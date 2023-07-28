import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainView extends JFrame{
	private JLabel mainLable1;
	private JLabel mainLable2;
	private JLabel imgLbl;
	
	private JButton btnAddNewContact;
	private JButton btnUpdateContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact;
	private JButton btnViewCntact;
	private JButton btnExit;
	
	private AddNewContact addNewContact;
	private UpdateContact updateContact;
	private SearchContact searchContact;
	private DeleteContact deleteContact;
	private ViewContact viewContact;
	
	MainView(){
		setSize(1200,800);
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null);
		setLayout(new  GridLayout(1,2));
		
		JPanel p1=new JPanel();
		p1.setLayout(new BorderLayout());
		ImageIcon imgMain=new ImageIcon(getClass().getResource("imgMain.png"));
		imgLbl=new JLabel(imgMain);
		JPanel p1Sub=new JPanel(new GridLayout(2,1));
		mainLable1=new JLabel("   iFRIEND   ");
		mainLable1.setFont(new Font("",1,50));
		mainLable1.setHorizontalAlignment(JLabel.CENTER);
		mainLable2=new JLabel("Contact Manager...");
		mainLable2.setFont(new Font("",1,30));
		mainLable2.setHorizontalAlignment(JLabel.CENTER);
		p1Sub.add(mainLable1);
		p1Sub.add(mainLable2);
		p1.add("North",p1Sub);
		p1.add("Center",imgLbl);
		add("West",p1);
		
		JPanel p2=new JPanel(new BorderLayout());
		JPanel p2Sub1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel p2Sub2=new JPanel(new GridLayout(7,1));
		JPanel p2Sub3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2Sub2.setBackground(Color.cyan);
		
		JLabel p2Sub1Lable=new JLabel("Home Page");
		p2Sub1Lable.setFont(new Font("",1,30));
		p2Sub1.add(p2Sub1Lable);
		
		p2Sub2.add(new JLabel(""));
		JPanel btn1p2Sub2=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnAddNewContact=new JButton("Add New Contact");
		btnAddNewContact.setFont(new Font("",1,20));
		btnAddNewContact.setPreferredSize(new Dimension(250, 40));
		btn1p2Sub2.add(btnAddNewContact);
		btn1p2Sub2.setBackground(Color.cyan);
		btnAddNewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				closeMainView();
				if(addNewContact==null){
					addNewContact=new AddNewContact();
					addNewContact.setVisible(true);
					}	
			}
			});
		p2Sub2.add(btn1p2Sub2);
		
		
		JPanel btn2p2Sub2=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnUpdateContact=new JButton("Update Contact");
		btnUpdateContact.setPreferredSize(new Dimension(250, 40));
		btnUpdateContact.setFont(new Font("",1,20));
		btn2p2Sub2.add(btnUpdateContact);
		btn2p2Sub2.setBackground(Color.cyan);
		btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				closeMainView();
				if(updateContact==null){
					updateContact=new UpdateContact();
					updateContact.setVisible(true);
					}	
			}
			});
		p2Sub2.add(btn2p2Sub2);
		
		JPanel btn3p2Sub2=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnSearchContact=new JButton("Search Contact");
		btnSearchContact.setFont(new Font("",1,20));
		btnSearchContact.setPreferredSize(new Dimension(250, 40));
		btn3p2Sub2.setBackground(Color.cyan);
		btn3p2Sub2.add(btnSearchContact);
		btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				closeMainView();
				if(searchContact==null){
					searchContact=new SearchContact();
					searchContact.setVisible(true);
					}	
			}
			});
		p2Sub2.add(btn3p2Sub2);
		
		JPanel btn4p2Sub2=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnDeleteContact=new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("",1,20));
		btnDeleteContact.setPreferredSize(new Dimension(250, 40));
		btn4p2Sub2.setBackground(Color.cyan);
		btn4p2Sub2.add(btnDeleteContact);
		btnDeleteContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				closeMainView();
				if(deleteContact==null){
					deleteContact=new DeleteContact();
					deleteContact.setVisible(true);
					}	
			}
			});
		p2Sub2.add(btn4p2Sub2);
		
		JPanel btn5p2Sub2=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnViewCntact=new JButton("View Contact");
		btn5p2Sub2.setBackground(Color.cyan);
		btnViewCntact.setFont(new Font("",1,20));
		btnViewCntact.setPreferredSize(new Dimension(250, 40));
		btn5p2Sub2.add(btnViewCntact);
		btnViewCntact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				closeMainView();
				if(viewContact==null){
					viewContact=new ViewContact();
					viewContact.setVisible(true);
					}	
			}
			});
		p2Sub2.add(btn5p2Sub2);
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,15));
		btnExit.setPreferredSize(new Dimension(100, 30));
		btnExit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					System.exit(0);
					
					}
				});

		p2Sub3.add(btnExit);
		
		p2.add("North",p2Sub1);
		p2.add("Center",p2Sub2);
		p2.add("South",p2Sub3);
		add("East",p2);
		pack();
		
		
		}
		private void closeMainView() {
			dispose(); 
		}

	public static void main(String[] args){
		new MainView().setVisible(true);
		}
	
	}
