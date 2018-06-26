/* class Area
	Covering multiple hotels in a city
	
	
*/
package Assigment1;
import java.util.*;

class Area
{
	HashMap<String,Hotel> HotelList;
	public Area()
	{
		 HotelList=new HashMap<String,Hotel>();
	}
	void addHotel()
	{
		Scanner it=new Scanner(System.in);
		System.out.println("Enter name of Hotel==");
		String name=new String(it.next());
		Hotel h1=new Hotel(name);
		String password=new String();
		System.out.println("\n Enter Password and no of rooms");
		password=it.next();
		int noOfRooms=0;
		noOfRooms=it.nextInt();
		h1.addRooms(password,noOfRooms);
		HotelList.put(name,h1);
	}
	void addHotels(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of hotels:");
		int no_hotel = sc.nextInt();
		for(int i = 0;i < no_hotel;i ++){
			addHotel();
		}
		
	}
	void findHotels()
	{
		Scanner it=new Scanner(System.in);
		System.out.println("Enter name of Hotel To be searched==");
		String name=new String(it.next());
		if(HotelList.containsKey(name))
		{
			Hotel temp=HotelList.get(name);
			
			if(!temp.checkin())
			{
				System.out.println(" Hotel full!!");
	
			}
		}
		else
		{
			System.out.println("Hotel Not Found!!");
		}
	}
	void operations()
	{
		Scanner it=new Scanner(System.in);
		do{
			System.out.println("Enter hotel name==");
			
			String name=it.next();
			if(!HotelList.containsKey(name))
				return;
				
			Hotel temp=HotelList.get(name);
			System.out.println("************OPTIONS**************");
			System.out.println("1.Book Club \n2.Exit club \n3. Checkout");	
			
			
			int mno=it.nextInt();
			
			switch(mno)
			{
				case 1:
					temp.bookClub();
					break;
				case 2:
					temp.exitClub();
					break;
				case 3:
					temp.checkout();
					break;
					
			}
			System.out.println("Do u want to continue??(y/n)");
			
	}while(it.next().equalsIgnoreCase("y"));
    }
}
