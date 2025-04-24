
public class Truck{
	Company company;
	int numberPlate; 
	City currentLocation;
	Region r;
	Driver driver;
	boolean toPrint = false;
	Truck(Company company, int numberPlate, City c)
	{
		this.company = company;
		this.numberPlate = numberPlate;
		this.r = c.region;
		this.currentLocation = c;
	}
	public void startDrive(City destination)
	{
		if (currentLocation != driver.currentLocation)
		{
			throw new IllegalArgumentException("Driver out of city");
		}
		try {
			MyThread t = new MyThread(r, destination, driver, this);
			t.start();
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("ENTER A VALID DESTINATION");
		}
	}
	public void setCurrentLocation(City c)
	{
		this.currentLocation = c;
	}
	public void setDriver(Driver d)
	{
		this.driver = d;
	}
	public void trackTruck()
	{
		this.toPrint = true;
	}
	public void unTrackTruck()
	{
		this.toPrint = false;
	}
}
