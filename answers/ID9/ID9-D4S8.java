class Basket{
	String teamName;
	List<Player> players;
		
	
	public void getAllPlayers(){
		for(Player p : this.players){
			System.out.println(p.getName());			
		}
	}
	
	public boolean searchPlayerByRole(Player player){
		return (players.contains(player));
	}

}