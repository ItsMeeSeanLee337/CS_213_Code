package uml;

public class Building {
	
	public class Elevator {
		private String name;
		private short topFloor;
		public Elevator(String name, short topFloor) {
			this.name = name;
			this.topFloor = topFloor;
		}
	}
	
	public class Office {
		private short floor;
		private String room;
		public Office(short floor, String room) {
			this.floor = floor;
			this.room = room;
		}
	}
	
	private String name;
	private Elevator[] elevators;
	private Office[] offices;
	int numOffices;
	int numElevators;
	
	public Building(String name, int e_num, int o_num) {
		this.name = name;
		elevators = new Elevator[e_num];
		offices = new Office[o_num];
	}
	
	public void addOffice(Office office) {
		if (numOffices == offices.length) {
			throw new IllegalArgumentException("offices are maxed out");
		}
		offices[numOffices++] = office;
	}
	
	public void addElevator(Elevator elevator) {
		if (numElevators == elevators.length) {
			throw new IllegalArgumentException("elevators are maxed out");
		}
		elevators[numElevators++] = elevator;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Building: " + name + "\n");
		sb.append("\tElevators:\n");
		for (int e=0; e < numElevators; e++) {
			sb.append("\t\t('" + elevators[e].name + "'," + elevators[e].topFloor + ")\n");
		}
		sb.append("\tOffices:\n");
		for (int o=0; o < numOffices; o++) {
			sb.append("\t\t('" + offices[o].room + "'," + offices[o].floor + ")\n");
		}
		return sb.toString();	
	}
}
