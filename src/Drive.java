//Mohammad - 1191413
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
//Star class
public class Drive {
	//Array list 
    static ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
    //Method main and Exception
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
    	
//    	Vehicle c = new Car();
//	    c.brand = "Mercades";
//	    Vehicle c1 = (Car)c.clone();
//		System.out.println(c.brand);
//		System.out.println(c1.brand);
//		Vehicle m = new Minivan();
//	    c.brand = "Mercades";
//	    Vehicle m1 = (Minivan)m.clone();
//		System.out.println(m.brand);
//		System.out.println(m1.brand);
//		c1.brand = "Cheverolet";
//		System.out.println(m1.brand);
//		
        int choice;
        Scanner in = new Scanner(System.in); //Definition of Scanner
        PetroleumType petrol = new PetroleumType();//Definition of PetroleumType
        /*
         *while loop it is true until it is running continuously without stopping
         */
        while (true) {
        	
            System.out.println("--------------------------------------------");
            System.out.println("1. Read the data about objects from the file “inputdata.txt” and store them in Arraylist."
            		+ "\n2. Set prices of petroleum."
            		+ "\n3. Print sorted order Vehicles in an ascending order based on costFor100Km. "
            		+ "\n4. Print sorted order Vehicles in an ascending order based on owner name . "
            		+ "\n5. Print sorted order Vehicles in an descending order based on vehicle brand."
            		+ "\n6. Clone Vehicle without owner. (Ask user to choice one object for cloning from Arraylist, after Listing them to user )\r\n"
            		+ "7. Turn air-condition on\r\n"
            		+ "8. Write Output on the “output.txt” file after sort them. "
            		+ "\n9. Exit from System");;
            System.out.println("--------------------------------------------");
            choice = in.nextInt();//scanner in choice
            switch (choice) {
            //switch cases
                case 1 : {
                	 readFromFile(in, petrol);// call method readFromFile to Read data
//                    StringBuilder data = FileUtils.readFile("inputdata.txt");
//                    vehicles = stringToArrayList(data.toString());
//                    System.out.println(data);
                   System.out.println("data read ");
                   break;//Stop
                }
                case 2 : {
                    System.out.println("Enter Gasoline price: ");
                    double price1 = in.nextDouble(); //scan price1 
                    PetroleumType.setGasolinePrice(price1);
                    System.out.println("Enter Diesel price: ");
                    double price2 = in.nextDouble();  //scan price2
                    PetroleumType.setDieselPrice(price2);
                    for(Vehicle obj:vehicleList)
                    {
                   //     obj.costFor100Km(petrol);
                    }
                    System.out.println("the price have set");
                    break;//stop
                }
                case 3 : {
                    Collections.sort(vehicleList);
                    /*
                     *  method is present in java.util.Collections class. It is used to sort the elements present in the specified list of Collection in ascending order
                     */
                    showVehicles(vehicleList);// print vehicleList
                    //Collections.sort(vehicleList, new VehicleCostComparator());
                    System.out.println("Sorted List according to cost per 100km:");
                    //for (Vehicle obj : vehicleList) {
                   //         System.out.println(obj.getCostFor100Km());
                   // }
                    break;//stop
                }
                case 4 : {
//                    vehicles.sort(Vehicle.ownerNameComparator);
//                    showVehicles(vehicleList);
//                    System.out.println("");
                	 Collections.sort(vehicleList);
                	 /*
                      *  method is present in java.util.Collections class. It is used to sort the elements present in the specified list of Collection in ascending order
                      */
                     System.out.println("Sorted List according to Owner name:");
                     /*
                      * for loop print vehicleList
                      */
                     for (Vehicle obj : vehicleList) {
                             System.out.println(obj.toString());//print in object
                             }
                    break;//stop
                }
                case 5 : {
                	 /*
                     *  method is present in java.util.Collections class. It is used to sort the elements present in the specified list of Collection in ascending order
                     */
                	vehicleList.sort(new Comparator<Vehicle>() {
                        @Override
                        public int compare(Vehicle o1, Vehicle o2) {
                            return o1.getBrand().compareTo(o2.getBrand());
                        }
                    });

                    showVehicles(vehicleList);//print in vehicleList
                    break;//stop
                }
                case 6 : {
                	try {
                    showVehicles(vehicleList);//in call vehicleList
                    System.out.println("select vehicle to clone: ");
                    int x= in.nextInt();//scan
                    while (true) {//while is true
                        if (x >= vehicleList.size()){//if staetment 
                            System.out.println("vehicle not exist!");
                            System.out.println("select vehicle to clone: ");
                            x = in.nextInt();//scann
                            continue; //Continuing on method
                        }
                        Vehicle vClone = (Vehicle) vehicleList.get(x).clone();
                        vehicleList.add(vClone);
                        System.out.println("vehicle was clones successfully");
                        showVehicles(vehicleList);//print(vehicleList) 
                        break;//stop

                    }
                }catch (Exception e) {
					System.out.println("error");
				}
                }
                case 7 : {
                	//for loop in print  vehicleList
                    for (Vehicle vehicle : vehicleList) {
                        vehicle.setAirConditionOn();
                    }
                    System.out.println("the air-conditioning have turned on successfully");
                    break;//stop
                }
                case 8 : {
                    StringBuilder output = new StringBuilder();//Definition of StringBuilder
                    for (Vehicle vehicle : vehicleList) {
                        output.append(vehicle.toString() + "\n");
                    }
                    FileUtils.writeFile(output, "output.txt");//Save in file 
                    System.out.println("data wrote to file successfully");
                    break;//stop
                }
                case 9 :{
                	System.out.println("Good bay");
                	System.exit(0);//exit in program
                	break;//stop
                }
                default : {
                    System.out.println("thanks for using the program");
                    System.exit(0);
                }
            }
        }
    }
    
   
    public static List<Vehicle> stringToArrayList(String data) {
        data = data.replaceAll("(\n)*", "\n");
        List<Vehicle> vehiclesList = new ArrayList<>();
        String[] vehicles = data.split("\n");
        try {//Exception
        	/**for loop print */
            for (String vehicle : vehicles) {
                if (vehicle.length() > 0) {
                    String[] vehicleData = vehicle.split(",");
                    Vehicle v;
                    if (vehicleData[0].equals("Car")) {
                        v = new Car();
                    } else if (vehicleData[0].equals("MiniVan")) {
                        v = new Minivan();
                    } else if (vehicleData[0].equals("Truck")) {
                        v = new Truck();
                    } else {
                        throw new IllegalArgumentException();
                    }

                    v.setModelName(vehicleData[1]);
                    // set the modul name at vehicleData" 1 "
                    v.setModelNo(vehicleData[2]);
                    // set the modul name at vehicleData" 2 "
                    v.setBrand(vehicleData[3]);
                    // set the modul name at vehicleData" 3 "
                    Owner owner = new Owner(vehicleData[4]); //new objct Owner
                    v.setOwner(owner);// set the Owner
                    v.setEngineType(vehicleData[5]);// set the Engine Type at vehicleData" 3 "
                    v.setTankSize(Double.parseDouble(vehicleData[6]));// set the Tank Size at vehicleData" 6 "
                    v.setFuelConsumption(Double.parseDouble(vehicleData[7]));// set the Fuel Consumption at vehicleData" 7 "
                    v.setNumberOfSeats(Integer.parseInt(vehicleData[8]));// set the Number Of Seats at vehicleData" 8 "
                    if (vehicleData.length > 9) { // if Stetmant 
                        if (vehicleData[8].equals("true")) {// if at vehicleData" 8 " = true
                            v.setAirConditionOn(); //set Air Condition On
                        }
                    }
                    vehiclesList.add(v);// array list in add v
                }
            }
        } catch (Exception e) {
        	System.out.println("in Error");
            e.printStackTrace();
        }
        /**Return vehiclesList*/
        return vehiclesList;
    }

    public static void showVehicles(List<Vehicle> vehicleList) throws IOException {
        System.out.println("Vehicles: ");
        int x = 0;
        /** for loop */
        for (Vehicle vehicle : vehicleList) {
            System.out.println(x + ". " + vehicle.toString()+"\n");
            x=x+1; //1+1+1+1+1...
        }
    }
 
   
 /***************
 ***************************
 *********************************
 *******************************************/

 private static void readFromFile(Scanner sc, PetroleumType petrol) throws FileNotFoundException {
 Scanner scan = new Scanner(new File("inputdata.txt"));
 	
 		while (scan.hasNext()) {

 			String lineOfString = scan.nextLine();
 			String[] arrLength = lineOfString.toString().split(",");

 			if (arrLength[0].equalsIgnoreCase("Car")) {
 				// Creating object "car"
 				Car car = new Car();
 				// set the modul name at index " 1 "
 				car.setModelName(arrLength[1].trim());
 				// set the ModelNO at index " 2 "
 				car.setModelNo(arrLength[2].trim());
 				// set the Brand at index " 3 "
 				car.setBrand(arrLength[3].trim());
 				// Creat object own of the Class Onwer
 				Owner own = new Owner();
 				// set the owner name at index 4
 				own.setName(arrLength[4].trim());
 				// Send the value of own
 				car.setOwner(own);
 				// Set the Tpye of Engine of the Car at index 5
 				car.setEngineType(arrLength[5].trim());
 				// Set the tunk size and convert it as Double using parseDouble
 				car.setTankSize(Double.parseDouble(arrLength[6].trim()));
 				// Set the fuelConsumption and convert it as Double using parseDouble
 				car.setFuelConsumption(Double.parseDouble(arrLength[7].trim()));
 				// Set the numberOfseats and convert it as int using parseInteger
 				car.setNumberOfSeats(Integer.parseInt(arrLength[8].trim()));
 				// add the object to array list
 				vehicleList.add(car);
 				
 			} else if (arrLength[0].equalsIgnoreCase("Minivan")) {
 				// Creating object "minivan"
 				Minivan minivan = new Minivan();
 				// set the modul name at index " 1 "
 				minivan.setModelName(arrLength[1].trim());
 				// set the ModelNO at index " 2 "
 				minivan.setModelNo(arrLength[2]);
 				// set the Brand at index " 3 "
 				minivan.setBrand(arrLength[3].trim());
 				// Creat object own of the Class Onwer
 				Owner own = new Owner();
 				// set the owner name at index 4
 				own.setName(arrLength[4].trim());
 				// Send the value of own
 				minivan.setOwner(own);
 				// Set the Tpye of Engine of the Car at index 5
 				minivan.setEngineType(arrLength[5].trim());
 				// Set the tunk size and convert it as Double using parseDouble
 				minivan.setTankSize(Double.parseDouble(arrLength[6].trim()));
 				// Set the fuelConsumption and convert it as Double using parseDouble
 				minivan.setFuelConsumption(Double.parseDouble(arrLength[7].trim()));
 				// Set the numberOfseats and convert it as int using parseInteger
 				minivan.setNumberOfSeats(Integer.parseInt(arrLength[8].trim()));
 				// Set the Auto Door and conver it as boolean value at index "9"
 				minivan.setHasAutoDoors(Boolean.valueOf(arrLength[9].trim()));
 				// add the object to array list
 				vehicleList.add(minivan);
 			}
 			else if (arrLength[0].equalsIgnoreCase("Truck")) {
 				// Creating object "truck"
 				Truck truck = new Truck();
 				// set the modul name at index " 1 "
 				truck.setModelName(arrLength[1].trim());
 				// set the ModelNO at index " 2 "
 				truck.setModelNo(arrLength[2].trim());
 				// set the Brand at index " 3 "
 				truck.setBrand(arrLength[3].trim());
 				// Creat object own of the Class Onwer
 				Owner owner = new Owner();
 				// set the owner name at index 4
 				owner.setName(arrLength[4].trim());
 				// Send the value of own
 				truck.setOwner(owner);
 				// Set the Type of Engine of the Car at index 5
 				truck.setEngineType(arrLength[5].trim());
 				// Set the tunk size and convert it as Double using parseDouble
 				truck.setTankSize(Double.parseDouble(arrLength[6].trim()));
 				// Set the fuelConsumption and convert it as Double using parseDouble
 				truck.setFuelConsumption(Double.parseDouble(arrLength[7].trim()));
 				// Set the numberOfseats and convert it as int using parseInteger
 				truck.setNumberOfSeats(Integer.parseInt(arrLength[8].trim()));
 				// Set the power and convert it as int using parseInteger
 				truck.setPower(Integer.parseInt(arrLength[9].trim()));
 				// add the object to array list
 				vehicleList.add(truck); 
 			}
 		}
 		System.out.println(vehicleList.size());
 		for (int i = 0; i < vehicleList.size(); i++) {
 			System.out.println(vehicleList.get(i));
 		}
 		scan.close();
 			
}
}
