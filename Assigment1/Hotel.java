/* Class Descr:

Class: Hotel
Data structure used: Array of rooms
 		     ArrayDeque for club
			 Map for previous customers
 */
package Assigment1;
import java.util.*;



class Hotel{
	protected ArrayList<Room> arrayOfRooms;
	protected ArrayDeque<String> clubDeque;
	private String adminPass;
	private HashSet<String> customerSet;
	String hotelName;
	int [] suiteArr;

	public Hotel(){
		arrayOfRooms = new ArrayList<Room>();
		clubDeque = new ArrayDeque<String>();
		adminPass = "123456";
		suiteArr = new int[3];
		for(int i = 0;i < 3;i ++){
			suiteArr[i] = 0;
		}
	}

	public Hotel(String name){
		arrayOfRooms = new ArrayList<Room>();
		clubDeque = new ArrayDeque<String>();
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
		if(password.equals(adminPass)){
			for(int i = 0;i < noOfRooms;i ++){
				print("Enter cost, rn, suite, floor: ");
				arrayOfRooms.add(new Room(scan.nextInt(), scan.next(), scan.next(), scan.nextInt(), false));

			}
			
			int i = 0;
			while(i != arrayOfRooms.size()){
				
				if(arrayOfRooms.get(i).suite.equals("I")){
					suiteArr[0] += 1;
				}
				else if(arrayOfRooms.get(i).suite.equals("II")){
					suiteArr[1] += 1;
				}
				else if(arrayOfRooms.get(i).suite.equals("III")){
					suiteArr[0] += 1;
				}
				i += 1;
			}
		}
		else{
			print("Wrong password");
		}
	}

	protected boolean checkin(){
		int chances = 5;
		String suiteIn;
		Scanner sc = new Scanner(System.in);
		print("Enter the suite(I, II, III): ");
		suiteIn = sc.next();
		while(chances != 0){
			chances -= 1;
			if(suiteIn.equals("I") && suiteArr[0] != 0){
				suiteArr[0] -= 1;
				break;
			}
			else if(suiteIn.equals("II") && suiteArr[1] != 0){
				suiteArr[1] -= 1;
				break;
			}
			else if(suiteIn.equals("III") && suiteArr[2] != 0){
				suiteArr[2] -= 1;
				break;
			}
			else{
				print("Suite not available! Select another one");
				print("Enter the suite(I, II, III): ");
				suiteIn = sc.next();
			}
		}
		if(chances > 0){
			
			int i = 0;
			while(i != arrayOfRooms.size()){
				i -= 1;
				if(!arrayOfRooms.get(i).isOccupied() && arrayOfRooms.get(i).suite.equals(suiteIn)){
					System.out.println("Enter the occupant name:");
					String name = sc.next();
					customerSet.add(name);
					arrayOfRooms.get(i).addOccupant(name);
					break;
				}
			}
			System.out.println("Success!");
			return true;
		}
		else{
			print("Room not available");
			return false;
		}

	}

	protected boolean checkout(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the occupant: ");
		String name = sc.next();
		int i = 0;
		while(i != arrayOfRooms.size() &&  !arrayOfRooms.get(i).occupant.equals(name)){
			i += 1;
		}
		if(arrayOfRooms.get(i).occupant.equals(name)){
			if(arrayOfRooms.get(i).deleteOccupant()){
				return true;
			}
			return false;
		}
		return false;
	}

	void bookClub(){
		System.out.println("Enter the room number");
		Scanner sc = new Scanner(System.in);
		try{
			String r_no = sc.next();
			if(clubDeque.contains(r_no)){
				throw new Exception("Already in the queue");
			}
			clubDeque.add(r_no);
		}
		catch(Exception e){
			print(e);
		}
	}

	void exitClub(){
		System.out.println("Exited Room: " + clubDeque.getLast());
	}
}
