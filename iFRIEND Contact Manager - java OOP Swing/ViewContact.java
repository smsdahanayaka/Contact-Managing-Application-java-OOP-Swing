import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewContact extends JFrame{
	private JLabel mainLable1;
	
	private JButton btnListByName;
	private JButton btnListBySalary;
	private JButton btnListByBirthDay;
	private JButton btnBackToHome;
	private JButton btnCancel;

	private ListByName listByName;
	private MainView mainView;
	private ListBySalary listBySalary;
	private ListByBirthDay listByBirthDay;
	
	ViewContact(){
		setSize(1200,800);
		setTitle("View Contacts");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLocationRelativeTo(null);
		
		JPanel topPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		mainLable1=new JLabel("Contact List");
		topPanel.setBackground(Color.cyan);
		mainLable1.setFont(new Font("",Font.BOLD,30));
		topPanel.add(mainLable1);
		
		
		JPanel centerPanel=new JPanel(new GridLayout(3,1));
		centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 10));
		
		JPanel centerPanelName=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnListByName=new JButton("List By Name");
		btnListByName.setFont(new Font("",1,25));
		btnListByName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				closeViewContact();
				if(listByName==null){
					listByName=new ListByName();
					listByName.setVisible(true);
					}	
			}
			});
		btnListByName.setPreferredSize(new Dimension(500, 50));
		centerPanelName.add(btnListByName);
		
		JPanel centerPanelSalary=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnListBySalary=new JButton("List By Salary");
		btnListBySalary.setFont(new Font("",1,25));
		btnListBySalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				closeViewContact();
				if(listBySalary==null){
					listBySalary=new ListBySalary();
					listBySalary.setVisible(true);
					}	
			}
			});
		btnListBySalary.setPreferredSize(new Dimension(500, 50));
		centerPanelSalary.add(btnListBySalary);
		
		JPanel centerPanelBirth=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnListByBirthDay=new JButton("List By Birth Day");
		btnListByBirthDay.setFont(new Font("",1,25));
		btnListByBirthDay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				closeViewContact();
				if(listByBirthDay==null){
					listByBirthDay=new ListByBirthDay();
					listByBirthDay.setVisible(true);
					}	
			}
			});
		btnListByBirthDay.setPreferredSize(new Dimension(500, 50));
		centerPanelBirth.add(btnListByBirthDay);
		
		centerPanel.add(centerPanelName);
		centerPanel.add(centerPanelSalary);
		centerPanel.add(centerPanelBirth);
		
		JPanel botPanel=new JPanel(new GridLayout(1,2));
		JPanel botPanelInner=new JPanel(new GridLayout(2,1));
		botPanelInner.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 10));
		JPanel botPanelInnerIn=new JPanel(new GridLayout(1,2));
		JPanel temp=new JPanel();
		
		JPanel btnPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnBackToHome=new JButton("Back To Home");
		btnBackToHome.setFont(new Font("",1,15));
		btnBackToHome.setPreferredSize(new Dimension(200, 30));
		btnBackToHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				closeViewContact();
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
		btnCancel.setPreferredSize(new Dimension(200, 30));
		btnPanelCancel.add(btnCancel);
		
		botPanel.add(temp);
		botPanel.add(botPanelInner);
		botPanelInner.add(botPanelInnerIn);
		botPanelInner.add(btnPanel);
		botPanelInnerIn.add(btnPanelCancel);
		
	
		add("South",botPanel);
		add("Center",centerPanel);
		add("North", topPanel);
		pack();
		
		
		}
		
	private void closeViewContact() {
			dispose(); 
		}	
		
	
	}
