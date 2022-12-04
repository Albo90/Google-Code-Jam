import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Solution {
    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int matrixDim = Integer.parseInt(br.readLine());
        int [][] matrix = new int [matrixDim][matrixDim];
        String line;
        int caseNum = 1;
        while( (line = br.readLine() ) != null || matrixDim >=0) {
            if(matrixDim==0){
                System.out.println("Case #"+caseNum+": " +checkLatin(matrix));
                caseNum++;
                if(line == null)
                    break;
                    matrixDim = Integer.parseInt(line.trim());
                    matrix = new int[matrixDim][matrixDim];

                continue;
            }
            String [] row = line.split(" ");
            int col = matrix.length - matrixDim;
            for(int i = 0; i<row.length; i++)
                matrix[col][i] = Integer.parseInt(row[i]);
            matrixDim --;
        }
    }

    public static String checkLatin(int [][] matrix ){
        long trace = 0;
        long numCol = 0;
        long numRow = 0;
        HashMap<Integer, List<Integer>> col = new HashMap();
        boolean [] isColumn = new boolean[matrix.length];
        for(int i=0; i<matrix[0].length; i++){
            List<Integer> row = new LinkedList();
            boolean isRow = false;
            for(int j=0; j<matrix[0].length; j++){
                List<Integer> item = new LinkedList();
                if(col.containsKey(j))
                    item=col.get(j);
                if(item.contains(matrix[i][j]) && !isColumn[j]) {
                    numCol++;
                    isColumn[j]=true;
                }
                item.add(matrix[i][j]);
                col.put(j,item);
                if(i==j)
                    trace+=matrix[i][j];
                if(row.contains(matrix[i][j]) && !isRow) {
                    numRow++;
                    isRow = true;
                }
                row.add(matrix[i][j]);
            }
        }
        return ""+trace+" "+numRow+" "+numCol;
    }
}