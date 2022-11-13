import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.math.BigInteger;

public class Solution {

     public static void main(String []args){
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         AtomicInteger ordinal = new AtomicInteger(1);
         br.lines().skip(1).filter(item->!item.trim().isEmpty()).forEach(item -> {
             String a = null;
             String b = null;
             int start= item.indexOf("4");
             if(start!=-1){
                 b = item.replaceAll("4","1");
                 a = item.substring(start).replaceAll("[^4]","0")
                 .replaceAll("4","3");
                 int i = ordinal.getAndIncrement();
                 System.out.println("Case #"+i+": "+a+" "+b);
             }});
     }
}
