/*

Class Room

	data: cost of room
	      room nos
	      floor no
	      class (first second third)
*/

package Assigment1;
public class Room
{
	float cost;
	String roomNo;
	String suite;
	int floorNo;
	boolean occupied;
	String occupant;

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
			if(this.occupied == false){
				throw new Exception("Not occupied");
			}
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
