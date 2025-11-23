/* There are two types of warehouses: Local and Central
 * Each warehouse applies different type of VAT (reduced,
 * normal and extra) on products sold based on its location 
 */

public abstract class VAT{
	protected double percentage;
	
	
	public VAT(double perc){
		this.percentage = perc;
	}
	

	public abstract double getVATLocal();
	public abstract double getVATCentral();

	
}

public class VATReduced extends VAT{

	public VATReduced(double p){
		super(p);
	}
	
	
	public double getVATLocal(){
		return 0.13;
	}
	
	public double getVATCentral(){
		return 0.13;
	}
}

public class VATNormal extends VAT{

	public VATNormal(double p){
		super(p);
	}
	
	
	public double getVATLocal(){
		return 0.24;
	}
	
	public double getVATCentral(){
		return 0.24;
	}
}

public class VATExtra extends VAT{

	public VATExtra(double p){
		super(p);
	}
	
	public double getVATLocal(){
		return 0.33;
	}
	
	public double getVATCentral(){
		return 0.33;
	}
}
 
 
 
 

public abstract class Warehouse{
	protected String name;
	protected List<Item> items; // available items (stock)
	protected List<Item> orders; // ordered items (removed from stock)
	
	protected VAT vat; // VAT type of the warehouse (Reduced, Normal, Extra)
	
	public Warehouse(String n, List<Item> i, VAT vat){
		this.name = n;
		this.items = i;
		this.vat = vat;
	}
	
	public abstract void addOrder(Item i);
	
	public abstract void calcCost();


}


public class LocalWarehouse extends Warehouse{

	
	public LocalWarehouse(String n, List<Item> i, VAT vat){
		super(n, i, vat);
		orders = new ArrayList<Order>();
	}
	
	public void addOrder(Item i){
		items.remove(i);
		order.add(i);
	}
	
	public void calcCost(){
		double cost = 0;
		for (Item i ; orders){
			cost += i.getPrice();
		}
		
		return (cost + cost*vat.getVATLocal());
	}

}


public class CentralWarehouse extends Warehouse{

	
	public CentralWarehouse(String n, List<Item> i, VAT vat){
		super(n, i, vat);
		orders = new ArrayList<Order>();
	}
	
	public void addOrder(Item i){
		items.remove(i);
		order.add(i);
	}
	
	public void calcCost(){
		double cost = 0;
		for (Item i ; orders){
			cost += i.getPrice();
		}
		
		return (cost + cost*vat.getVATCentral());
	}

}
	