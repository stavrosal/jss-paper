public abstract class Clothes{
	public abstract void printInfo();
}

public abstract class Shirt extends Clothes{
	public abstract void printInfo();
}

public abstract class Pants extends Clothes{
	public abstract void printInfo();
}


public class VintageShirt extends Shirt{
	public void printInfo(){
		System.out.println("A vintage shirt");
	}
}

public class ModernShirt extends Shirt{
	public void printInfo(){
		System.out.println("A modern shirt");
	}
}

public class VintagePants extends Pants{
	public void printInfo(){
		System.out.println("A vintage pair of pants");
	}
}

public class ModernPants extends Pants{
	public void printInfo(){
		System.out.println("A modern pair of pants");
	}
}



public abstract class ClothingFactory{
	public abstract Clothes createShirt();
	public abstract Clothes createPants();
}

public VintageClothingFactory extends ClothingFactory{
	
	@Override
	public Clothes createShirt(){
		return new VintageShirt();
	}
	
	@Override
	public Clothes createPants(){
		return new VintagePants();
	}
}


public ModernClothingFactory extends ClothingFactory{
	
	@Override
	public Clothes createShirt(){
		return new ModernShirt();
	}
	
	@Override
	public Clothes createPants(){
		return new ModernPants();
	}
}


public class Shop{
	private List<Clothes> clothing = new ArrayList<Clothes>();
	private ClothingFactory cf;
	
	public Shop(ClothingFactory c){
		this.cf = c;
	}
	
	public void addShirt(){
		cf.add(cf.createShirt());
	}
	
	public void addPants(){
		cf.add(cf.createPants());
	}
}

public class MainClass{
	
	public static void main(String[] args){
		Shop vintageShop = new Shop(new VintageClothingFactory()); // Create a Vintage shop
		vintageShop.addShirt();
		vintageShop.addPants();
		
		Shop modernShop = new Shop(new ModernClothingFactory()); // Create a Modern shop
		modernShop.addShirt();
		modernShop.addPants();
		
	}


}
