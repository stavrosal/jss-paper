package stavrosdemo;

import java.util.ArrayList;
import java.util.List;
//δεν εχω υλοποιησει το abstract factory gia FPS kai MMO
public class MainClass {

	public static void main(String[] args){
		Game g1 = new Game(); // Create an FPS game
		g1.addArcher(new FPSArcher());
		g1.addKnight(new FPSKnight());
		
		Game g2 = new Game(); // Create a MMO game
		g2.addArcher(new MMOArcher());
		g2.addKnight(new MMOKnight());
	}

public enum Genre{
	FPS,MMO;
}
	
public abstract class Character{
	private enum Genre genre;
	 
	public void Character(Genre genre) {
		this.genre = genre;
	}
	public abstract void printAbility();
}

public abstract class Archer extends Character{
	public Archer(Genre genre) {
		super(genre);
	}
	
	
	public void printAbility(){
		System.out.println(genre+" Archer attacks with bow");
	}
}

public abstract class Knight extends Character{
	public Knight(Genre genre) {
		super(genre);
	}
	
	
	public void printAbility(){
		System.out.println(genre+ " Knight attacks with sword");
	}
}


public class Game{
	private List<Character> chars; 

	
	public Game(){
		this.chars = new ArrayList<Character>();
	}
	
	public void addCharacter(Character c){
		chars.add(c);
	}
	
	
}
}