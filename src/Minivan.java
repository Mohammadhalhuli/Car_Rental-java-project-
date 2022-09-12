//Mohammad hlhwly-1191413
//Star Class 
public class Minivan extends Vehicle {
	//Var class car
    private int NumberOfSeats;
    private boolean airConditioningOn = false;//False, because usually the air conditioner is closed
    private boolean hasAutoDoors;
    /** Default constructor */
    Minivan(){
   	 
    }
     /** parameterized constructor*/
//    public Minivan(String modeName, String modelNo, String brand, String engineType, double tankSize,
//			double fuelConsumption, Owner owner, PetroleumType petroleumType, int numberOfSeats, boolean airConditionON,
//			boolean hasAutoDoors) {
//		super(modeName, modelNo, brand, engineType, tankSize, fuelConsumption, owner, petroleumType);
//		NumberOfSeats = numberOfSeats;
//		this.airConditioningOn = airConditioningOn;
//		this.hasAutoDoors = hasAutoDoors;
//	}
    /** Return isHasAutoDoors*/
    public boolean isHasAutoDoors() {
        return hasAutoDoors;
    }
    /** set isHasAutoDoors*/
    public void setHasAutoDoors(boolean hasAutoDoors) {
        this.hasAutoDoors = hasAutoDoors;
    }
    /** Return NumberOfSeats*/
    @Override
    public int getNumberOfSeats() {
        return NumberOfSeats;
    }

    /** set NumberOfSeats*/
    @Override
    public void setNumberOfSeats(int numberOfSeats) {
        NumberOfSeats = numberOfSeats;
    }
    
    /*
     * This method, connected through the abstract, turns on the air conditioner
     */
    @Override
    public void setAirConditionOn() {
    	// TODO Auto-generated method stub
        this.airConditioningOn = true;
    }

    /*
     * This method, connected through the abstract, turns oF the air conditioner
     */
    @Override
    public void setAirConditionOf() {
    	// TODO Auto-generated method stub
        this.airConditioningOn = false;
    }

    @Override
    public double costFor100Km() {	
    	// TODO Auto-generated method stub
    			 double costFor100Km ;
//    			 costFor100Km = 0.0;
//    		        if(this.airConditionON){
//    		            costFor100Km = .2 * (((100 / 20) / 1.6) * 3);
//    		        }else{
//    		            costFor100Km = (((100 / 20) / 1.6) * 3);
//    		        }
    		        
    				double Thepriceoffuel = PetroleumType.getGasolinePrice();
    				// 1.20 in Minivan
    				double Consumption ;
    				Consumption = (this.airConditioningOn)? (this.fuelConsumption*1.20): this.fuelConsumption;
    				costFor100Km = (100 / Consumption) * Thepriceoffuel;
    				return costFor100Km;
    }

}
