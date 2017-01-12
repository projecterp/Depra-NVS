package parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseAS {

	static String path;
	static int LineNo;

	@SuppressWarnings("null")     //Accessing null at the start of ArrayList<String>
	public static void main(String args[]) {

		// Receive file path from command line and start parsing it.
		Scanner finput = null;
		ArrayList<String> Script = null;    //Line by Line code
		String curr;
		try {
			finput = new Scanner(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Removing all the null lines and stripping off the trailing white-spaces
		while(finput.hasNextLine()){
	       curr  = finput.nextLine().trim();
	       if(!curr.equals("")){
	    	Script.add(curr);  
	       }
		}
		

	}

}
