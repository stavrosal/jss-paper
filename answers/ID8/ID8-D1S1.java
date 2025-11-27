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

enum Genre {
    FPS,
    MMO,
}

public abstract class Character{
    enum Type {
        Archer,
        Knight,
    }
    enum Weapon {
        Bow,
        Sword,
    }

    protected Genre genre;
    protected Type type;
    protected Weapon weapon;

    public Character(Genre genre, Type type, Weapon weapon){
        this.genre = genre;
        this.type = type;
        this.weapon = weapon;
    }

	public void printAbility(){
        System.out.println(String.format("%s %s attack with %s", genre.name(), type.name(), weapon.name()));
    }

    public Genre getGenre(){
        return genre;
    }
}

public class FPSArcher extends Character{
	public FPSArcher(){
        super(Genre.FPS, Type.Archer, Weapon.Bow);
    }
}

public class MMOArcher extends Character{
	public MMOArcher(){
		super(Genre.MMO, Type.Archer, Weapon.Bow);
	}
}

public class FPSKnight extends Character{
	public FPSKnight(){
        super(Genre.FPS, Type.Knight, Weapon.Sword);
    }
}

public class MMOKnight extends Character{
	public MMOKnight(){
        super(Genre.MMO, Type.Knight, Weapon.Sword);
    }
}

public class Game{
	private List<Character> chars;
    private Genre genre;

	public Game(Genre genre){
		this.chars = new ArrayList<Character>();
        this.genre = genre;
	}
	
	public void addCharacter(Character c){
        if (c.getGenre() == genre) {
		    chars.add(c);
        }
	}
}

public class MainClass{
	
	public static void main(String[] args){
		Game g1 = new Game(Genre.FPS);
		g1.addCharacter(new FPSArcher());
		g1.addCharacter(new FPSKnight());
		
		Game g2 = new Game(Genre.MMO);
		g2.addCharacter(new MMOArcher());
		g2.addCharacter(new MMOKnight());
	}
}