import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {
	String name;
	Person owner;
	ArrayList<Truck> trucks = new ArrayList<>();
	ArrayList<Driver> drivers = new ArrayList<>();
	ArrayList<Region> regions = new ArrayList<>();
	public Region getRegion(String r)
	{
		for (Region region : regions)
		{
			if (region.name.equals(r))
			{
				return region;
			}
		}
		return null;
	}
	public Driver getDriver(String d)
	{
		for (Driver driver : drivers)
		{
			if (driver.name.equals(d))
			{
				return driver;
			}
		}
		return null;
	}
	public Truck getTruck(int t)
	{
		for (Truck truck : trucks)
		{
			if(truck.numberPlate == t)
			{
				return truck;
			}
		}
		return null;
	} 
	public void addTruck(Truck truck)
	{
		truck.company = this;
		trucks.add(truck);
	}
	public void trackAllTrucks()
	{
		for (Truck truck : trucks)
		{
			truck.toPrint = true;
		}
	}
	public static void main(String[] args)
	{
		//Region r =  new Region();
		Company c = new Company();
		//Driver driver1 = new Driver("Kamal", r.cities.get(0));
		//Truck truck1 = new Truck("OIL", 10000, driver1, r);
		//c.trucks.add(truck1);
		//truck1.startDrive(r.cities.get(2));
		//c.menu();
		Region region = new Region("Pakistan");
		c.regions.add(region);
		c.getRegion("Pakistan").addCity(new City("Hyderabad", 2000));
		c.getRegion("Pakistan").addCity(new City("Hala", 3000));
		c.getRegion("Pakistan").addCity(new City("Nawabshah", 4000));
		c.getRegion("Pakistan").addCity(new City("Moro", 3000));
		c.getRegion("Pakistan").addCity(new City("Dadu", 3000));
		c.getRegion("Pakistan").addCity(new City("Khairpur", 3000));
		c.getRegion("Pakistan").addCity(new City("Rohri", 4000));
		c.getRegion("Pakistan").addCity(new City("Sukker", 3000));
		c.getRegion("Pakistan").addCity(new City("Rahimyar Khan", 3000));
		c.getRegion("Pakistan").addCity(new City("Sadiqabad", 3000));
		Driver driver = new Driver("Adil", c.getRegion("Pakistan").getCity("Rohri"));
		c.drivers.add(driver);
		Truck truck = new Truck(c, 10101, c.getRegion("Pakistan").getCity("Hyderabad"));
		c.addTruck(truck);
		c.getTruck(10101).setDriver(driver);
		try {
			c.getTruck(10101).startDrive(c.getRegion("Pakistan").getCity("Sadiqabad"));
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
		c.getTruck(10101).trackTruck();
	}
}
 