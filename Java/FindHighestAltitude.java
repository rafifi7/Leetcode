//naive solution O(2n) time complexity could be done faster

class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int[] gain_arr = new int[gain.length + 1];

        gain_arr[0] = 0; //first altitude

        for (int i = 1; i < gain_arr.length; i++) {
            altitude += gain[i - 1]; // add gain or loss to current altitude
            gain_arr[i] = altitude; // append new altitude to our altitude array
        }

        altitude = -101;
        // now make normal find max algo
        for (int i = 0; i < gain_arr.length; i++) {
            if (gain_arr[i] > altitude)
                altitude = gain_arr[i];
        }
        return altitude;
    }
}


// best solution O(n) time complexity

class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int altitude = 0;

        for (int i = 0; i < gain.length; i++) { 
            altitude += gain[i]; //adds the gain or loss in altitude
            if (max < altitude) // if the current max is smaller fix current max
                max = altitude;
        }

        return max;
    }
}