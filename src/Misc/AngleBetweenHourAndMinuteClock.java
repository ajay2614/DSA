package Misc;

public class AngleBetweenHourAndMinuteClock {
    public double angleClock(int hour, int minutes) {
        double hourAngle = (60 * hour + minutes) * 0.5;
        double minutesAngle = minutes * 6;

        double angle = Math.abs(hourAngle-minutesAngle);

        System.out.println(1);

        if(angle <= 180.00)
            return angle;
        else return 360 - angle;
    }
}
