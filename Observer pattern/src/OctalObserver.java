
public class OctalObserver extends Observer {

	   public OctalObserver(Observable observable){
	      this.observable = observable;
	      this.observable.attach(this);
	   }

	   @Override
	   public void update() {
	     System.out.println( "Conversion en octal: " + Integer.toOctalString( observable.getState() ) ); 
	   }
}
