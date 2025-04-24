
public class City {
	String name;
	int distance;
	Region region;
	City(String name, int distance)
	{
		this.name = name;
		this.distance = distance;
	}
	public String toString()
	{
		return name;
	}
	public void setRegion(Region r)
	{
		this.region = r;
	}
}
