import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

     public static void main(String []args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         boolean isEncodeLine= false;
         String alpha = null;
         String mul = null;
         int index = 0;
         String line = null;
         br.readLine();
         while((line = br.readLine())!=null){
             if(!isEncodeLine){
             String [] parts = line.split(" ");
             alpha = parts[0];
             mul = parts[1];
             isEncodeLine = true;
             }
             else{
                 index++;
                 String alfabeto=letters;
                 String [] encArray = line.split(" ");
                 String lastField=null;
                 String firstField=null;
                 String decLine="";
                 int refIndex=0;
                 BigInteger zero=new BigInteger("0");
                 BigInteger refNum=null;
                 BigInteger firstPrime=null;
                 BigInteger secondPrime=null;
                 for(int i=1; i<encArray.length; i++){
                     if(!(new BigInteger(encArray[i]).equals(new BigInteger(encArray[i-1])))){
                 refIndex=i-1;         
                 secondPrime=Euclide(new BigInteger(encArray[i-1]), new BigInteger(encArray[i]));
                 firstPrime=new BigInteger(encArray[i-1]).divide(secondPrime);
                 break;
                     }
                 }
                 decLine = firstPrime.toString()+" "+secondPrime.toString(); 
                 for(int i=refIndex+1; i<encArray.length;i++){
                     BigInteger q = new BigInteger(encArray[i]).divide(secondPrime);
                     decLine= decLine+" "+q.toString();
                     secondPrime=q;
                 }
                 
                 for(int i=refIndex-1; i>=0;i--){
                     BigInteger q = new BigInteger(encArray[i]).divide(firstPrime);
                     decLine= q.toString()+" "+decLine;
                     firstPrime=q;
                 } 
                 BigInteger [] encArray1=Arrays.stream(decLine.split(" ")).distinct().map(s-> new BigInteger(s)).toArray(BigInteger[]::new);
                 Arrays.sort(encArray1);
                 for(int i=0; i<encArray1.length; i++){
                     decLine=decLine.replaceAll("\\b"+encArray1[i].toString()+"\\b",
                     alfabeto.substring(0,1));
                     alfabeto=alfabeto.substring(1);
                 }
                 
                 isEncodeLine = false;
                 System.out.println("Case #"+index+": "+decLine.replaceAll(" ","")); 
             
             }
             }         
         }
        
         public static BigInteger Euclide(BigInteger a, BigInteger b) 
{
    BigInteger r;
    while(b.compareTo(new BigInteger("0")) != 0)
    {
         r = a.remainder(b);
         a = b; 
         b = r; 
    }
    return a; 
}
}