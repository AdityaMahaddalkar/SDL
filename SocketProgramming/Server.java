import java.util.*;
import java.io.*;
import java.net.*;

public class Server
{
	ServerSocket servsoc;
	Socket soc;
	Scanner sysin,ins;
	PrintWriter outs;
	
	public Server(int port)
	{
		try
		{
			servsoc=new ServerSocket(port);
			soc=servsoc.accept();
			System.out.println("Connected");
			sysin=new Scanner(System.in);
			ins=new Scanner(soc.getInputStream());
			outs=new PrintWriter(soc.getOutputStream());	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void communication() throws IOException
	{
		String msgin=new String(),msgout=new String();
		//String msgin="",msgout="";
		String name=ins.nextLine();
		try
		{
			
			do
			{	
				msgin=ins.nextLine();
				System.out.println(name+":"+msgin);
			
				if(msgin.equalsIgnoreCase("exit"))
				{
					break;
				}
				System.out.println("Server:");
				msgout=sysin.nextLine();
				outs.println(msgout);
				outs.flush();
			}while(!(msgin.equalsIgnoreCase("exit")) && !(msgout.equalsIgnoreCase("exit")));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	
	}
	
	public static void main(String args[]) throws IOException
	{
		Server serv=new Server(5010);
		serv.communication();
	}
}
