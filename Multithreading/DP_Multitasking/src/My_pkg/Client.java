package My_pkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	Socket sock;
	DataInputStream dis;
	DataOutputStream dos;
	public String name, user_name, password;
	public int roll_number;
	public float attendance, cgpa;
	
	public Client() throws UnknownHostException, IOException{
		sock = new Socket("127.0.0.1", 5051);
		dis = new DataInputStream(sock.getInputStream());
		dos = new DataOutputStream(sock.getOutputStream());
	}
	
	public void print(Object obj){System.out.println(obj);}
	
	public boolean connection(String username, String password) throws Exception{
		try{
			/*Scanner sc = new Scanner(System.in);
			print("Enter username: ");
			user_name = sc.next();
			print("Enter password: ");
			password = sc.next();+*/
			dos.writeUTF(username);
			dos.writeUTF(password);
			
			boolean flag = dis.readBoolean();
			if(flag){
				name = dis.readUTF();
				roll_number = dis.readInt();
				attendance = dis.readFloat();
				cgpa = dis.readFloat();
				/*
				print("Name: " + name);
				print("Roll number: " + roll_number);
				print("Attendance: " + attendance);
				print("CGPA: " + cgpa);
				*/
				return true;
			}
			else{
				print("User name and password not valid");
				print("\nThankyou for using the system");
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			sock.close();
		}
		return false;
		
	}
	
	public static void main(String args[]) throws Exception{
		Client cl = new Client();
		cl.connection("naren", "khake");
	}
	
}
