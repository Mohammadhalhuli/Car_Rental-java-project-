/*
 * 
 * mohammad -1191413
 */

//import java.util.Date;
/*
 * Star class
 */
public class Owner implements Cloneable{
	//private Even he could not take it to via Method
	////variable class Owner 
	private String Name ;
	private String PIN;
	private String Address;
	private String MobileNO;
	private java.util.Date DateOfBrith;

	 /** Default constructor */
    public Owner() {

    }
      /** parameterized constructor*/
//    public Owner(String name, String pIN, String address, String mobileNO, Date dateOfBrith) {
//		super();
//		Name = name;
//		PIN = pIN;
//		Address = address;
//		MobileNO = mobileNO;
//		DateOfBrith = dateOfBrith;
//	}
//   
    /*
     * Connected with a one-to-one class
     * It is one to one
     */
    public Owner(String name) {
    	//super();
    	Name = name;
    }
    /** Return Name */
	public String getName() {
		return Name;
	}
	/** set Name */
	public void setName(String name) {
		Name = name;
	}
	/** Return PIN */
	public String getPIN() {
		return PIN;
	}
	/** Set PIN */
	public void setPIN(String pIN) {
		PIN = pIN;
	}
	/** Return Address */
	public String getAddress() {
		return Address;
	}
	/** set Address */
	public void setAddress(String address) {
		Address = address;
	}
	/** Return MobileNO */
	public String getMobileNO() {
		return MobileNO;
	}
	/** Set MobileNO */
	public void setMobileNO(String mobileNO) {
		MobileNO = mobileNO;
	}
	/** Return Date */
	public java.util.Date getDateOfBrith() {
		return DateOfBrith;
	}

	/*
	 * Override the clone () method of the object class so that no error occurs
	 */
	@Override
    public Object clone() throws CloneNotSupportedException {
        Owner oclone = (Owner)super.clone();
        return  oclone;
    }
	@Override
	public String toString() {
		return "Owner [Name=" + Name + ", PIN=" + PIN + ", Address=" + Address + ", MobileNO=" + MobileNO
				+ ", DateOfBrith=" + DateOfBrith + "]";
	}
	
}
