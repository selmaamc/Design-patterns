
public class HexaObserver extends Observer {

	   public HexaObserver(Observable observable){
	      this.observable = observable;
	      this.observable.attach(this);
	   }

	   @Override
	   public void update() {
	      System.out.println( "Conversion en Hexadecimal: " + Integer.toHexString( observable.getState() ).toUpperCase() ); 
	   }
}
