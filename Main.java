package shops;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rn = new Random();
		String[] names = {"Dostavchik1", "Dostavchik2", "Dostavchik3", "Dostavchik4",
						"Dostavchik5", "Dostavchik6", "Dostavchik7", "Dostavchik8", 
						"Dostavchik9", "Dostavchik10","Dostavchik11", "Dostavchik12"};
		
		ArrayList<Dostavchik> dostavchicite = new ArrayList<>();
		for(int i =0; i <=10; i++){
			boolean x = rn.nextBoolean();
			if(x){
				dostavchicite.add(new Dostavchik.Edur(names[rn.nextInt(names.length)], "Pernik", "6 - 18"));	
			}
			dostavchicite.add(new Dostavchik.Dreben(names[rn.nextInt(names.length)], "Pernik", "6 - 18"));	
		}
		
		ArrayList<TurgovskiObekt> obekti = new ArrayList<>();
		for(int i =0; i <=20; i++){
			int randomint = rn.nextInt(3);	
			switch (randomint) {
			case 1:
				obekti.add(new TurgovskiObekt.Sergiq("Sofiq", "8 - 19"));
				break;
			case 2:
				obekti.add(new TurgovskiObekt.Butka("Sofiq", "8 - 20"));
				break;
			default:
				obekti.add(new TurgovskiObekt.Magazin("Sofiq", "9 - 22"));
				break;
			}
		}
		
		Turgovec.Ambulanten turgovec1 = new Turgovec.Ambulanten("Pesho", "bitaka", 100);
		Turgovec.Ednolichen turgovec2 = new Turgovec.Ednolichen("123", "Sofiq", 500);
		Turgovec.TurgovskaVeriga veriga = new Turgovec.TurgovskaVeriga("Verigata na Mariq", "Sofiq", 3000);
		
		
		//time is up... 
	}
}
