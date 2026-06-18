class Solution {
    public double angleClock(int hour, int minutes) {

        double angleOfHour = ((((double)hour % 12.00) + ((double)minutes/60.00))/12.00)*360.00;
        double angleOfMinutes = ((double)minutes/60.00)*360.00;

        double ans = Math.abs(angleOfHour-angleOfMinutes);

        if(ans > 180.0){
            return 360 -ans;
        }

        return ans;
    }
}