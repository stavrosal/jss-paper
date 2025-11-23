public class Warehouse{
	private String name;
	private List<Item> items; // available items (stock)
	private List<Item> orders; // ordered items (removed from stock)
	private String type;
	private String VAType;
	
	public Warehouse(String n, List<Item> i, String type, String vat){
		this.name = n;
		this.items = i;
		this.type = type;
		this.VATtype = vat;
	}
	
	public void addOrder(Item i){
		items.remove(i);
		orders.add(i);
	}
	
	
	public double calcCost(){
		double vat = 0.0;
		if (VAType.equals("REDUCED")){
			vat = 0.13;
		}
		else if (VAType.equals("NORMAL")){
			vat = 0.24;
		}
		else if (VAType.equals("EXTRA")){
			vat = 0.33;
		}
		
		double cost = 0;
		for (Item i ; orders){
			cost += i.getPrice();
		}
		
		return (cost + cost*vat);
			
	}

}

