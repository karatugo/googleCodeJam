// This is Problem A of Round 1A 2008 of Google Code Jam
// https://code.google.com/codejam/contest/32016/dashboard#s=p0

package googleCodeJam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Minimum_scalar_product {
	
	public static void main(String[] args){
		BufferedReader rd = null;
		PrintWriter wr = null;
		
		try{
			rd = new BufferedReader (new FileReader ("/Users/kbircan/Google Drive/java/workspace/googleCodeJam/bin/googleCodeJam/Minimum_scalar_product_input.txt"));		
			wr = new PrintWriter("/Users/kbircan/Google Drive/java/workspace/googleCodeJam/bin/googleCodeJam/Minimum_scalar_product_output.txt ", "UTF-8");
			
			
			String str = rd.readLine(); //reads the number of test cases
			int NUMBER_OF_TEST_CASES = Integer.parseInt(str); //converts string to integer
			
			for(int test_case = 1; test_case < NUMBER_OF_TEST_CASES + 1; test_case++){
				
				str = rd.readLine();//reads the number of coordinates
				int number_of_coordinates = Integer.parseInt(str);//converts string to integer
				int[] first_vector, second_vector;
		
				first_vector = createArray(rd, number_of_coordinates);
				second_vector = createArray(rd, number_of_coordinates);
				
				Arrays.sort(first_vector);
				Arrays.sort(second_vector);
				
				int result=0;
				
				for (int i=0; i < number_of_coordinates; i++){
					result += first_vector[i] * second_vector[number_of_coordinates-i-1];
				}
				wr.println("Case #" + test_case + ": " + result);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				rd.close();
				wr.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static int[] createArray(BufferedReader rd, int number_of_coordinates) {
		// TODO Auto-generated method stub
		int[] array_of_coordinates = new int[number_of_coordinates]; //creates an integer array whose size equals to the number of coordinates
		
		String line;
		try {
			line = rd.readLine();
			StringTokenizer strtoken = new StringTokenizer (line); //creates StringTokenizer for the line so that we can write the coordinates into the array "array_of_coordinates"				
			
			for (int count = 0; count < number_of_coordinates; count++){
				int next_entry = Integer.parseInt(strtoken.nextToken()); //converts next entry from string to integer
				array_of_coordinates[count] = next_entry;
			}						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //reads the line which are the coordinates separated by whitespace
		
		return array_of_coordinates;		
	}
}
