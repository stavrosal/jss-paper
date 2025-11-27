public interface GameFactory {
    Archer createArcher();
    Knight createKnight();
}

public class FPS implements GameFactory {
    public Archer createArcher() {
        return FPSArcher();
    }
    public Knight createKnight() {
        return FPSKnight();
    }
}

public class MMO implements GameFactory {
    public Archer createArcher() {
        return MMOArcher();
    }
    public Knight createKnight() {
        return MMOKnight();
    }
}

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

