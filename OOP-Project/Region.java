import java.util.ArrayList;

public class Region {
	String name;
	ArrayList<City> cities = new ArrayList<>();
	Region(String name)
	{
		this.name = name;
	}
	public City getCity(String c)
	{
		for (City city : cities)
		{
			if (city.name.equals(c))
			{
				return city;
			}
		}
		return null;
	}
	public void addCity(City c)
	{
		c.region = this;
		cities.add(c);
	}
}
