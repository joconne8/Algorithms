package csu22011_a1;

import static org.junit.Assert.*;

//remove .test and put in star
import org.junit.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author  
 *  @version 03/10/22 22:33:19
 */
@RunWith(JUnit4.class)
public class CollinearTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */

    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear with 3 empty arrays should return zero",     expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast with 3 empty arrays should return zero", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // TODO: write more tests here to cover 100% of the instructions and the branches of Collinear.java
    
    @Test
    public void testSingleFalse()
    {
    	int[] a3 = {15};
    	int[] a2 = {5};
    	int[] a1 = {10};
    	
    	int expectedResult = 0;
    	
    	assertEquals("countCollinear({10}, {5}, {15}", expectedResult, Collinear.countCollinear(a1, a2, a3));
    	assertEquals("countCollinearFast({10}, {5}, {15}", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    	
    }
    
    @Test
    public void testSingleTrue()
    {
    	int [] a3 = {15, 5 }; int [] a2 = {5}; int [] a1 = {10, 15,5}; 
    	
    	int expectedResult = 1; 
    	
    	assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) 
    	+ ", " + Arrays.toString(a3) +")", expectedResult, Collinear.countCollinear(a1, a2, a3));
    	
    	assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) 
    	+ ", " + Arrays.toString(a3) +")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }
    
    @Test
    public void testTwoLines ()
    //two possibilities - vertical line at x = 10 or line from (15,1) to (10, 2) to (5, 3) 
    {
    	int [] a1 = { 10 , 15 } ; int [] a2 = {10 }; int[] a3 = {5,10};
    	int expectedResult = 2;
    	assertEquals("CountCollinear (" + Arrays.toString(a1) + ", " + Arrays.toString(a2) + ", " 
    			+ Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinear(a1, a2, a3));
    	assertEquals("CountCollinearFast (" + Arrays.toString(a1) + ", " + Arrays.toString(a2) + ", " 
    			+ Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    	
    }
    
    @Test
    public void testBinarySearch()
    {
        int[] binarySrchArray = { 5, 10, 15, 20};
        Collinear.sort(binarySrchArray);
        boolean binaryResult1;
        boolean binaryResult2;
        binaryResult1 = Collinear.binarySearch(binarySrchArray, 10);
        binaryResult2 = Collinear.binarySearch(binarySrchArray, 19);

        assertTrue("Should have found 10", binaryResult1);
        assertFalse("Should not have found number 19 in the array", binaryResult2);
    }

    @Test
    public void testCountCollinear()
    {
        int[] collinearArray1 = {5, 6, 7};
        int[] collinearArray2 = {6, 7};
        int[] collinearArray3 = {7, 8};

        int myExpectedResult = 3;

        assertEquals("countCollinear(" + Arrays.toString(collinearArray1) + "," + Arrays.toString(collinearArray2) +
                "," + Arrays.toString(collinearArray3) + ")", myExpectedResult, Collinear.countCollinear(collinearArray1,
                collinearArray2, collinearArray3));
    }

    @Test
    public void testSort()
    {
        int[] sortArray = {4, 10, 6, 12, 7};

        Collinear.sort(sortArray);
    }

    @Test
        public void testCountCollinearFast()
        {
            int[] collinearArrayFast1 = {8, 9, 10};
            int[] collinearArrayFast2 = {3, 4};
            int[] collinearArrayFast3 = {2, 3};

            int myExpectedResult = 0;

            assertEquals("countCollinearFast(" + Arrays.toString(collinearArrayFast1) + "," +
                    Arrays.toString(collinearArrayFast2) + "," + Arrays.toString(collinearArrayFast3) + ")",
                    myExpectedResult, Collinear.countCollinearFast(collinearArrayFast1, collinearArrayFast2, collinearArrayFast3));
        }
    
    /*
     * You need to create a main method in CollinearTest that runs all the experiments 
     * on countCollinear and countCollinearFast described below, and prints the time each experiment took.
     * The experiments here should measure the running time of countCollinear when given random arrays of integers of sizes 1000, 2000, 4000. 
     * You can use these input files and these auxiliary classes to orchestrate your tests 
     * 
     * Experiment is going through count collinear with arrays
     * Do I run it three times and do it 
     */
    
  // public class TestResult{
    /*public static void main(String args[])
    {
    	//Scanner input = new Scanner(System.in);
    	Stopwatch stopwatch = new Stopwatch();
    	 
    	//make objects In and use the functions contained in that class
    	
    	In OneThousandCase1 = new In("r01000-1.txt");
    	In OneThousandCase2 = new In("r01000-2.txt");
    	In OneThousandCase3 = new In("r01000-3.txt");
    	
    	//do these have to be downloaded or does it get it from my computer
    	
    	//make arrays
    	int [] a1 = OneThousandCase1.readAllInts(); //check what read all ints does
    	int [] a2 = OneThousandCase2.readAllInts();
    	int [] a3 = OneThousandCase3.readAllInts();
    	
    	//repeat this for 2000, 4000
    	
    	In TwoThousandCase1 = new In("r02000-1.txt");
    	In TwoThousandCase2 = new In("r02000-2.txt");
    	In TwoThousandCase3 = new In("r02000-3.txt");
    	
    	int [] b1 = TwoThousandCase1.readAllInts(); 
    	int [] b2 = TwoThousandCase2.readAllInts();
    	int [] b3 = TwoThousandCase3.readAllInts();
    	
    	In FourThousandCase1 = new In("r04000-1.txt");
    	In FourThousandCase2 = new In("r04000-2.txt");
    	In FourThousandCase3 = new In("r04000-3.txt");
    	
    	int [] c1 = FourThousandCase1.readAllInts(); 
    	int [] c2 = FourThousandCase2.readAllInts();
    	int [] c3 = FourThousandCase3.readAllInts();
    	
    	//now for 5000
    	In FiveThousandCase1 = new In("r05000-1.txt");
    	In FiveThousandCase2 = new In("r05000-2.txt");
    	In FiveThousandCase3 = new In("r05000-3.txt");
    	
    	int [] d1 = FiveThousandCase1.readAllInts(); 
    	int [] d2 = FiveThousandCase2.readAllInts();
    	int [] d3 = FiveThousandCase3.readAllInts();
    	
    	//StdOut std = new StdOut();
    	double start1 = stopwatch.elapsedTime();
    	StdOut.println(Collinear.countCollinear(a1, a2, a3));
    	double time1000Finish = stopwatch.elapsedTime();
    	double time1000 = start1 - time1000Finish;
    	StdOut.println("Elapsed time: " + time1000);
    	
    	double start2 = stopwatch.elapsedTime();
    	StdOut.println(Collinear.countCollinear(b1, b2, b3));
    	double time2000Finish = stopwatch.elapsedTime();
    	double time2000 = start2 - time2000Finish;
    	StdOut.println("Elapsed time: " + time2000);
    	
    	double start3 = stopwatch.elapsedTime();
    	StdOut.println(Collinear.countCollinear(c1, c2, c3));
    	double time4000Finish = stopwatch.elapsedTime();
    	double time4000 = start3 - time4000Finish;
    	StdOut.println("Elapsed time: " + time4000);
    	
    	double start4 = stopwatch.elapsedTime();
    	StdOut.println(Collinear.countCollinear(d1, d2, d3));
    	double time5000Finish = stopwatch.elapsedTime();
    	double time5000 = start4 - time5000Finish;
    	StdOut.println("Elapsed time: " + time5000);
    	//just one count call the collinear.countCollinear which has to input 3 arrays for it to work ... etc 
    	
    	
    	
    }*/

}

