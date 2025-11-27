class Basket{
	String teamName;

	List<Defender> defenders;
	List<Attacker> attackers;
	List<Forwarder> forwarders;
		
	
	public void getAllPlayers(){
		for (Defender d : defenders){
			System.out.println(d.getName());
		}
		for (Attacker a : attackers){
			System.out.println(a.getName());
		}
		for (Forwarder f : forwarders){
			System.out.println(f.getName());
		}
	}

}

class Defender extends Player{

	public boolean searchDefender(Defender){
		return(defenders.contains(d));
}

class Attacker extends Player{

	public boolean searchAttacker(Attacker a){
		return (attackers.contains(a));
	}

class Forwarder extends Player{
	
	public boolean searchForwarder(Forwarder f){
		return(forwarders.contains(f));
	}