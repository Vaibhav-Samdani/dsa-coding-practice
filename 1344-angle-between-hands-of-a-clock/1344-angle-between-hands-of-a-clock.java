class Solution {
    public double angleClock(int hour, int minutes) {

        double angleOfHour = ((double)hour * 30.0) + ((double)minutes/2.00);
        double angleOfMinutes = (double)minutes * 6.00;

        double ans = Math.abs(angleOfHour-angleOfMinutes);

        return Math.min(ans, 360 - ans);
    }
}