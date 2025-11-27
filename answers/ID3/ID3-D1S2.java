
public abstract class Character{
	public abstract void printAbility();
}

public abstract class Archer extends Character{
	public abstract void printAbility(String gameType, String charType, String weapon);
}

public abstract class Knight extends Character{
	public abstract void printAbility(String gameType, String charType);
}

/*
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
	*/


public void printAbility(gameType, charType, weapon)
{
	System.out.println("A" + gameType + charType + "attacks with" + weapon);
}




public class Game{
	private List<Character> chars; 

	
	public Game(){
		this.chars = new ArrayList<Character>();
	}
	
	public void addArcher(Character c){
		chars.add(c);
	}
	
	public void addKnight(Character c){
		chars.add(c);
	}
	
}

public class MainClass{
	
	public static void main(String[] args){
		Game g1 = new Game(); // Create an FPS game
		g1.addArcher(("FPS", "archer", "bow"));
		g1.addKnight(("FPS", "knight", "sword"));
		
		Game g2 = new Game(); // Create a MMO game
		g2.addArcher(("MMO", "archer", "bow"));
		g2.addKnight(("MMO", "knight", "sword"));
	}
}
