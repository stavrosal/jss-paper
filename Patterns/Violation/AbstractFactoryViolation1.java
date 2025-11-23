public abstract class Character{
	public abstract void printAbility();
}

public abstract class Archer extends Character{
	public abstract void printAbility();
}

public abstract class Knight extends Character{
	public abstract void printAbility();
}

public class FPSArcher extends Archer{
	public void printAbility(){
		System.out.println("FPS Archer attacks with bow");
	}
}

public class MMOArcher extends Archer{
	public void printAbility(){
		System.out.println("MMO Archer attacks with bow");
	}
}

public class FPSKnight extends Knight{
	public void printAbility(){
		System.out.println("FPS Knight attacks with sword");
	}
}

public class MMOKnight extends Knight{
	public void printAbility(){
		System.out.println("MMO Knight attacks with sword");
	}
}



public abstract class GameFactory{
	public abstract Character createArcher();
	public abstract Character createKnight();

}

public class FPSGameFactory extends GameFactory{
	
	@Override
	public Character createArcher(){
		return new FPSArcher();
	}
	
	@Override
	public Character createKnight(){
		return new FPSKnight();
	}
}

public class MMOGameFactory extends GameFactory{
	
	@Override
	public Character createArcher(){
		return new MMOArcher();
	}
	
	@Override
	public Character createKnight(){
		return new MMOKnight();
	}
}



public class Game{
	private List<Character> chars = new ArrayList<Character>();
	private GameFactory gf;
	
	public Game(GameFactory g){
		this.gf = g;
	}
	
	public void addArcher(){
		chars.add(gf.createArcher());
	}
	
	public void addKnight(){
		chars.add(gf.createKnight());
	}
	
}

public class MainClass{
	
	public static void main(String[] args){
		Game g1 = new Game(new FPSGameFactory()); // Create an FPS game
		g1.addArcher();
		g1.addKnight();
		
		Game g2 = new Game(new MMOGameFactory()); // Create a MMO game
		g2.addArcher();
		g2.addKnight();
	}
}
