package vigenere;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    String foundKey=new String();
    int foundMax = 0;
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        String outMessage = "";
        for (int i =whichSlice; i<message.length(); i+=totalSlices){
            outMessage = outMessage + message.substring(i,i+1);
        }
        return outMessage;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker cCracker = new CaesarCracker(mostCommon);
        for (int i =0; i<klength; i++){
            key [i] = cCracker.getKey(sliceString(encrypted, i, klength)); 
        }
        //WRITE YOUR CODE HERE
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        VigenereBreaker vb = new VigenereBreaker();
        int [] key = vb.tryKeyLength(fr.asString(), 4, 'e');
        VigenereCipher vc =
        new VigenereCipher(vb.tryKeyLength(fr.asString(), 4, 'e'));
        //System.out.println(vc.decrypt(fr.asString()));
        int index = vc.decrypt(fr.asString()).indexOf("\n");
        String firstLine =
        vc.decrypt(fr.asString()).substring(0,index+1);
        System.out.println(firstLine);
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet <String> dictionary = new HashSet <String>();
        for (String word : fr.lines()){
            dictionary.add(word.toLowerCase());
        }
        return dictionary;
    }
    
    public int countWords (String message, HashSet <String> dictionary){
        int count = 0;
        for (String word : message.split("\\W+")){
            if(dictionary.contains(word.toLowerCase())){
                count++;
            }
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
            //WRITE YOUR CODE HERE
        VigenereBreaker vb = new VigenereBreaker();
        int max=0;
        int counted=0;
        int keyLength=0;
        String message = new String();
        for (int i=1; i<=27; i++){
            VigenereCipher vc =
            //new VigenereCipher(vb.tryKeyLength(encrypted, i, 'e'));
            new VigenereCipher(vb.tryKeyLength(encrypted, i, vb.mostCommonCharIn(dictionary)));
            counted = countWords (vc.decrypt(encrypted),dictionary);
            if (counted>max){
                max=counted;
                message = vc.decrypt(encrypted);
                keyLength = i;
            }
        }
        int count = 0;
        for (String word : message.split("\\W+")){
            count++;
        }
        String keyString = Arrays.toString(tryKeyLength(encrypted, keyLength, 'e'));
        foundKey=keyString;
        foundMax=max;
        
        return message + "\n" + "the key is:: "+ keyString +
        "\n"+"there were:: " + max +
        " valid words out of:: " + count;
        
    }
    
    public void breakVigenere2 () {

        FileResource fr = new FileResource();
        FileResource frdic = new FileResource("dictionaries/English.txt");
        
        VigenereBreaker vb = new VigenereBreaker();
        
        System.out.println(vb.breakForLanguage(fr.asString(),vb.readDictionary(frdic)));
        
        //String decrypted = vb.breakForLanguage(fr.asString(),vb.readDictionary(frdic));
        //int index = (decrypted).indexOf("\n");
        //String firstLine = (decrypted).substring(0,index+1);
        //System.out.println(firstLine);
        //teraz napisali, że program ma jeszcze zwracac klucz i policzone slowa ;)
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        //FileResource fr = new FileResource("data/English.txt");
        //dictionary=readDictionary(fr);
        HashMap <Character, Integer> counts = new HashMap<Character, Integer>();
        String alphabet ="abcdefghijklmnopqrstuvwxyz";
        int max=0;
        int value=0;
        char mostCommonLetter = 'a';
        char temp ='a';
        for (int i = 0; i<26; i++){
            counts.put(alphabet.charAt(i),0);
        }
        //System.out.println(counts);
        for(String word : dictionary){
            for(int i = 0; i < word.length(); i++){
                if (Character.isLetter(word.charAt(i))){
                    if (counts.containsKey(Character.toLowerCase(word.charAt(i)))){
                        temp = Character.toLowerCase(word.charAt(i));
                        counts.put(temp,(counts.get(temp)+1));
                    }
                    else{
                        counts.put(Character.toLowerCase(word.charAt(i)),0);
                    }
                }
            }
        }
        for(Character ch : counts.keySet()){
            value=counts.get(ch);
            if (value>max){
                max=value;
                mostCommonLetter = ch;
            }
        }
        return mostCommonLetter;
    }
    
    public void breakForAllLangs 
    (String encrypted, HashMap<String, HashSet<String>> languages){
        FileResource fr = new FileResource();
        VigenereBreaker vb = new VigenereBreaker();
        String langName = new String();
        String decrypted = new String();
        String bestDecryption = new String();
        int actualCount= 0;
        for(String s : languages.keySet()){
            //System.out.println(mostCommonCharIn(languages.get(s)));
            //System.out.println(s);
            //mostCommonCharIn(languages.get(s));
            
            decrypted=vb.breakForLanguage(encrypted,languages.get(s));
            if (foundMax>=actualCount)
            {bestDecryption = decrypted;
            }
        }
        
        //new BufferedReader(new FileReader("file.txt"));
        
       

             
        
        
        
        System.out.println(bestDecryption);
        
       
        
        //InputStream stream = new ByteArrayInputStream(bestDecryption.getBytes(StandardCharsets.UTF_8));
        //System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output.txt"))));
        
        
        //VigenereBreaker vb = new VigenereBreaker();
        
        //System.out.println(vb.breakForLanguage(fr.asString(),vb.readDictionary(frdic)));
        
    }
}
