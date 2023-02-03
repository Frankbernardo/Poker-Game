package Player;

public class Player {
	private String name;
	private String id;
	private int bank;
	
	public Player() {
		name = "joecool";
		id = "123432";
		bank = 1000;
		
	}
	
	public Player(String name, String newID) {
		this.name = name;
		id = newID;
		
	}
	
	public Player(String name, String id, int bank) {
		this.name = name;
		this.id = id;
		this.bank = bank;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBank() {
		return bank;
	}

	public void setBank(int bank) {
		this.bank = bank;
	}
	
	@Override
	public String toString() {
		return "Player " + name + ", id: " + " has a bank of $" + bank;
	}
}
