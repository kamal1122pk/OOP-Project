
public class MyThread extends Thread {
	Region r;
	City destination;
	Driver driver;
	Truck truck;
	MyThread(Region r, City destination, Driver driver, Truck truck)
	{
		this.r = r;
		this.driver = driver;
		this.truck = truck;
		if(!r.cities.contains(destination))
		{
			throw new IllegalArgumentException("Enter a valid destination");
		}
		else
		{
			this.destination = destination;
		}
	}
	public void run()
	{
		if (r.cities.indexOf(driver.currentLocation) > r.cities.indexOf(destination))
		{
			for(int i = r.cities.indexOf(driver.currentLocation); i >= r.cities.indexOf(destination); i--)
			{
				driving(i);
			}
		}
		else
		{
			for(int i = r.cities.indexOf(driver.currentLocation); i <= r.cities.indexOf(destination); i++)
			{
				driving(i);
			}
		}
	}
	public void driving(int i)
	{
		try {
			driver.currentLocation = r.cities.get(i);
			truck.currentLocation = r.cities.get(i);
			if (truck.toPrint)
			{
				System.out.println("Current Location: " + driver.currentLocation + " of " + driver);
			}
			Thread.sleep(r.cities.get(i).distance);
		}
		catch(InterruptedException e)
		{
			System.out.println("Thread Interrupted");
		}
	}
}
