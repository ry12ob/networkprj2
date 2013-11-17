/*
 * This class handels an object that takes in a size for an array of longs.
 */
public class timeAvg {

    private long[] times;
    private int max;
    private int current;
    
    timeAvg(int size) {
        times = new long[size];
        max = size;
        current = 0;
    }
//This method adds times to the array and increments the current counter
    public void addTime(long in) {
        if (current < max) {
            times[current] = in;
            current++;
            }
        else System.out.println("Adding past max");
        }
//this method calculates the average of all the times and returns it as a double
    public double getAvg(){
        double avg=0;
        for(int x=0; x<max; x++){
            avg=avg+times[x];
            }
        avg=avg/max;
        return avg;
        }
//this method returns false if all the times have come in and false if not
    public boolean getFull(){
        if(current==max)
            return false;
        return true;
        }
//this method displays the average of all the times.
    public void display(){
        double avg;
        avg=getAvg();
        System.out.println("\nThe Average of the times is : "+avg+" Milliseconds");
        }
    }
