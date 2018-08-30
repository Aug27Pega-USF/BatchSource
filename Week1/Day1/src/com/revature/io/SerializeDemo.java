package com.revature.io;

public class SerializeDemo {

	public static void main(String[] args) {
		/*if output.txt does not exist, it will create it!
		 * If it doesnt exist, run it, and then refresh the project
		 * explorer to see it
		 * 
		 */
		IO io =new IO();
		//io.writeOutputStreamContents("Roll Tide");
		
		//the file that data is being read FROM must exist already!
		System.out.println(io.readInputStreamContents());

	}

}
