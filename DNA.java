import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] genes = new String[n];

        String[] genesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String genesItem = genesItems[i];
            genes[i] = genesItem;
        }

        int[] health = new int[n];

        String[] healthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int healthItem = Integer.parseInt(healthItems[i]);
            health[i] = healthItem;
        }

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int ls[] = new int[s];
        
        for (int sItr = 0; sItr < s; sItr++) {
            String[] firstLastd = scanner.nextLine().split(" ");

            int first = Integer.parseInt(firstLastd[0]);

            int last = Integer.parseInt(firstLastd[1]);

            String d = firstLastd[2];
            
            ls[sItr] = findHealth(d, first, last, health, genes);
            
        }
            Arrays.sort(ls);
            System.out.println(ls[0]+" "+ls[ls.length-1]);
        scanner.close();
    }
    
    public static Integer findHealth(String a, int start, int last, int[] health, String[] genes) {
   int q=0; 
   String num=a;
   
   for(int d=start;d<=last;d++){
    
    int h = 0;
    String arr[] = new String[a.length()-1];
    String i = genes[d];
    a = a.replaceAll(i,"A");
    int j = a.indexOf("A");
    int n = a.length();
if(j!=-1){
    if (i.length() > 1) {
      int f = (i.replaceAll(String.valueOf(i.charAt(0)), "")).length();
      if (f == 0) {
        for (int g = j; g < n; g++) {
          if (!(a.charAt(g) == 'A' || (a.charAt(g) == i.charAt(0)))) {
            arr[h++] = a.substring(j, g);
            a = a.substring(g - 1, a.length());
            n = a.length();
            j = a.indexOf("A");
          }
        }
      }
      else{
          int g = a.length() - (a.replaceAll("A","")).length();
          q = q + g * health[d];
      }
    }
    else{
        int g = a.length() - (a.replaceAll("A","")).length();
          q = q + g * health[d];
    }
}
       
    
    
    int l = 0;
    int sum = 0;
    
    
    for (String s: arr) {
      if(s!=null){
        
        l = s.length() - (s.replaceAll("A", "")).length();
        int m = s.length() - (s.replaceAll(String.valueOf(i.charAt(0)), "")).length();
        int z = i.length();
        l = l * z + m - (z - 1);
        sum = sum+l;
      
      }
    }
    q=q+sum*health[d];

   a=num;
   }

    return q;
  }

}
