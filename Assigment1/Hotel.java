/* Class Descr:

Class: Hotel
Data structure used: Array of rooms
 		     ArrayDeque for club
			 Map for previous customers
 */
package Assigment1;
import java.util.*;

class Hotel extends Room{
	protected ArrayList<Room> arrayOfRooms;
	protected ArrayDeque<Room> clubDeque;
	private String adminPass;
	String hotelName;
	int [] suiteArr;

	public Hotel(){
		arrayOfRooms = new ArrayList<Room>();
		clubDeque = new ArrayDeque<Room>();
		adminPass = "123456";
		suiteArr = new int[3];
		for(int i = 0;i < 3;i ++){
			suiteArr[i] = 0;
		}
	}

	public Hotel(String name){
		arrayOfRooms = new ArrayList<Room>();
		clubDeque = new ArrayDeque<Room>();
		adminPass = "123456";
		hotelName = name;
		suiteArr = new int[3];
		for(int i = 0;i < 3;i ++){
			suiteArr[i] = 0;
		}
	}

	public static void print(Object s) { System.out.println(s); }

	protected void addRooms(String password, int noOfRooms){
		Scanner scan = new Scanner(System.in);
		if(password == adminPass){
			for(int i = 0;i < noOfRooms;i ++){
				print("Enter cost, rn, suite, floor: ");
				arrayOfRooms.add(new Room(scan.nextInt(), scan.next(), scan.next(), scan.nextInt(), false));

			}
			Iterator it = arrayOfRooms.iterator();
			while(it.hasNext()){
				Object iter = it.next();
				if(iter.suite == "I"){
					suiteArr[0] ++;
				}
				if(iter.suite == "II"){
					suiteArr[1] ++;
				}
				if(iter.suite == "III"){
					suiteArr[2] ++;
				}
			}
		}
		else{
			print("Wrong password");
		}
	}

	protected boolean bookRoom(){
		int chances = 5;
		String suiteIn;
		Scanner sc = new Scanner(System.in);
		while(chances != 0){
			chances -= 1;
			print("Enter the suite(I, II, III): ");
			suiteIn = sc.next();
			if(suiteIn == "I" && suiteArr[0] != 0){
				suiteArr[0] -= 1;
				break;
			}
			else if(suiteIn == "II" && suiteArr[1] != 0){
				suiteArr[1] -= 1;
				break;
			}
			else if(suiteIn == "III" && suiteArr[2] != 0){
				suiteArr[2] -= 1;
				break;
			}
			else{
				print("Suite not available! Select another one");
			}
		}
		if(chances > 0){
			Iterator it = arrayOfRooms.iterator();
			while(it.hasNext()){
				Object iter = it.next();
				if(iter.isOccupied() == false && iter.suite == suiteIn){
					iter.occupied = true;
					// add code here to book the room by far as programmer's view
				}
			}
		}
		else{
			print("Room not available");
			return false;
		}

	}

}
