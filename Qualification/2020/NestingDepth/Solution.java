import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Solution {
    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String line;
        int caseNum = 1;
        while( (line = br.readLine() ) != null) {
            String [] checkZero = line.replaceAll("0"," ").trim().split(" ");
            String firstCheck =line;
            Set <String> letters = new HashSet();
            for (int i = 0; i<checkZero.length; i++){
                for (int j=0; j<checkZero[i].length(); j++){
                    String digit = ""+checkZero[i].charAt(j);
                    if (letters.contains(digit))
                        continue;
                    letters.add(digit);
                    int numDigit = Integer.parseInt(digit);
                    firstCheck = firstCheck.replaceAll(digit,String.join("", Collections.nCopies(numDigit, "("))+digit +String.join("", Collections.nCopies(numDigit, ")")));
                    String par = "(\\)\\()*";
                    firstCheck = firstCheck.replaceAll(par,"");
                    
                }
                String par = "(\\)\\()*";
                firstCheck = firstCheck.replaceAll(par,"");
            }
                String prec = "";
                while(!prec.equals(firstCheck)){
                prec = firstCheck;
                String par = "(\\)\\()*";
                firstCheck = firstCheck.replaceAll(par,"");
                }
                System.out.println("Case #"+caseNum+": " +firstCheck);
                caseNum++;
        }
    }
}