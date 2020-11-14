
public class MainClass {
	 public static void main(String[] args) {
		 Observable observable = new Observable();

	      new HexaObserver(observable);
	      new OctalObserver(observable);
	      new BinaryObserver(observable);

	      System.out.println("Premier �tat: 15");	
	      observable.setState(15);
	      System.out.println("Second �tat: 10");	
	      observable.setState(10);
	   }
}
