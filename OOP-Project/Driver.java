
public class Driver extends Person{
	int salary;
	City currentLocation;
	boolean driving;
	Driver(String name, City currentLocation)
	{
		super(name);
		this.currentLocation = currentLocation;
	}
	public void setCurrentLocation(City c)
	{
		this.currentLocation = c;
	}
	public String toString()
	{
		return "driver " + name;
	}
}
