package composite;
import java.util.ArrayList;

public class Composite {
	abstract class Donnée{
		int taille;
		abstract int taille();
	}
	class Fichier extends Donnée{
		Fichier(int i){
			taille = i;
		}
		int taille() {
			return taille;
		}
	}
	class Répertoire extends Donnée{
		ArrayList<Donnée> d = new ArrayList<>();
		void add(Donnée f) {
			this.d.add(f);
		}
		int taille() {
			int sum = 0;
			for(int i = 0; i < d.size(); i++)
				sum = sum + d.get(i).taille();
			
			return sum;
		}
}

Répertoire r1, r2, r3, r4;
Fichier f1, f2, f3, f4,f5;
void createPattern() {
	r1 = new Répertoire();
	f1 = new Fichier(2);
	r1.add(f1);
	

	r2 = new Répertoire();
	f2 = new Fichier(8);
	f3 = new Fichier(5);
	r2.add(f3);
	r2.add(f2);
	
	r1.add(r2);
	
	r3 = new Répertoire();
	f4 = new Fichier(6);
	r3.add(f4);
	
	r4= new Répertoire();
	f5 = new Fichier(10);
	r4.add(f5);
	
	r3.add(r4);
}
public static void main(String[] args) {
	Composite cp = new Composite();
	cp.createPattern();
	
	System.out.println("Taille du premier répertoire: " + cp.r1.taille());
	System.out.println("Taille du 2éme répertoire: " + cp.r2.taille());
	System.out.println("Taille du 3éme repértoire " + cp.r3.taille());
	System.out.println("Taille du 4éme répertoire: " + cp.r4.taille());

}
}
