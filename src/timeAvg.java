/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author R
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

    public void addTime(long in) {
        if (current < max) {
            times[current] = in;
            current++;
            }
        else System.out.println("Adding past max");
        }
    public long getAvg(){
        long avg=0;
        for(int x=0; x<max; x++){
            avg=avg+times[x];
            }
        avg=avg/max;
        return avg;
        }
    public boolean getFull(){
        if(current==max)
            return true;
        return false;
        }
    public void display(){
        long avg;
        avg=getAvg();
        System.out.println("The Average of the times is : "+avg+" Milliseconds");
        }
    }
