/* MainClass : 
Contains: Hashtable of Areas
*/

package Assigment1;
import java.util.*;
public class MainClass{
	Hashtable<String, Area> tableOfArea;
	String adminPass;
	
	//Functions
	
	MainClass(){
		tableOfArea = new Hashtable<String, Area>();
		adminPass = "123456";
	}
	
	void addAreas(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the admin password:");
		if(!sc.next().equals(adminPass)){
			System.out.println("Respect other's privacy");
			return;
		}
		System.out.println("Enter the number of areas:" );
		int number = sc.nextInt();
		String name;
		for(int i = 0;i < number; i ++){
			System.out.println("Enter name of area:");
			name = sc.next();
			tableOfArea.put(name, new Area());
		}
	}
	
	void initializeAreas(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter admin password:");
		if(!sc.next().equals(adminPass)){
			System.out.println("Respect other's privacy");
			return;
		}
		for(int i = 0;i != tableOfArea.size();i ++){
			System.out.println("Enter the name of area:");
			String area = sc.next();
			tableOfArea.get(area).addHotels();
		}
	}
	
	void book(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of area:");
		String name = sc.next();
		if(!tableOfArea.containsKey(name)){
			System.out.println("Area not available");
			return;
		}
		tableOfArea.get(name).findHotels();
		
	}
	void performOp(){
		System.out.println("Enter the name of the area:");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		if(!tableOfArea.containsKey(name)){
			System.out.println("NA");
			return;
		}	
		tableOfArea.get(name).operations();
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		MainClass mc = new MainClass();
		// Initially add areas as admin
		mc.addAreas();
		// Next initialize areas;
		mc.initializeAreas();
		// Try booking a hotel;
		mc.book();
		// Perform operations
		mc.performOp();
	}
}
/*d

123456
1
d
123456

1
p
123456 4
12 A100 I 2
12 A200 II 3
12 A300 II 4
12 A400 III 5
d
p
III
Pratik Patil
*/
