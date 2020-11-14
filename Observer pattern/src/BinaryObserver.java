
public class BinaryObserver extends Observer {
	 public BinaryObserver(Observable observable){
	      this.observable = observable;
	      this.observable.attach(this);
	   }

	   @Override
	   public void update() {
	      System.out.println( "Conversion en binaire: " + Integer.toBinaryString( observable.getState() ) ); 
	   }
}
