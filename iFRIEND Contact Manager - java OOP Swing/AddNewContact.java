import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class AddNewContact extends JFrame{
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnBackToHome;
	
	private JLabel lblName;
	private JLabel lblNumber;
	private JLabel lblCompany;
	private JLabel lblSalary;
	private JLabel lbBirthDay;
	private JLabel lblTitle;
	private JLabel lblContactId;
	
	private JTextField tfName;
	private JTextField tfNumber;
	private JTextField tfCompany;
	private JTextField tfSalary;
	private JTextField tfBirthDay;
	
	private MainView mainView;
	
	
	AddNewContact(){
		setSize(1200,800);
		setTitle("Add New Contact");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JPanel topPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		topPanel.setBackground(Color.cyan);
		lblTitle=new JLabel("ADD CONTACT");
		lblTitle.setFont(new Font("",1,30));
		topPanel.add(lblTitle);
		
		JPanel centerPanel = new JPanel(new GridLayout(6, 2,10,10));
		centerPanel.setBorder(BorderFactory.createEmptyBorder(1, 100, 0, 10));
			
			String contactId=ContactController.genId();
			lblContactId = new JLabel("Contact ID : "+contactId);
			lblContactId.setFont(new Font("", 1, 20));
			JLabel lblContactId2 = new JLabel("");
			lblContactId2.setFont(new Font("", 1, 20));
			centerPanel.add(lblContactId);
			centerPanel.add(lblContactId2);


			JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
			lblName = new JLabel("Name");
			lblName.setFont(new Font("", Font.BOLD, 20));
			tfName=new JTextField();
			tfName.setPreferredSize(new Dimension(400, 40));
			p1.add(lblName);
			p2.add(tfName);
			centerPanel.add(p1);
			centerPanel.add(p2);

			JPanel p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel p4=new JPanel(new FlowLayout(FlowLayout.LEFT));
			lblNumber = new JLabel("Contact Number");
			lblNumber.setFont(new Font("", Font.BOLD, 20));
			tfNumber=new JTextField();
			tfNumber.setPreferredSize(new Dimension(400, 40));
			p3.add(lblNumber);
			p4.add(tfNumber);
			centerPanel.add(p3); 
			centerPanel.add(p4);

			JPanel p5=new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel p6=new JPanel(new FlowLayout(FlowLayout.LEFT));
			lblCompany = new JLabel("Company");
			lblCompany.setFont(new Font("", Font.BOLD, 20));
			tfCompany=new JTextField();
			tfCompany.setPreferredSize(new Dimension(400, 40));
			p5.add(lblCompany);
			p6.add(tfCompany);
			centerPanel.add(p5); 
			centerPanel.add(p6);
			
			JPanel p7=new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel p8=new JPanel(new FlowLayout(FlowLayout.LEFT));
			lblSalary = new JLabel("Salary");
			lblSalary.setFont(new Font("", Font.BOLD, 20));
			tfSalary=new JTextField();
			tfSalary.setPreferredSize(new Dimension(400, 40));
			p7.add(lblSalary);
			p8.add(tfSalary);
			centerPanel.add(p7); 
			centerPanel.add(p8);

			JPanel p9=new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel p10=new JPanel(new FlowLayout(FlowLayout.LEFT));
			lbBirthDay = new JLabel("Birthday");
			lbBirthDay.setFont(new Font("", Font.BOLD, 20));
			tfBirthDay=new JTextField();
			tfBirthDay.setPreferredSize(new Dimension(400, 40));
			p9.add(lbBirthDay);
			p10.add(tfBirthDay);
			centerPanel.add(p9); 
			centerPanel.add(p10);

		JPanel botPanel=new JPanel(new GridLayout(1,2));
		JPanel botPanelInner=new JPanel(new GridLayout(2,1));
		botPanelInner.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 10));
		JPanel botPanelInnerIn=new JPanel(new GridLayout(1,2));
		JPanel temp=new JPanel();
		
		JPanel btnPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnBackToHome=new JButton("Back To Home");
		btnBackToHome.setFont(new Font("",1,15));
		btnBackToHome.setPreferredSize(new Dimension(400, 40));
		btnBackToHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				closeAddNewContact();
				if(mainView==null){
					mainView=new MainView();
					mainView.setVisible(true);
					}	
			}
			});
		btnPanel.add(btnBackToHome);
		
		JPanel btnPanelCancel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,15));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				tfName.setText("");
				tfNumber.setText("");
				tfCompany.setText("");
				tfSalary.setText("");
				tfBirthDay.setText("");
			}
			});
		btnCancel.setPreferredSize(new Dimension(190, 40));
		btnPanelCancel.add(btnCancel);
		
		JPanel btnPanelAdd=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnAdd=new JButton("Add Contact");
		btnAdd.setFont(new Font("",1,15));
		btnAdd.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					String contactName=tfName.getText();
					String companyName=tfCompany.getText();
					String contactNumber=tfNumber.getText();
					if(ContactController.checkContact(contactNumber)){
						String birthDay=tfBirthDay.getText();
						if(ContactController.verifyBday(birthDay)){
							double salary=Double.parseDouble (tfSalary.getText());
							if(ContactController.checkSal(salary)){
								
								ContactDetails contactDetails=new ContactDetails(contactId,contactName,contactNumber,companyName,birthDay,salary);
								boolean isAdd=ContactController.addContact(contactDetails);
								
								if(isAdd){
									JOptionPane.showMessageDialog(null,"Added Success");
									}
								
								}else{
									JOptionPane.showMessageDialog(null,"Invalid Salary.. please enter valid salary");
									}
							}else{
								JOptionPane.showMessageDialog(null,"Invalid Birth day.. please enter valid birth day");
								}
						
						}else{
							JOptionPane.showMessageDialog(null,"Invalid Contact number.. please enter valid number");
							
							}
					
					
					
					
					
					
					}
				});
		btnAdd.setPreferredSize(new Dimension(190, 40));
		btnPanelAdd.add(btnAdd);
		
		botPanel.add(temp);
		botPanel.add(botPanelInner);
		botPanelInner.add(botPanelInnerIn);
		botPanelInner.add(btnPanel);
		botPanelInnerIn.add(btnPanelAdd);
		botPanelInnerIn.add(btnPanelCancel);
		
		
		add("South",botPanel);
		add("North",topPanel);
		add("Center",centerPanel);
		pack();
		}
		
	private void closeAddNewContact() {
			dispose(); 
		}
		
	
	
	}

