import java.io.Serializable;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.Calendar;
/**
 * SENG2011 Project Fine Food Finder
 * @author Daniel Al Mouiee
 * Customer class
 * BUDDY-GROUPS-REVIEWS
 */
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String username;
	protected String password;
	protected String firstname;
	protected String surname;
	protected int age;
	protected String suburb;
	protected int postcode;
	protected String cusinePreference;
	protected String status;
	protected int XID;
	protected ArrayList<Review> reviews;
	
	public Customer(String username, String password, String surname, String firstname,
			int age, String suburb, int postcode, int XID, String cusinePreference, String status,
			ArrayList<Review> reviews)
	{
		this.username = username;
		this.password = password;
		this.surname = surname;
		this.firstname = firstname;
		this.age = age;
		this.suburb = suburb;
		this.postcode = postcode;
		this.XID = XID;
		this.cusinePreference = cusinePreference;
		this.status = status;
		this.reviews = new ArrayList<Review>();
	}
	
	public String getUsername()
	{
		return username;
	}
	
	protected String getPassword()
	{
		return password;
	}
	
	public String getFirstName()
	{
		return firstname;
	}
	
	public String getLastName()
	{
		return surname;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getSuburb()
	{
		return suburb;
	}
	
	public int getPostcode()
	{
		return postcode;
	}
	
	public int getXID()
	{
		return XID;
	}
	
	public String getCusinePreference()
	{
		return cusinePreference;
	}
	
	public String getStatus()
	{
		return status;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setCusinePreference(String cusinePreference) {
		this.cusinePreference = cusinePreference;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}