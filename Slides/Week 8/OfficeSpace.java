package uml;

public class OfficeSpace {

	public static void main(String[] args) {
		Building hill = new Building("Hill Center",2,10);
		
		/*
		 * note the syntax on the RHS
		 * and also note that a new Office requires a Building instance
		 */
		Building.Office office = hill.new Office((short)2,"HLL 271");
		hill.addOffice(office);
		
		/*
		 * the following variation of the above won't work
		 * because you don't have a building instance to anchor the office instance
		 */
		//Building.Office office = new Building.Office((short)2,"271");
		
		hill.addOffice(hill.new Office((short)3,"HLL 306"));
		
		hill.addElevator(hill.new Elevator("A",(short)5));
		hill.addElevator(hill.new Elevator("B",(short)7));
		
		System.out.println(hill);
		
	}

}
