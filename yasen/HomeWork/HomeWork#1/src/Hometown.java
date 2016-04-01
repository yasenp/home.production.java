import java.time.*;

/**
 * @author Yassen
 *
 */
public class Hometown {

	private String homeTown;

	/**
	 * @param ht 
	 * @param homeTown
	 */
	public Hometown(String ht) {

		this.setHomeTown(ht);
	}

	/**
	 * @return
	 */
	public String getHomeTown() {
		return homeTown;
	}

	/**
	 * @param homeTown
	 */
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public static void main(String[] args) {
		
		Hometown town = new Hometown("Sofia");
		String myHomeTown = town.getHomeTown();
		System.out.println("My hometown is: " + myHomeTown);
		
		town.setHomeTown("Varna");
		myHomeTown = town.getHomeTown();
		System.out.println("My hometown is: " + myHomeTown);
		
		
	}
	
}
