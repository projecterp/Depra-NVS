package aLHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HexConverter {
	// Data is considered to be UTF-8 encoded hence 16 bytes per string literal.

	public static void Convert(String path) {
		StringBuilder build = new StringBuilder();
		String builder = null;
		Scanner finput = null;
		FileOutputStream fos = null;
		byte[] bytes;
		int p;
		int i = 0;
		String curr;
		try {
			finput = new Scanner(new FileReader(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (finput.hasNextLine()) {
			curr = finput.nextLine();
			// System.out.println("+++\n" + curr + "+++\n");
			for (; i < curr.length();) {
				try {
					p = curr.indexOf(" ");
					curr = curr.substring(p + 1, curr.length());
					System.out.println("index " + p + " " + i + " " + curr);
					builder = curr.substring(i, p);
					i = p + 1;
				} catch (Exception e) {

				}
				bytes = builder.getBytes();
				for (byte b : bytes) {
					int val = b;
					for (int j = 0; j < 8; j++) {
						build.append((val & 128) == 0 ? 0 : 1);
						val <<= 1;
					}
					build.append(' ');
				}
			}
		}
		System.out.println("CONVERTED STRING\n" + build.toString() + "\n--");
		bytes = build.toString().getBytes();
		curr = path.substring(0, path.indexOf(".")) + "convert.txt";
		try {
			fos = new FileOutputStream(curr);
			for (i = 0; i < bytes.length; i++) {
				fos.write(bytes[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (fos != null)
				fos.close();
		} catch (IOException e) {
			System.out.println("Error closing data file!");
		}
	}
/*
	public static void main(String args[]) {
		String s = "F:\\Learning\\CSE\\java.txt";
		Convert(s);
	}
*/
}