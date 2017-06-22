import java.util.ArrayList;
/**
 * SENG2011 Project Fine Food Finder
 * @author Daniel Al Mouiee
 * Outlet Profile class 
 */ 
public class OutletProfile {
	 private String name;
	 private String suburb;
	 private String streetName;
	 private int streetNum;
	 private float avgRating;
	 private String description;
	 private String scenrey;
	 private String foodGenre;
	 private int avgPrice;
	 private ArrayList<Review> reviews;
	 public OutletProfile(String name, String suburb, String streetName,
			 int streetNum, float avgRating, String description, String scenrey,
			 String foodGenre, int avgPrice, ArrayList<Review> reviews)
	 {
		 this.name = name;
		 this.suburb = suburb;
		 this.streetName = streetName;
		 this.streetNum = streetNum;
		 this.avgRating = avgRating;
		 this.description = description;
		 this.scenrey = scenrey;
		 this.foodGenre = foodGenre;
		 this.avgPrice = avgPrice;
		 this.reviews = reviews;
	 }
	 
	 public String getName()
	 {
		 return name;
	 }
	 
	 public String getSuburb()
	 {
		 return suburb;
	 }
	 
	 public String getStreetName()
	 {
		 return streetName;
	 }
	 
	 public int getStreetNum()
	 {
		 return streetNum;
	 }
	 
	 public float getAvgRating()
	 {
		 return avgRating;
	 }
	 
	 public String getDescription()
	 {
		 return description;
	 }
	 
	 public String getScenry()
	 {
		 return scenrey;
	 }
	 
	 public String getFoodGenre()
	 {
		 return foodGenre;
	 }
	  
	 public int getAvgPrice()
	 {
		 return avgPrice;
	 }
	 
	 public ArrayList<Review> getReviews()
	 {
		 return reviews;
	 }
}