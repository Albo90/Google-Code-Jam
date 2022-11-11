import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String stringa = null;
        int replaceNum = 0;
        for (int i = 1; i <= t; ++i) {
            replaceNum = in.nextInt();
            stringa = in.next();
            String out = decode(stringa, replaceNum);
            System.out.println("Case #" + (i) + ": " + out);
        }
    }
        public static String decode(String stringa, int soglia) {
            String newString = stringa;
            String oldString = null;
            int moves = 0;
            if(count(newString)<=soglia) return ""+moves;
            int i = stringa.lastIndexOf('S') > 0? stringa.lastIndexOf('S') : 0;
            while( !newString.equals(oldString) || i > 0) {
                    char last = newString.charAt(i);
                    char begin = newString.charAt(i - 1);
                    if (("" + last).equals("S") && ("" + begin).equals("C")) {
                        newString = replaceChar(newString, last, i - 1);
                        newString = replaceChar(newString, begin, i);
                        int score = count(newString);
                        moves++;
                        if (score <= soglia){  return ""+moves;}
                    }
                  String s = newString;
                  while ( s.lastIndexOf('S') > 0 && s.charAt(s.lastIndexOf('S')-1)!= 'C' ) {
                      s = s.substring(0, s.lastIndexOf('S'));
                  }
                //System.out.println(s);
                i = s.lastIndexOf('S');
                //System.out.println(moves+" Indice String:"+ i+ " Stringa: "+newString);
                oldString = newString;
            }
            if (count(newString)>soglia )  return "IMPOSSIBLE";
            return ""+moves;
        }

        
            public static String replaceChar(String str, char ch, int index) {
                StringBuilder myString = new StringBuilder(str);
                myString.setCharAt(index, ch);
                return myString.toString();
            }

        public static int count(String stringa ){
        int res = 0;
        int value =1;
        for(int i= 0; i<stringa.length(); i++){
            if((""+stringa.charAt(i)).equals("S")){
                res = res+value;
            }
            else { value=value*2;}
        }
        return res;
        }
}