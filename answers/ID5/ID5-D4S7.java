public class Basket extends Player{

	String teamName;
	List <Player> players ;
	
	public(teamName,name,role){
		this.teamName=teamName;
		super(name,role);	
		players.add(name,role);
	}
	
		
	public void getAllPlayers(){
		System.out.println("Name: " +getName());
	}
	
	public boolean searchPlayer (Player p){
		return (players.contains(p));
	}
	
}


public class Player () {
	protected string name;
	protected string role;

	public Player(name,role){
		this.name= name;
		this.role=role;		
	}

	public String getName() {
       	 return name;
   	 }

}