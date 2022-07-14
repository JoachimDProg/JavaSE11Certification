package com.cgi.javaoopstatic;

public final class ConversionHelper {
    // initialise static variable directly
    // private static final int METERS_IN_ONE_NM = 1852;

    private static final int metersInOneNm;

    // initialise static variables in static block
    static {
        metersInOneNm = 1852;
    }

    public static int fromFeetToFlyLevel(int feet) {
        return feet / 100;
    }

    public static double fromNauticalMileToMeters(double nm) {
        return nm * metersInOneNm;
    }
}
