package composite;

import java.util.ArrayList;

public class Composite {
	abstract class Donn�e{
		int taille;
		abstract int taille();
	}
	class Fichier extends Donn�e{
		Fichier(int i){
			taille = i;
		}
		int taille() {
			return taille;
		}
	}
	class R�pertoire extends Donn�e{
		ArrayList<Donn�e> d = new ArrayList<>();
		void add(Donn�e f) {
			this.d.add(f);
		}
		int taille() {
			int sum = 0;
			for(int i = 0; i < d.size(); i++)
				sum = sum + d.get(i).taille();
			
			return sum;
		}
}

R�pertoire r1, r2, r3, r4;
Fichier f1, f2, f3, f4,f5;
void createPattern() {
	r1 = new R�pertoire();
	f1 = new Fichier(2);
	r1.add(f1);
	

	r2 = new R�pertoire();
	f2 = new Fichier(8);
	f3 = new Fichier(5);
	r2.add(f3);
	r2.add(f2);
	
	r1.add(r2);
	
	r3 = new R�pertoire();
	f4 = new Fichier(6);
	r3.add(f4);
	
	r4= new R�pertoire();
	f5 = new Fichier(10);
	r4.add(f5);
	
	r3.add(r4);
}
public static void main(String[] args) {
	Composite cp = new Composite();
	cp.createPattern();
	
	System.out.println("Taille du premier r�pertoire: " + cp.r1.taille());
	System.out.println("Taille du 2�me r�pertoire: " + cp.r2.taille());
	System.out.println("Taille du 3�me rep�rtoire " + cp.r3.taille());
	System.out.println("Taille du 4�me r�pertoire: " + cp.r4.taille());

}
}
