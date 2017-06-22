import java.io.Serializable;
import java.util.ArrayList;
/**
  * SENG2011 Project Fine Food Finder
  * @author Daniel Al Mouiee
  * OutletAccount class 
  */
public class OutletAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String username;
	protected String password;
	protected int id;
	protected String name;
	protected int streetNum;
	protected String street;
	protected String suburb;
	protected int postcode;
	protected float ar;
	protected String descrip;
	protected String scenrey;
	protected float ap;
	protected int numRatings;
	protected ArrayList<Review> reviews;
	
	public OutletAccount(String username, String password, int id, String name , int streetNum, String street,
			String suburb, int postcode, float ar, String descrip,String scenrey, float ap, ArrayList<Review> reviews)
	{
		this.username = username;
		this.password = password;
		this.id = id;
		this.name  = name;
		this.streetNum = streetNum;
		this.street = street;
		this.suburb = suburb;
		this.postcode = postcode;
		this.ar = ar;
		this.descrip = descrip;
		this.scenrey = scenrey;
		this.ap = ap;
        this.numRatings = 0;
		this.reviews = new ArrayList<Review>();
	}
    public void incNumRatings() {
        numRatings++;
    }
    public void setAr(float ar) {
        this.ar = ar;
    }
    public void setAp(float ap) {
        this.ap = ap;
    }
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
    public void setScenrey(String scenrey) {
        this.scenrey = scenrey;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getStreetNum()
	{
		return streetNum;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public String getSuburb()
	{
		return suburb;
	}
	
	public int getPostcode()
	{
		return postcode;
	}
	
	public String getDescrip()
	{
		return descrip;
	}
	
	public String getScenrey()
	{
		return scenrey;
	}
	
	public float getAR()
	{
		return ar;
	}
	
	public float getAP()
	{
		return ap;
	}
    public int getNumRatings() {
        return numRatings;
    }
}