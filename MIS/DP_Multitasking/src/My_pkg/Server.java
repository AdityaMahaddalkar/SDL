package My_pkg;

import java.net.*;
import java.sql.SQLException;
import java.io.*;
import java.util.*;
public class Server extends Thread{
	//static Database db;
	static ServerSocket ServerSock;
	static ArrayList<ClientHandler> Clients;
	static ArrayList<Thread> ThreadList;
	public Server(int port)
	{
		try {
			ServerSock=new ServerSocket(port);
			Clients=new ArrayList<ClientHandler>();
			ThreadList = new ArrayList<Thread>();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		Server serv=new Server(5051);
		
		while(true) {
			Socket sock = serv.ServerSock.accept();
			
			ClientHandler handle = new ClientHandler(sock);
			
			serv.Clients.add(handle);
			
			Thread t = new Thread(handle);
			
			t.start();
		}
		
	}
	public void print(Object o)
	{
		System.out.println(o);
	}
}
class ClientHandler extends Thread
{
	DataInputStream dis;
	DataOutputStream dos;
	Socket sock;
	Database db;
	public ClientHandler(Socket sock) throws Exception, Exception
	{
		this.sock=sock;
		try {
			dis=new DataInputStream(sock.getInputStream());
			dos=new DataOutputStream(sock.getOutputStream());
			db = new Database();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
			try {
				String user_name=(String)dis.readUTF();
				String password=(String)dis.readUTF();
				boolean flag = db.returnData(user_name, password);
				if(flag)
				{
					dos.writeBoolean(true);
					print("Till Here");
					dos.writeUTF(db.name);
					dos.writeInt(db.roll_number);
					dos.writeFloat(db.attendance);
					dos.writeFloat(db.cgpa);
					
				}
				else
				{
					dos.writeBoolean(false);
				}


			} catch (IOException e) {
				e.printStackTrace();
				
			}
	}
	public void print(Object o)
	{
		System.out.println(o);
	}
	
}
