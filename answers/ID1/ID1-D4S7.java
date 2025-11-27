class Basket{
	String teamName;

	List<Player> players= new ArraList<>();
	
	public void addPlayer(Player p) {
            players.add(p);
        }
 
	public void getAllPlayers(){
		for (Player d : players){
			System.out.println(d.getName());

	}
	
	public boolean searchAttacker(Attacker a){
		return (players.contains(a));
	}
	
	public boolean searchDefender(Defender d){
		return(players.contains(d));
	}
	
	public boolean searchForwarder(Forwarder f){
		return(player.contains(f));
	}

}

PUBLIC class abstract Player{
	String name

	//constructor

	public String getName(){
	    returb name;
	}
}

PUBLIC class Defender extends Player {
    public Defender(String name) {
        super(name);
    }
}

pyblic class Attacker extends Player {
    public Attacker(String name) {
        super(name);
    }
}

public class Forwarder extends Player {
    public Forwarder(String name) {
        super(name);
    }
}