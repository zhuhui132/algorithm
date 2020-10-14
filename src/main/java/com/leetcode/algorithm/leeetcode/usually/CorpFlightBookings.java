package com.leetcode.algorithm.leeetcode.usually;

public class CorpFlightBookings {
    public static void main(String[] args) {
        CorpFlightBookings corpFlightBookings = new CorpFlightBookings();
        corpFlightBookings.corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}},5 );
    }
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] res = new int[n];
        int bookingCount = bookings.length;
        for (int i = 0; i < bookingCount; i++) {
            for (int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                res[j - 1] += bookings[i][2];
            }
        }
        return res;
    }
}