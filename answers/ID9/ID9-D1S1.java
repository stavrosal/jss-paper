public abstract class Character{
	public abstract void printAbility();
}

public abstract class Archer extends Character{
	public abstract void printAbility();
}

public abstract class Knight extends Character{
	public abstract void printAbility();
}

public abstract class Game{}{
	private List<Character> chars;

}
public class MMO extends Game{}{
	
	public MMO(){
	}
	
	private class MMOArcher() extends Archer{
		
	}
	
	private class MMOKnight() extends Knight{
		
	}
}

public class FPS extends Game{}{
	public FPS(){
	}
	private class FPSArcher() extends Archer{
		
	}
	
	private class FPSKnight() extends Knight{
		
	}
}

public class MainClass{
	public static void main(String[] args){
	//θεωριστε υλοποιηση
	}	
}