import java.io.Serializable;
public class Review implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String review;
	
	public Review(String review)
	{
		this.review = review;
	}
	
	public String printReview()
	{
		return review;
	}
}