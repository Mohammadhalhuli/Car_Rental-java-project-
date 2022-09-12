
//Mohammad hlhwly-1191413
//Star Class 
public class Car extends Vehicle {
	//Var class car 
    private int NumberOfSeats;
    private boolean airConditioningOn = false;//False, because usually the air conditioner is closed
    private PetroleumType type;
    /** Default constructor */
    Car(){
    	
    }
    /** parameterized constructor*/
//	public Car(String modeName, String modelNo, String brand, String engineType, double tankSize,
//			double fuelConsumption, Owner owner, PetroleumType petroleumType, int numberOfSeats, boolean airConditionON,
//			PetroleumType type) {
//		super(modeName, modelNo, brand, engineType, tankSize, fuelConsumption, owner, petroleumType);
//		NumberOfSeats = numberOfSeats;
//		this.airConditionON = airConditionON;
//		this.type = type;
//	}
    /** Return NumberOfSeats */
    @Override
    public int getNumberOfSeats() {
        return NumberOfSeats;
    }
    /** Set NumberOfSeats */
    @Override
    public void setNumberOfSeats(int numberOfSeats) {
        NumberOfSeats = numberOfSeats;
    }
    /** Return Type */
	public PetroleumType getType() {
		return type;
	}

	/** Set Type */
	public void setType(PetroleumType type) {
		this.type = type;
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
    			/*
    			 * Calculation process for the amount extravagant
    			 */
    			double costFor100km;
//    			type = null;
//    			
//    			if(this.airConditionON) {
//    	            fuelConsumption = fuelConsumption+(fuelConsumption*0.1);
//    	        }
//    			costPer100Km = 0.0;
//    	        
//    	        if(this.airConditionOn){
//    	            costPer100Km = .1 * (((100 / 20) / 1.6) * 3);
//    	        }else{
//    	            costPer100Km = (((100 / 20) / 1.6) * 3);
//    	        }
    			double Thepriceoffuel = PetroleumType.getGasolinePrice();
    		    double Consumption;
    		    Consumption = (this.airConditioningOn)? (this.fuelConsumption*1.10): this.fuelConsumption;
    		    costFor100km = (100/Consumption) * Thepriceoffuel;
    	        return costFor100km ;

    }
    @Override
	public String toString() {
		return  super.toString() + " [numberOfSeats=" + NumberOfSeats + ", airConditionON=" +
				NumberOfSeats + " cost for 100 km "+ costFor100Km();
	}
}
