

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.HashMap;

public class T9_Spelling {
	
	public static void main(String[] args) {
		
	HashMap<Integer, String[]> numpad = constructNumPad();	
	BufferedReader rd = null;
	PrintWriter wr = null;
	
	try{
		rd = new BufferedReader (new FileReader ("/Users/kbircan/Google Drive/java/workspace/googleCodeJam/bin/T9_Spelling_input.txt"));		
		wr = new PrintWriter("/Users/kbircan/Google Drive/java/workspace/googleCodeJam/bin/T9_Spelling_output.txt", "UTF-8");

		
		String str = rd.readLine();
		int NUMBER_OF_LINES = Integer.parseInt(str);
		
		for (int n=0; n < NUMBER_OF_LINES; n++){ 
			String WORD = rd.readLine();
			//System.out.print("Case #" + (n+1) + ": ");
			wr.print("Case #" + (n+1) + ": ");
			
			for (int l=0; l < WORD.length(); l++) {
				char ch = WORD.charAt(l);			
			
				if(Character.isWhitespace(ch) == false){					
					//System.out.print(keypresses(numpad, ch));
					wr.print(keypresses(numpad, ch));
				} else {
					//System.out.print("0");
					wr.print("0");
				}
				
				if (l != WORD.length() - 1){
					char next_ch = WORD.charAt(l+1);
					
					if (onTheSame(numpad, ch, next_ch)){
						//System.out.print(" ");
						wr.print(" ");
					}
				}
			}
			
			//System.out.println("");
			wr.print("\n");
		}		
	
	} catch (IOException e){
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

	private static boolean onTheSame(HashMap<Integer, String[]> numpad, char ch, char next_ch) {
		// TODO Auto-generated method stub
		
		int first_num= -1;
		int  second_num = -1;
		
		for (int i=2; i < 10; i++) {
			int size_of_ith_value = numpad.get(i).length;
			for (int j=0; j < size_of_ith_value; j++) {
				char ch2 = numpad.get(i)[j].charAt(0);
				if (ch2 == ch) {
					first_num = i;
				}			
			}
		}
		
		for (int i=2; i < 10; i++) {
			int size_of_ith_value = numpad.get(i).length;
			for (int j=0; j < size_of_ith_value; j++) {
				char ch2 = numpad.get(i)[j].charAt(0);
				if (ch2 == next_ch) {
					second_num = i;
				}			
			}
		}
		
		if (first_num == second_num) {
			return true;
		} else {
			return false;
		}
		
	}

	private static int keypresses(HashMap<Integer, String[]> numpad, char ch) {	
		
		for (int i=2; i < 10; i++) {
			int size_of_ith_value = numpad.get(i).length;
			//System.out.println("numpad.get(i)");
			//System.out.println(numpad.get(i));
			for (int j=0; j < size_of_ith_value; j++) {
				char ch2 = numpad.get(i)[j].charAt(0);
				//System.out.println("numpad.get(i)[j]");
				//System.out.println(numpad.get(i)[j]);
				if (ch2 == ch) {
					//System.out.println(ch2);
					//System.out.println(ch);
					int press = i;
					for ( int k=1; k<j+1; k++){
						press += (int) i*Math.pow(10, k);
					}
					return press;
				}			
			}
		}
		return -1;
	}
	
	public static HashMap<Integer, String[]> constructNumPad(){
		
		HashMap<Integer, String[]> numpad = new HashMap<Integer, String[]>();
		
		String[] num2 = {"a","b","c"};
		String[] num3 = {"d","e","f"};
		String[] num4 = {"g","h","i"};
		String[] num5 = {"j","k","l"};
		String[] num6 = {"m","n","o"};
		String[] num7 = {"p","q","r","s"};
		String[] num8 = {"t","u","v"};
		String[] num9 = {"w","x","y","z"};
		
		numpad.put(2, num2);
		numpad.put(3, num3);
		numpad.put(4, num4);
		numpad.put(5, num5);
		numpad.put(6, num6);
		numpad.put(7, num7);
		numpad.put(8, num8);
		numpad.put(9, num9);
	
		return numpad;	
	}
	
}
