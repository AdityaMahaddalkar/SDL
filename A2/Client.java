// A simple client class to connect to server class
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	//Data members
	Socket sock;
	Scanner socketScanner;
	Scanner systemScanner;
	PrintWriter socketWriter;
	String name;
	
	//Member functions
	
	public Client(String ip, int port, String name){
		try{
			this.name = name;
			sock = new Socket(ip, port);
			socketScanner = new Scanner(sock.getInputStream());
			systemScanner = new Scanner(System.in);
			socketWriter = new PrintWriter(sock.getOutputStream(), true);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void messageTransfer(){
		String msg2 = new String() , msg = new String() ;
		try{
			while(!msg.equalsIgnoreCase("bye") && !msg2.equalsIgnoreCase("bye")){
				//Send a message
				System.out.println("Your message: ");
				msg=systemScanner.nextLine();
				socketWriter.println(name + " : " + msg);
				socketWriter.flush();
				msg2 = socketScanner.nextLine();
				if(msg2.equalsIgnoreCase("bye") || msg.equalsIgnoreCase("bye")){
					break;
				}
				System.out.println(msg2);
					
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				sock.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//Driver program
	
	public static void main(String args[]){
		
		//Construct Client object
		System.out.println("Enter ip and port and name: ");
		//Scanner sysScan = new Scanner(System.in);
		Client client1 = new Client("127.0.0.1", 4000, "Adi");
		//sysScan.close();
		client1.messageTransfer();	
		
		
	}
	
}
