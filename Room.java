/*

Class Room

	data: cost of room
	      room nos 
	      floor no
	      class (first second third)
*/


public class Room
{
	float cost;
	String roomNo;
	String suite;
	int floorNo;
	boolean occupied;


	public Room()
	{
		cost=0;
		roomNo="NA";
		suite="NA";
		floorNo=0;
		occupied=false;
		
		
		
	}
	public Room(int cost,String roomNo,String suite,int floorNo,boolean occupied)
	{
		this.cost=cost;
		this.roomNo=roomNo;
		this.suite=suite;
		this.floorNo=floorNo;
		this.occupied=occupied;
	}
	boolean isOccupied()
	{
		return occupied;
	}
	void roomService()
	{
		if(occupied)
		{
			System.out.println(" Room is occupied ");
			
		}
		else
		{
			System.out.println(" Room service done!");
		}
	}
	
	
	
}


