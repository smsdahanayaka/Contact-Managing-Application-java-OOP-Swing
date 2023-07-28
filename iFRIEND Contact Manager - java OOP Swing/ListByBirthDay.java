

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class ListByBirthDay extends JFrame{
	private JLabel mainLable1;
	
	private JButton btnListByName;
	private JButton btnListBySalary;
	private JButton btnListByBirthDay;
	private JButton btnBackToHome;
	private JButton btnCancel;
	
	private JTable listByName;
	private DefaultTableModel dtm;

	private ViewContact viewContact;
	
	JPanel centerPanel;
	ListByBirthDay(){
		setSize(1200,800);
		setTitle("List By Birth Day");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLocationRelativeTo(null);
		
		JPanel topPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		mainLable1=new JLabel("List By Birth Day");
		topPanel.setBackground(Color.cyan);
		mainLable1.setFont(new Font("",Font.BOLD,30));
		topPanel.add(mainLable1);
		
		disPlay();
		
		JPanel botPanel=new JPanel(new GridLayout(1,2));
		JPanel botPanelInner=new JPanel(new GridLayout(2,1));
		botPanelInner.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 10));
		JPanel botPanelInnerIn=new JPanel(new GridLayout(1,2));
		JPanel temp=new JPanel();
		
		JPanel btnPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnBackToHome=new JButton("Back To page");
		btnBackToHome.setFont(new Font("",1,15));
		btnBackToHome.setPreferredSize(new Dimension(200, 30));
		btnBackToHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				closeListByBirthDay();
				if(viewContact==null){
					viewContact=new ViewContact();
					viewContact.setVisible(true);
					}	
			}
			});
		btnPanel.add(btnBackToHome);
		
		JPanel btnPanelCancel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnCancel=new JButton("Refresh");
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
	
	private void disPlay(){
		ContactDetails[] rowData=ContactController.listByBirthDay();
				
				centerPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
				centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				String[] columnsName={"Contact Id","Name","Number","Company","Salary","Date Of Birth"};
				dtm=new DefaultTableModel(columnsName,0);
				listByName=new JTable(dtm);
				listByName.setFont(new Font("",1,15));
				JScrollPane tablePane=new JScrollPane(listByName);
				centerPanel.add(tablePane);
				add("Center",centerPanel);
		
				
				for(int i=0;i<rowData.length;i++){
					Object[] row={rowData[i].getContactId(),rowData[i].getContactName(),rowData[i].getContactNumber(),rowData[i].getCompanyName(),rowData[i].getSalary(),rowData[i].getBirthDay()};
					dtm.addRow(row);
					
					}
		
		}
	
	
	private void closeListByBirthDay() {
			dispose(); 
		}	
	
	
	}
