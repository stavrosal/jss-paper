/*
We want to model Basket teams. Each team has a name
(string) and players with different roles. There are 3 roles:
 -defenders
 -attackers
 -forwarders
We want a functions that prints all players' names
(void), regardless of their role. We also want
3 functions (one for each role) that get a Player object
as a parameter and return True/False based on whether the
player is in the team or not (boolean). Assume that Player
class is implemented and that all 3 player roles extend this
class. Assume also that there is a getName() method.
*/

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