package vigenere;

import java.util.HashMap;
import java.util.HashSet;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import edu.duke.*;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //int[] key = {17,14,12,4};

        Component frame = null;
		//JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");

		Object[] possibilities = null;
		Icon icon = null;
		String s = (String)JOptionPane.showInputDialog(
		                    frame,
		                    "Podaj d³ugoœæ klucza szyfruj¹cego\n"
		                    //+ "\"Green eggs and...\""
		                    ,"D³ugoœæ klucza szyfruj¹cego",
		                    JOptionPane.PLAIN_MESSAGE,
		                    icon,
		                    possibilities,
		                    null);
		
        int z= Integer.parseInt(s);
        //ArrayList key2 = new ArrayList();
        
        int[] key = new int[z];
        
        for (int i=1; i<=z; i++) {
        	String w = (String)JOptionPane.showInputDialog(
                    frame,
                    "Podaj " + i +  " element klucza szyfruj¹cego\n",
                    "Element klucza szyfruj¹cego",
                    JOptionPane.PLAIN_MESSAGE,
                    icon,
                    possibilities,
                    null);
        	//key2.add(Integer.parseInt(w));
        	key[i-1]=Integer.parseInt(w);
        }
        
        
        
        VigenereCipher vc = new VigenereCipher(key);
        FileResource fr = new FileResource ();
        
        try {
            File myObj = new File("zaszyfrowana.txt");
            
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
    	PrintWriter zapis = null;
		try {
			zapis = new PrintWriter("zaszyfrowana.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        zapis.println(vc.encrypt(fr.asString()));
        zapis.close();
		//for(int a : key) {
		//	System.out.println(a);
		//}
        
        System.out.println(vc.encrypt(fr.asString()));
	
	}

}
