package HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same
 *               with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 * */
public class DetermineIfTwoStringsAreClose {
    /**
     * Operation1-: Since swap kr skte hai characters ko toh character ki position se farak ni padega, apan s1 ko s2 mai
     *              easily convert kr denge agar dono anagram hai
     * Operation2-: Since character ki frequencies bhi swap kr skte hai toh ab anagram hone ki bhi need nhi hai, bas
     *               s1 ka frequency set s2 ke frequency set ke equal hona chaiye
     * ex-: s1="cabbba", s2 = "abbccc
     * s1 ka hashmap-> {c->1,a->2,b->3} means s1 ka frequency set-> {1,2,3}
     * s2 ka hashmap-> {c->3,a->1,b->2} means s2 ka frequency set-> {3,1,2}
     * since dono mai same elements hai toh yes we can convert them
     *  */

    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){return false;}
        //create hashmap for first string
        TreeMap<Character,Integer> hm1=new TreeMap<>();
        for(int i=0;i<word1.length();i++){
            char curr=word1.charAt(i);
            if(hm1.containsKey(curr)){
                hm1.put(curr,hm1.get(curr)+1);
            }
            else{hm1.put(curr,1);}
        }

        //create hasmap for second string
        TreeMap<Character,Integer> hm2=new TreeMap<>();
        for(int i=0;i<word2.length();i++){
            char curr=word2.charAt(i);
            if(hm2.containsKey(curr)){
                hm2.put(curr,hm2.get(curr)+1);
            }
            else{hm2.put(curr,1);}
        }System.out.println(hm1);System.out.println(hm2);
        //now compare both hasmaps
        List<Integer> values1 = new ArrayList<>(hm1.values());
        Collections.sort(values1);
        System.out.println(values1);

        List<Integer> values2 = new ArrayList<>(hm2.values());
        Collections.sort(values2);
        System.out.println(values2);



        return values1.equals(values2) && hm1.keySet().equals(hm2.keySet());


    }


}
