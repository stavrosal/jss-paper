class Basket{
	String teamName;

	List<Player> players;
		
	
	public void getAllPlayers(){
		for (Player p : players){
			System.out.println(p.getName());
		}
	}
	
	public boolean searchPlayer(Player p){
		return players.contains(p);
	}

}

interface Player{
	public String getName();
}

class Defender extends Player{
	String name;
	
	public Defender(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
}

class Attacker extends Player{
	String name;
	
	public Attacker(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
}

class Forwarder extends Player{
	String name;
	
	public Forwarder(String n){
		this.name = n;
	}
	
	public String getName(){
		return this.name;
	}
}