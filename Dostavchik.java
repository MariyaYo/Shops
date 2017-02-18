package shops;

import java.util.ArrayList;
import java.util.Random;

public abstract class Dostavchik {
	static class Edur extends Dostavchik{
		Edur(String ime, String adress, String rabotnoVreme){
			super(ime, adress, rabotnoVreme);
			this.otstspka = 0;
		}	
	}
	
	static class Dreben extends Dostavchik{
		Dreben(String ime, String adress, String rabotnoVreme){
			super(ime, adress, rabotnoVreme);
			this.otstspka = 0;
		}	
	}
	
	public class Stoka {
		private String vid;
		private double cena;
		
		Stoka(String vid, double cena){
			this.vid = vid;
			this.cena = cena;	
		}

		public double getCena() {
			return cena;
		}
		
	}

	
	private String ime;
	private String adress;
	private String rabotnoVreme;
	protected int otstspka;
	private ArrayList<Stoka> stoka;
	private double obshtaCena = 0;
	Random rn = new Random();
	
	Dostavchik(String ime, String adress, String rabotnoVreme){
		this.ime = ime;
		this.adress = adress;
		this.rabotnoVreme = rabotnoVreme;
		this.stoka = new ArrayList<>();
	}
	
	void NapraviStokata(int kolicestvo){
		this.stoka.clear();
		this.obshtaCena = 0;
		for(int i=0; i < kolicestvo; i++){
			double proizvolnaCena = rn.nextDouble() + (rn.nextInt(9)+5);
			this.stoka.add(new Stoka("Vaza", proizvolnaCena));
			obshtaCena += this.stoka.get(i).cena;
		}	
	}
	
	double prodaiNaTurgoveca(boolean otstupka){
		if(otstupka){
			this.obshtaCena -= this.obshtaCena*0.15;
		}
		return obshtaCena;
	}
}
