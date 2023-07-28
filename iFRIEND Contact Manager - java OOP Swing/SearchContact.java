import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SearchContact extends JFrame{

	private JButton btnBackToHome;
	private JButton btnSearch;
	
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
	private JTextField tfSearch;
	
	private MainView mainView;
		
	SearchContact(){
		setSize(1200,800);
		setTitle("Search Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JPanel topPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		topPanel.setBackground(Color.cyan);
		lblTitle=new JLabel("Search Contact");
		lblTitle.setFont(new Font("",1,30));
		topPanel.add(lblTitle);
		
		JPanel centerPanel = new JPanel(new GridLayout(6, 2,10,10));
		centerPanel.setBorder(BorderFactory.createEmptyBorder(1, 100, 0, 10));

			JPanel p11=new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel p12=new JPanel(new FlowLayout(FlowLayout.LEFT));
			tfSearch = new JTextField();
			tfSearch.setPreferredSize(new Dimension(400, 40));
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					String contactId=tfSearch.getText();
					int i=ContactController.serchByNameOrContact(contactId);
					if(i>=0){
						ContactDetails contactDetails=ContactController.getById(i);
						
						tfName.setText(contactDetails.getContactName());
						tfNumber.setText(contactDetails.getContactNumber());
						tfCompany.setText(contactDetails.getCompanyName());
						
						tfSalary.setText(contactDetails.getSalary()+"");
						tfBirthDay.setText(contactDetails.getBirthDay());
						
						
						}else{
							JOptionPane.showMessageDialog(null,"Invalid Contact number or name.. please enter valid Contact number or name");
							
							}
				}
			});
			btnSearch.setFont(new Font("",1,15));
			btnSearch.setPreferredSize(new Dimension(200, 40));
			p11.add(tfSearch);
			p12.add(btnSearch);
			centerPanel.add(p11);
			centerPanel.add(p12);


			JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
			lblName = new JLabel("Name");
			lblName.setFont(new Font("", Font.BOLD, 20));
			tfName=new JTextField();
			tfName.setPreferredSize(new Dimension(400, 40));
			tfName.setEditable(false);
			p1.add(lblName);
			p2.add(tfName);
			centerPanel.add(p1);
			centerPanel.add(p2);

			JPanel p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
			JPanel p4=new JPanel(new FlowLayout(FlowLayout.LEFT));
			lblNumber = new JLabel("Contact Number");
			lblNumber.setFont(new Font("", Font.BOLD, 20));
			tfNumber=new JTextField();
			tfNumber.setEditable(false);
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
			tfCompany.setEditable(false);
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
			tfSalary.setEditable(false);
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
			tfBirthDay.setEditable(false);
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
				closeSearchContact() ;
				if(mainView==null){
					mainView=new MainView();
					mainView.setVisible(true);
					}	
			}
			});
		btnPanel.add(btnBackToHome);
		
		
		botPanel.add(temp);
		botPanel.add(botPanelInner);
		botPanelInner.add(botPanelInnerIn);
		botPanelInner.add(btnPanel);
		
		
		add("South",botPanel);
		add("North",topPanel);
		add("Center",centerPanel);
		pack();
		}
			
	private void closeSearchContact() {
			dispose(); 
		}	
	
	}

