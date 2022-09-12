//Mohammad hlhwly-1191413
//Star Class 
public class Truck extends Vehicle {
	//var class Truck
    private int NumberOfSeats;
    private boolean airConditioningOn = false;
    private int power;

    /** Return Power */
    public int getPower() {
        return power;
    }
    /** set Power */
    public void setPower(int power) {
        this.power = power;
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

    @Override
    public double costFor100Km() {
    	// TODO Auto-generated method stub
		double costFor100Km ;
//		 costFor100Km = 0.0;
//	        if(this.airConditionON){
//	            costFor100Km = .2 * (((100 / 20) / 1.6) * 3);
//	        }else{
//	            costFor100Km = (((100 / 20) / 1.6) * 3);
//	        }
	        
			double Thepriceoffuel = PetroleumType.getGasolinePrice();
			// 0.8 in Minivan
			double fuelConsumption = (this.airConditioningOn)?
					(this.fuelConsumption*0.8): this.fuelConsumption;
			costFor100Km = (100 / fuelConsumption) * Thepriceoffuel;
			return costFor100Km;
        
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




}

