import java.util.*;

abstract class Player {
    protected String name;
	protected String position;

    public Player(String name) {
        this.name = name;
    }

    public abstract String getPosition();

    public String getName() {
        return name;
    }
}


class Attacker extends Player {
    ...
	public Attacker(String name) {
        super(name,position);
		this.position="Attacker";
    }
	...
	
	@Override
	public String getPosition(){
		return position;
	}
	
}

class Defender extends Player {
	...
    public Defender(String name,String position) {
        super(name,position);
		this.position="Defender";
    }
	
	@Override
	public String getPosition(){
		return position;
	}
    ...
}

class Forwarder extends Player {
	...
    public Forwarder(String name,String position) {
        super(name,position);
		this.position="Forwarder";
    }
	
	@Override
	public String getPosition(){
		return position;
	}
	...
}


class Team {
    private String name;
    private List<Player> players;

    public void getAllPlayers() {
        for (Player p : players) {
           System.out.println(p.name());
        }
    }
	public boolean searchPlayer(Player p, String position){
		if(p.getPosition.equals(position))
			return (players.contains(p));
		return("Player is not " + position + " or does not exist" );
	}
}