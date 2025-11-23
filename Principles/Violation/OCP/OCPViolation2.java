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
	
	public boolean searchAttacker(Attacker a){
		return (attackers.contains(a));
	}
	
	public boolean searchDefender(Defender d){
		return(defenders.contains(d));
	}
	
	public boolean searchForwarder(Forwarder f){
		return(forwarders.contains(f));
	}

}
