import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.math.BigInteger;

public class Solution {

     public static void main(String []args){
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         AtomicInteger ordinal = new AtomicInteger(1);
         br.lines().skip(1).filter(item->item.contains("E") && item.contains("S")).forEach(item -> {
             String a = null;
                 a = item.replaceAll("S","W").replaceAll("E","Z")
                 .replaceAll("W","E").replaceAll("Z","S");
                 int i = ordinal.getAndIncrement();
                 System.out.println("Case #"+i+": "+a);
             });
     }
}
