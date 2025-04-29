package com.company;

public class Main {

    public static void main(String[] args) {
        // Create a new class VipCustomer
        // it should have 3 fields name, credit limit, and email address.
        // create 3 constructors
        // 1st constructor empty should call the constructor with 3 parameters with default values
        // 2nd constructor should pass on the 2 values it receives and add a default value for the 3rd
        // 3rd constructor should save all fields.
        // create getters only for this using code generation of intellij as setters wont be needed
        // test and confirm it works.



        VipCustomer ankit=new VipCustomer();
        System.out.println("name : " +ankit.getName()+ " , creditlimit : " +ankit.getCreditlimit()+ " ,email : " +ankit.getEmail());

        System.out.println("");

        VipCustomer suresh=new VipCustomer("suresh",77);
        System.out.println("name : " +suresh.getName()+ " , creditlimit : " +suresh.getCreditlimit()+ " ,email : " +suresh.getEmail());

        System.out.println("");

        VipCustomer s=new VipCustomer("s",778,"sur@gm");
        System.out.println("name : " +s.getName()+ " , creditlimit : " +s.getCreditlimit()+ " ,email : " +s.getEmail());

    }


}
