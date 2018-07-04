import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
	
	//Data members
	ServerSocket serverSock;
	Socket socket;
	Scanner sysIn,socketIn;
	PrintWriter printcom;
	
	public Server(int portno)
	{
		try
		{
			serverSock=new ServerSocket(portno);
			
			socket=serverSock.accept();
			System.out.println("Connected");
			sysIn=new Scanner(System.in);
			socketIn=new Scanner(socket.getInputStream());
			printcom=new PrintWriter(socket.getOutputStream(),true);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	public void messageTransfer()
	{
			String msg = new String() ,msg2 = new String();
			try
			{
				while(!msg2.equalsIgnoreCase("bye") && !msg.equalsIgnoreCase("bye"))
				{
				
						msg = socketIn.nextLine();
						if(msg2.equalsIgnoreCase("bye") || msg.equalsIgnoreCase("bye")){
							break;
						}
						System.out.println(msg);
						System.out.println("Your message: ");
						msg2 = sysIn.nextLine();
						printcom.println("Server : " + msg2);
						printcom.flush();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					//serverSock.close();
					socket.close();
					printcom.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}
			}
		public static void main(String[] args)
		{
			Server server1=new Server(4000);
			server1.messageTransfer();
		}
	}		
	


