package q11_newman_harnett;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author Aaron
 */
public class Q11_Newman_Harnett {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int CUSTOMER_TIME = 2; //the time it takes per customer (minutes)
        final int WORKDAY = 16*60; //workday in minutes
            
        ArrayList<Integer> lineOne = new ArrayList(); //create "lines" to use as queues in the store
        ArrayList<Integer> lineTwo = new ArrayList();
        ArrayList<Integer> lineThree = new ArrayList();
        ArrayList<Integer> lineFour = new ArrayList();
        ArrayList<Integer> lineFive = new ArrayList();
        ArrayList<Integer> lineSix = new ArrayList();
        ArrayList<Integer> lineSeven = new ArrayList();
        ArrayList<Integer> lineEight = new ArrayList();
        
        int CServed = 0; //customers served
        int CLost = 0; //customers lost
        long t = 0; //time per customer entering
        
        ArrayList<Integer> AllCServed = new ArrayList();//all trials per different time n
        ArrayList<Integer> AllCLost = new ArrayList();
        int trial = 0;
        
        /*
        GOAL: Calculate value for t where fewest customers are lost while most customers are served
        */
                        
        boolean bestTime = false;
        boolean found = true;        
        
        while(bestTime != found)
        {
            long timeIncrement = 1; //time increment used to find best time per customer coming in (seconds)
            t += timeIncrement;        
            
            double secondsForCustomers = 1; //used to keep track of how long the customers been in line (in seconds)
            trial++;
                        
            for(int i = 0; i < WORKDAY; i++)//each iteration is a minute
            {
                                
                for(int seconds = 0; seconds < 60; seconds++)//each iteration is a second out of the minute
                {
                    ArrayList allLines = new ArrayList();//used to check if all lines are full
            
                    allLines.addAll(lineOne);
                    allLines.addAll(lineTwo);
                    allLines.addAll(lineThree);
                    allLines.addAll(lineFour);
                    allLines.addAll(lineFive);
                    allLines.addAll(lineSix);
                    allLines.addAll(lineSeven);
                    allLines.addAll(lineEight);
                    
                    if(i == 0)
                    {}
                    else if((seconds%t) == 0)//whenever a new customer enters
                    {
                        if(checkMax(allLines))//check to see if a customer is lost
                        {
                            CLost++;
                        }
                        else//if not lost put them in a line
                        {
                            ArrayList sizeOfLines = new ArrayList();//used to find which line to put the customer
                                                                    //find min of lines and then add the customer 
                                                                    //to the line with the least people
                            sizeOfLines.add(lineOne.size());
                            sizeOfLines.add(lineTwo.size());
                            sizeOfLines.add(lineThree.size());
                            sizeOfLines.add(lineFour.size());
                            sizeOfLines.add(lineFive.size());
                            sizeOfLines.add(lineSix.size());
                            sizeOfLines.add(lineSeven.size());
                            sizeOfLines.add(lineEight.size());

                            int minIndex = sizeOfLines.indexOf(Collections.min(sizeOfLines));                            
                            switch(minIndex)
                            {
                                case 0:
                                    lineOne.add(CUSTOMER_TIME);
                                    break;                            
                                case 1:
                                    lineTwo.add(CUSTOMER_TIME);
                                    break;
                                case 2:
                                    lineThree.add(CUSTOMER_TIME);
                                    break;
                                case 3:
                                    lineFour.add(CUSTOMER_TIME);
                                    break;
                                case 4:
                                    lineFive.add(CUSTOMER_TIME);
                                    break;
                                case 5:
                                    lineSix.add(CUSTOMER_TIME);
                                    break;
                                case 6:
                                    lineSeven.add(CUSTOMER_TIME);
                                    break;
                                case 7:
                                    lineEight.add(CUSTOMER_TIME);
                                    break;
                                default:
                                    System.out.println("ERROR at switch");
                            }

                        }                    

                    }
                    secondsForCustomers = secondsForCustomers + 1;

                    if(secondsForCustomers % 60 == 0)//check to see if a minute has passed
                    {
                        if(lineOne.size() > 0) 
                        {
                            lineOne.set(0, lineOne.get(0) - 1);//decrement the minute required to finish the customer
                            if(lineOne.get(0) == (0))
                            {
                                lineOne.remove(0);//if the time is up remove the customer from the line
                                CServed++;
                            }
                        }
                        if(lineTwo.size() > 0)
                        {
                            lineTwo.set(0, lineTwo.get(0) - 1);
                            if(lineTwo.get(0).equals(0))
                            {
                                lineTwo.remove(0);
                                CServed++;
                            }
                        }
                        if(lineThree.size() > 0)
                        {
                            lineThree.set(0, lineThree.get(0) - 1);
                            if(lineThree.get(0).equals(0))
                            {
                                lineThree.remove(0);
                                CServed++;
                            }
                        }
                        if(lineFour.size() > 0)
                        {
                            lineFour.set(0, lineFour.get(0) - 1);
                            if(lineFour.get(0).equals(0))
                            {
                                lineFour.remove(0);
                                CServed++;
                            }
                        }
                        if(lineFive.size() > 0)
                        {
                            lineFive.set(0, lineFive.get(0) - 1);
                            if(lineFive.get(0).equals(0))
                            {
                                lineFive.remove(0);
                                CServed++;
                            }
                        }
                        if(lineSix.size() > 0)
                        {
                            lineSix.set(0, lineSix.get(0) - 1);
                            if(lineSix.get(0).equals(0))
                            {
                                lineSix.remove(0);
                                CServed++;
                            }
                        }
                        if(lineSeven.size() > 0)
                        {
                            lineSeven.set(0, lineSeven.get(0) - 1);
                            if(lineSeven.get(0).equals(0))
                            {
                                lineSeven.remove(0);
                                CServed++;
                            }
                        }
                        if(lineEight.size() > 0)
                        {
                            lineEight.set(0, lineEight.get(0) - 1);
                            if(lineEight.get(0).equals(0))
                            {
                                lineEight.remove(0);
                                CServed++;
                            }
                        }

                    }                    
                }  
                
            }
            
            if(trial == 100)
            {
                bestTime = true;
            }
            AllCServed.add(CServed);//Add this trials data
            AllCLost.add(CLost);            
            
            CServed = 0;
            CLost = 0;
        }
        
        System.out.println("The best Time t is: " + checkBestTime(AllCServed, AllCLost));
        
        int choice = 1234;        
        while(choice != 0)
        {       
            System.out.println("1: Show trials\n0: Exit");
            System.out.print("\nEnter choice: ");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();

            switch(choice)
            {
                case 1:

                    t = 0;
                    for(int i = 0; i < AllCServed.size(); i++)
                    {
                        t+=1;
                        System.out.println("\nTrial: " + i + ", " + t + " seconds per customer entering");
                        System.out.println("Customers Served: " + AllCServed.get(i));
                        System.out.println("Customers Lost: " + AllCLost.get(i) + "\n");
                    }

                    break;

                case 0:
                    break;
                    
                default:
                    System.out.println("ERROR: WRONG INPUT \n\n (make sure you arent putting anything else besides the number)\n");
            }              
        }
    }
    
    private static boolean checkMax(ArrayList line)
    {
        boolean isFull = true;
        if(line.size() < 32)
        {
            isFull = false;
        }
        return isFull;
    }
    
    private static int checkBestTime(ArrayList<Integer> served, ArrayList<Integer> lost)
    {
        int t = 0;
        
        for(int i = 0; i < served.size(); i++)
        {
            if( i == (served.size() - 1) )
            {}
            else
            {
                if((served.get(i+1) >= served.get(i)) && (lost.get(i+1) < lost.get(i)))
                {
                    t = i + 2;                    
                }
            }
        }
        
        
        return t;
    }
}
