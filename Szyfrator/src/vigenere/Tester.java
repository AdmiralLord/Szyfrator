package vigenere;

/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class Tester {
    public void testEveryting(){
        //CaesarCipher cc = new CaesarCipher (1);
        //System.out.println(cc.encryptLetter('a'));
        //System.out.println(cc.encrypt("aaaaaaaaaaaaabbbbbbbbbbbb"));
        
        //CaesarCracker cCracker = new CaesarCracker();
        //FileResource fr = new FileResource ("data/titus-small_key5.txt");
        //System.out.println(cCracker.decrypt(fr.asString()));
        
        //CaesarCracker cCracker = new CaesarCracker('a');
        //FileResource fr = new FileResource ("data/oslusiadas_key17.txt");
        //System.out.println(cCracker.decrypt(fr.asString()));
        
        //int[] key = {17,14,12,4};
        //VigenereCipher vc = new VigenereCipher(key);
        //FileResource fr = new FileResource ("data/titus-small.txt");
        //System.out.println(vc.encrypt(fr.asString()));
        
        //VigenereBreaker vb = new VigenereBreaker();
        //System.out.println(vb.sliceString("abcdefghijklm", 0, 3));
        //System.out.println(vb.sliceString("abcdefghijklm", 1, 3));
        //System.out.println(vb.sliceString("abcdefghijklm", 2, 3));
        //System.out.println(vb.sliceString("abcdefghijklm", 0, 4));
        //System.out.println(vb.sliceString("abcdefghijklm", 1, 4));
        //System.out.println(vb.sliceString("abcdefghijklm", 2, 4));
        //System.out.println(vb.sliceString("abcdefghijklm", 3, 3));
        //System.out.println(vb.sliceString("abcdefghijklm", 0, 5));
        //System.out.println(vb.sliceString("abcdefghijklm", 1, 5));
        //System.out.println(vb.sliceString("abcdefghijklm", 2, 5));
        //System.out.println(vb.sliceString("abcdefghijklm", 3, 5));
        //System.out.println(vb.sliceString("abcdefghijklm", 4, 5));
        
        //VigenereBreaker vb = new VigenereBreaker();
        //FileResource fr = new FileResource ("data/secretmessage1.txt");
        //FileResource fr = new FileResource ("data/athens_keyflute.txt");
        //int klength = 4;
        //int [] key = vb.tryKeyLength(fr.asString(), klength, 'e');
        //for(int i =0; i<klength; i++){
            //System.out.println(key[i]);
        
        //FileResource fr = new FileResource ("dictionaries/English.txt");   
        //VigenereBreaker vb = new VigenereBreaker();
        //System.out.println(vb.readDictionary(fr));
        
        //VigenereBreaker vb = new VigenereBreaker();
        //FileResource fr = new FileResource ("dictionaries/English.txt");
        //System.out.println(vb.breakForLanguage("Htfq-gqfhp nx gjyyjw ymfs fstymjw mzj, Ns ymfy ny xhtwsx yt gjfw fstymjw mzj; Ktw fqq ymj bfyjw ns ymj thjfs Hfs sjajw yzws ymj xbfs'x gqfhp qjlx yt bmnyj, Fqymtzlm xmj qfaj ymjr mtzwqd ns ymj kqtti.",vb.readDictionary(fr)));
        
        //VigenereBreaker vb = new VigenereBreaker();
        //FileResource fr = new FileResource("dictionaries/English.txt");
        //System.out.println(vb.mostCommonCharIn(vb.readDictionary(fr)));
    
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        VigenereBreaker vr = new VigenereBreaker();
        FileResource frden = new FileResource ("dictionaries/Danish.txt");
        languages.put("Danish",vr.readDictionary(frden));
        FileResource frdut = new FileResource ("dictionaries/Dutch.txt");
        languages.put("Dutch",vr.readDictionary(frdut));
        FileResource freng = new FileResource ("dictionaries/English.txt");
        languages.put("English",vr.readDictionary(freng));
        FileResource frfre = new FileResource ("dictionaries/French.txt");
        languages.put("French",vr.readDictionary(frfre));
        FileResource frger = new FileResource ("dictionaries/German.txt");
        languages.put("German",vr.readDictionary(frger));
        FileResource frita = new FileResource ("dictionaries/Italian.txt");
        languages.put("Italian",vr.readDictionary(frita));
        FileResource frpor = new FileResource ("dictionaries/Portuguese.txt");
        languages.put("Portuguese",vr.readDictionary(frpor));
        FileResource frspa = new FileResource ("dictionaries/Spanish.txt");
        languages.put("Spanish",vr.readDictionary(frspa));
        VigenereBreaker vc = new VigenereBreaker();
        FileResource fr = new FileResource ("data/secretmessage4.txt");
        vc.breakForAllLangs(fr.asString(),languages);
    }
        
    }
