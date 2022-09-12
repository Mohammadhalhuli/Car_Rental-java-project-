//Mohammad 1191413
//Mohammad 1191413
import java.util.Comparator;

public abstract class Vehicle implements Comparable<Vehicle>, Cloneable {
	//Start in class
	//variable class
    protected String modelName;
    protected String modelNo;
    protected String brand;
    protected String engineType;
    protected double tankSize;
    protected double fuelConsumption;
    public Owner owner;
    private PetroleumType petroleumType;
    
    /** Default constructor */
    Vehicle(){
    	
    }
    /** parameterized constructor*/
    public Vehicle(String modelName, String modelNo, String brand, String engineType, double tankSize,
			double fuelConsumption, Owner owner, PetroleumType petroleumType) {
		super();
		this.modelName = modelName;
		this.modelNo = modelNo;
		this.brand = brand;
		this.engineType = engineType;
		this.tankSize = tankSize;
		this.fuelConsumption = fuelConsumption;
		this.owner = owner;
		this.petroleumType = petroleumType;
	}

	public static Comparator<Vehicle> ownerNameComparator = new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return -(o1.getOwner().getName().compareTo(o2.getOwner().getName()));
            }
    };
    /** Return movableDistance */
    public double movableDistance() {
        return this.tankSize * this.fuelConsumption;
    }
    
    public double MovableDistance()
    {
        return fuelConsumption * tankSize;		//total distance used by the fuel
    }
    /**
     * in abstract class
     * */
    public abstract double costFor100Km();

    public abstract void setAirConditionOn();

    public abstract void setAirConditionOf();

    public abstract void setNumberOfSeats(int numberOfSeats);

    public abstract int getNumberOfSeats();

    /*Return ModelName**/
    public String getModelName() {
        return modelName;
    }

    /**set modelname**/
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /*Return ModelNo**/
    public String getModelNo() {
        return modelNo;
    }

    /**set modelno**/
    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    /*Return Brand**/
    public String getBrand() {
        return brand;
    }
    /**set Brand**/
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /*Return EngineType**/
    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
    	/*
    	 * Compare fuel accepts vehicles
    	 */
        try {
        	/*
        	 * And the code allowed for a car
        	 */
            if (this instanceof Car) {
                if (!(engineType.equals("Gasoline") || engineType.equals("Hybrid"))) {
                    throw new IllegalArgumentException();
                }
                /*
                 * And the code allowed for a Truck
                 */
            } else if (this instanceof Truck) {
                if (!engineType.equals("Diesel")) {
                    throw new IllegalArgumentException();
                }
                /*
                 * And the code allowed for a Minivan
                 */
            } else if (this instanceof Minivan) {
                if (!(engineType.equals("Gasoline") || engineType.equals("Diesel"))) {
                    throw new IllegalArgumentException();
                }
            }
            /*
             * If an error occurs, the program continues
             */
        } catch (IllegalArgumentException e) {
            System.out.println("error in the gas type format");
        }
        this.engineType = engineType;
    }
    /*Return TankSize**/
    public double getTankSize() {
        return tankSize;
    }
    /*set TankSize**/
    public void setTankSize(double tankSize) {
        this.tankSize = tankSize;
    }
    /*Return FuelConsumption**/
    public double getFuelConsumption() {
        return fuelConsumption;
    }
    /*set FuelConsumption**/
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    /*Return Owner**/
    public Owner getOwner() {
        return owner;
    }
    /*set Owner**/
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    //compareto
    @Override
    public int compareTo(Vehicle v) {
        return Double.compare(this.costFor100Km(), v.costFor100Km());
    }
    
    /*
     *  Overriding clone() method of Object class
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Vehicle v = (Vehicle) super.clone();
        v.owner = null;
        return v;
    }
	@Override
	public String toString() {
		 /*
	     * Print everything in class
	     */
		return "Vehicle [modelName=" + modelName + ", modelNo=" + modelNo + ", brand=" + brand + ", engineType="
				+ engineType + ", tankSize=" + tankSize + ", fuelConsumption=" + fuelConsumption + ", owner=" + owner
				+ ", petroleumType=" + petroleumType + "]";
	}
    
   
   
}

