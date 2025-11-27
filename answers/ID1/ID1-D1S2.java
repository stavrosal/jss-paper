enum GameType{
    FPS,MMO;
}

enum Character{
    Archer,Knight;
}

abstract class GameCharacter {
    protected GameType type;
    protected Character name;

    public GameCharacter(GameType type, Character name) {
        this.type = type;
        this.name = name;
    }

    public abstract void printAbility();
}


public class MainClass{
	
	public static void main(String[] args){
		
	}
}