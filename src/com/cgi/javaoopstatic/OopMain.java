package com.cgi.javaoopstatic;

// static import prevents class call
import static java.lang.System.out;
import static com.cgi.javaoopstatic.ConversionHelper.fromNauticalMileToMeters;

public class OopMain {
    public static void main(String[] args) {

        int altitudeInFeet = 28000;
        double distanceInNauticalMile = 10;

        int altitudeInFlyLevel = ConversionHelper.fromFeetToFlyLevel(altitudeInFeet);
        out.println(altitudeInFeet + " ft -> " + altitudeInFlyLevel + " FL");

        double distanceInMeters = fromNauticalMileToMeters(10); // import from static, no need to call class name
        out.println(distanceInNauticalMile + " NM -> " + distanceInMeters + " m");

        // use the Distance static nested class to create an instance in order to access its instance members
        Calculators.Distance d = new Calculators.Distance(3, 3, 7, 7);
        out.println("Distance: " + d.calculate());

        // use a static method directly without having to instantiate an object
        out.println(Calculators.calculateDistance(3,3,7,7));
    }
}
