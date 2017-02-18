package shops;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import shops.Dostavchik.Dreben;
import shops.Dostavchik.Stoka;
import shops.TurgovskiObekt.IEdnolichen;
import shops.TurgovskiObekt.IVeriga;

public abstract class Turgovec {
	
	static class Ambulanten extends Turgovec{
		
		private ArrayList<Stoka> stoka = new ArrayList<>();
		private ArrayList<Stoka> prodadena = new ArrayList<>();
		private Dreben dostavchik;
		
		public Ambulanten(String ime, String adress, double kapital) {
			super(ime, adress, kapital);
		}
		@Override
		void takeMoneyFromShop() {
			//sell  items he dosn't have a shop
				int sells = rn.nextInt(this.stoka.size());
				int x = stoka.size();
				for(int i = 0; i<= sells; i++){
					int whithToSell = rn.nextInt(x);
					this.kapital += stoka.get(whithToSell).getCena()*30;
					Stoka a = stoka.get(whithToSell);
					prodadena.add(a);
					this.stoka.remove(whithToSell);
					x--;
				}
		}
	}
	
	static class Ednolichen extends Turgovec{
		HashSet<Dreben> dostavchici; //ne poveche ot 5
		IEdnolichen magazin;	
		public Ednolichen(String ime, String adress, double kapital) {
			super(ime, adress, kapital);
		}
		@Override
		void takeMoneyFromShop() {
			TurgovskiObekt b = (TurgovskiObekt) this.magazin;
			this.kapital += b.getMoney();
			b.setMoney(0);
		}
	}
	
	static class TurgovskaVeriga extends Turgovec{
		HashSet<Dostavchik> dostavchici;
		HashSet<IVeriga> magazini;	
		public TurgovskaVeriga(String ime, String adress, double kapital) {
			super(ime, adress, kapital);
			dostavchici = new HashSet<>();
			magazini = new HashSet<>();
		}
		@Override
		void takeMoneyFromShop() {
			for (IVeriga a : magazini) {
				TurgovskiObekt b = (TurgovskiObekt) a;
				this.kapital += b.getMoney();
				b.setMoney(0);
			}		
		}
	}
	
	String ime;
	String adress;
	double kapital;
	Random rn = new Random();
		Turgovec(String ime, String adress, double kapital){
			this.ime = ime;
			this.adress = adress;
			this.kapital = kapital;
		}
		
		int makePurches(){
			int randomint = rn.nextInt(10);
			return randomint;
		}
		
		boolean takeItems(double cena){
			boolean success = false;
			if(cena <= this.kapital/2){
				this.kapital -= cena;
				success = true;
			}
			return success;
			
		}
		
		abstract void takeMoneyFromShop();	
}
