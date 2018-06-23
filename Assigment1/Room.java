/*

Class Room

	data: cost of room
	      room nos
	      floor no
	      class (first second third)
*/

public class Room
{
	protected float cost;
	protected String roomNo;
	protected String suite;
	protected int floorNo;
	protected boolean occupied;
	protected String occupant;

	public Room()
	{
		cost=0;
		roomNo="NA";
		suite="NA";
		floorNo=0;
		occupied=false;
		occupant = "NA";

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
	boolean addOccupant(String name){
		try{
			this.occupant = name;
			this.occupied = true;
		}
		catch(Exception e){
			//print(String(e));
			return false;
		}
		return true;
	}
	boolean deleteOccupant(){
		try{
			this.occupant = "NA";
			this.occupied = false;
		}
		catch(Exception e){
			return false;
		}
		return true;
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
