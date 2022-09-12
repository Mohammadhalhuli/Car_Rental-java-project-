
//Mohammad -1191413
//Start in class PetroleumType
public class PetroleumType {
	//var in final 
    public static final int DIESEL = 1;
    public static final int GASOLINE = 2;

    private static double gasolinePrice = 5.23 ;
    //private double gasolinePrice;
    private static double dieselPrice = 4.02;
    //private double dieselPrice ;

    /** Default constructor */
	PetroleumType(){
		
	}

	
	/** parameterized constructor*/
//	public PetroleumType(double gasolinePrice, double dieselPrice) {
//		//super();
//		this.gasolinePrice = gasolinePrice;
//		this.dieselPrice = dieselPrice;
//	}
	/** Return linePrice */
    public static double getGasolinePrice() {
        return gasolinePrice;
    }
    /** Set linePrice */
    public static void setGasolinePrice(double gasolinePrice) {
        PetroleumType.gasolinePrice = gasolinePrice;
    }
    /** Return DieselPrice */
    public static double getDieselPrice() {
        return dieselPrice;
    }
    /** Set DieselPrice */
    public static void setDieselPrice(double dieselPrice) {
        PetroleumType.dieselPrice = dieselPrice;
    }
//	Return in class
//	@Override
//	public String toString() {
//		return "PetroleumType [DIESEL=" + DIESEL + ", GASOLINE=" + GASOLINE + ", gasolinePrice=" + gasolinePrice
//				+ ", dieselPrice=" + dieselPrice + "]";
//	}

}
