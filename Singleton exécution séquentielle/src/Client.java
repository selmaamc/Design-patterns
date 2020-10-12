
public class Client {
	public static void main(String args[]){
		Terre terre = Terre.getInstance();
        System.out.println("La terre a environ"+ terre.getAge());

        System.out.println("La terre est habitée par environ " + terre.getPopulation() + "personnes.");
    }
}
