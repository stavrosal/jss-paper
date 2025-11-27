/*
We wish to develop a system that creates games.
There are 2 types of games (FPS, MMO) and each
game has 2 characters (Archer and Knight) where
each character has different weapons, for example,
Knight attacks with a sword and Archer attacks with
a bow. You don't need to model weapons, just print
a line of the following type:
"<Genre> <Character> attacks with <Weapon>"
Assume that each character behaves differently
depending on the game genre. We want to be able 
to create Games that have a lot of characters, 
but we don't want to mix different genres
(for example, an FPS Knight on an MMO game).
*/

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
		g1.addArcher(new FPSArcher());
		g1.addKnight(new FPSKnight());
		
		Game g2 = new Game(); // Create a MMO game
		g2.addArcher(new MMOArcher());
		g2.addKnight(new MMOKnight());
	}
}