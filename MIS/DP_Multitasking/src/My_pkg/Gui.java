package My_pkg;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Gui extends JFrame implements ActionListener{
	String username="admin";
	String Password="admin";
	JLabel label1,label2,label3;
	JTextField text;
	JButton button;
	JPasswordField password;
	public Gui() {
		JFrame jf=new JFrame("Sample");
		label1 = new JLabel("Login Form");
		label1.setForeground(Color.blue);
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		
		label2=new JLabel("Username");
		label3=new JLabel("Password");
		text=new JTextField();
		password=new JPasswordField();
		button=new JButton("Proceed");
		
		label1.setBounds(100, 30, 400, 30);
		label2.setBounds(80, 70, 200, 30);
		  label3.setBounds(80, 110, 200, 30);
		  text.setBounds(300, 70, 200, 30);
		  password.setBounds(300, 110, 200, 30);
		  button.setBounds(150, 160, 100, 30);
		  
		jf.add(label1);
		jf.add(label2);
		jf.add(label3);
		jf.add(text);
		jf.add(button);
		jf.add(password);
		button.addActionListener(this);
		
		jf.setSize(400, 400);
		jf.setLayout(null);
		jf.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String user=text.getText();
		//@SuppressWarnings("deprecation")
		String pass=password.getText();
		Client cl = null;
		boolean flag = false;
		try{
			cl = new Client();
			flag = cl.connection(user, pass);
		}
		catch(Exception excp){
			excp.printStackTrace();
		}
		
		if(flag)
		{
				
		     Main wel=new Main(cl.name,Integer.toString(cl.roll_number), Float.toString(cl.attendance), Float.toString(cl.cgpa));
		      wel.setVisible(true);
		      JLabel label = new JLabel("Welcome:"+user);
		      wel.getContentPane().add(label);
		 
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void main(String[] args) {
		Gui gui=new Gui();
	}
	

}
class Main extends JFrame
{
	JLabel label1,label2,printName,printRoll,label3,label4,printAttendance,printCgpa;
	JLabel main;
  Main(String name,String rollno, String attendance, String cgpa)
  {
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    
    JFrame jf=new JFrame("Welcome");
    main = new JLabel("Main Page");
	main.setForeground(Color.blue);
	main.setFont(new Font("Serif", Font.BOLD, 20));

    label1=new JLabel("Name:");
    label2=new JLabel("RollNo:");
    label3=new JLabel("Attendance:");
    label4=new JLabel("CGPA:");
    printName=new JLabel(name);
    printRoll=new JLabel(rollno);
    printAttendance=new JLabel(attendance);
    printCgpa=new JLabel(cgpa);
 
    main.setBounds(100, 30, 400, 30);
	label1.setBounds(80, 70, 200, 30);
	label2.setBounds(80, 110, 200, 30);
	printName.setBounds(300, 70, 200, 30);
	printRoll.setBounds(300, 110, 200, 30);
	label3.setBounds(80, 140, 200, 30);
	label4.setBounds(80, 170, 200, 30);
	printAttendance.setBounds(300, 140, 200, 30);
	printCgpa.setBounds(300, 170, 200, 30);


	  
	jf.add(main);
	jf.add(label1);
	jf.add(label2);
	jf.add(printName);
	jf.add(printRoll);
	
	jf.add(label3);
	jf.add(label4);
	jf.add(printAttendance);
	jf.add(printCgpa);
			
	jf.setSize(400, 400);
	jf.setLayout(null);
	jf.setVisible(true);
	
  }
 }