import java.util.*;
import java.io.*;
import java.net.*;

public class Client
{
	Socket soc;
	Scanner sysin,ins;
	PrintWriter outs;
	
	public Client(String host,int port)
	{
		try
		{
		
			soc=new Socket(host,port);
			sysin=new Scanner(System.in);
			ins=new Scanner(soc.getInputStream());
			outs=new PrintWriter(soc.getOutputStream());	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void communication(String name) throws IOException
	{
		String msgin=new String(),msgout=new String();
		outs.println(name);
		outs.flush();
		//String msgin="",msgout="";
		try
		{
			do
			{
			
				System.out.println(name+":");
				msgin=sysin.nextLine();
				outs.println(msgin);
				outs.flush();

				
							
				if(msgin.equalsIgnoreCase("exit"))
				{
					break;
				}
				
				msgout=ins.nextLine();
				System.out.println("Server:"+msgout);
			}while(!(msgin.equalsIgnoreCase("exit")) && !(msgout.equalsIgnoreCase("exit")));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	

	}
	
	public static void main(String args[]) throws IOException
	{
		Scanner in=new Scanner(System.in);
		Client cl1=new Client("127.0.0.1",5010);
		System.out.println("Enter ur name");
		cl1.communication(in.next());
			
	}
}
