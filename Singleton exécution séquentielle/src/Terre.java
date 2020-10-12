
public class Terre {
	
	private static Terre obj;
	private long age;
	private long population;
	private Terre() {}
	
    public static synchronized Terre getInstance()
	{
	if (obj==null)
	obj = new Terre();
	return obj;
	}
    public long getAge() {
		return age;
    }

    public long getPopulation() {
		return population;
    }
    

}
