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
		tableOfArea = new Hashtable<String, Area> tableOfArea;
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
	
	void 
	
	public static void main(String args[]){
	
	}
}
