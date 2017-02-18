package shops;

import java.util.ArrayList;
import java.util.Random;

import shops.Dostavchik.Stoka;

public abstract class TurgovskiObekt {
	
	interface IEdnolichen{}
	
	interface IVeriga{}
	
	static class Sergiq extends TurgovskiObekt implements IEdnolichen{
		Sergiq(String adress, String rabotnoVreme){
			super(adress, rabotnoVreme);
			int randomSize = rn.nextInt(8)+2;
			this.plosht = randomSize;
			this.danuk = 50;
		}
	}
	
	static class Magazin extends TurgovskiObekt implements IVeriga{
		Magazin(String adress, String rabotnoVreme){
			super(adress, rabotnoVreme);
			int randomSize = rn.nextInt(90)+10;
			this.plosht = randomSize;
			this.danuk = 150;
		}		
	}
	
	static class Butka extends TurgovskiObekt implements IEdnolichen, IVeriga{
		Butka(String adress, String rabotnoVreme){
			super(adress, rabotnoVreme);
			int randomSize = rn.nextInt(2)+4;
			this.plosht = randomSize;
			this.danuk = 50;
		}	
	}
	
	private String adress;
	private String rabotnoVreme;
	protected int plosht;
	protected double danuk;
	private double money;
	private double oborotZaStatistika;
	private ArrayList<Stoka> stokaZaProdavane;
	private ArrayList<Stoka> prodadenaStoka;
	Random rn = new Random();
	
	TurgovskiObekt(String adress, String rabotnoVreme){
		this.adress = adress;
		this.rabotnoVreme = rabotnoVreme;
		this.money = 0;
		this.oborotZaStatistika = 0;
		stokaZaProdavane = new ArrayList<>();
		prodadenaStoka = new ArrayList<>();
		
	}
	
	void takeItems(ArrayList<Stoka> stoka){
		this.stokaZaProdavane.addAll(stoka);
	}
	void sellItems(){
		int sells = rn.nextInt(stokaZaProdavane.size());
		int x = stokaZaProdavane.size();
		for(int i = 0; i<= sells; i++){
			int whithToSell = rn.nextInt(x);
			this.money += stokaZaProdavane.get(whithToSell).getCena()*30;
			Stoka a = stokaZaProdavane.get(whithToSell);
			prodadenaStoka.add(a);
			this.stokaZaProdavane.remove(whithToSell);
			x--;
		}
		this.oborotZaStatistika += this.money;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
}
