// { Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
// User function Template for Java
class Solution {
  static int findLastOccurence(String A, String B) {
    int[] lps = new int[B.length()];
    computeLPS(B, lps);
    int i = A.length() - 1;
    int j = B.length() - 1;
    // System.out.println("lps: " + Arrays.toString(lps));
    while (i >= 0) {
      // System.out.println("i: " + i + " char: " + A.charAt(i) + " j: " + j + " char: " +
      // B.charAt(j));
      if (A.charAt(i) == B.charAt(j)) {
        j--;
        if (j < 0) {
          return i + 1;
        }
        i--;
      } else {
        if (j < B.length() - 1) {
          j = B.length() - 1 - lps[j + 1];
        } else {
          i--;
        }
      }
    }
    return -1;
  }

  static void computeLPS(String B, int[] lps) {
    int M = B.length() - 1;
    int i = M - 1;
    int len = 0;
    lps[M] = 0;
    while (i >= 0) {
      if (B.charAt(i) == B.charAt(M - len)) {
        lps[i--] = ++len;
      } else {
        if (len == 0) {
          lps[i--] = 0;
        } else {
          len = lps[M - len + 1];
        }
      }
    }
  }
}

// { Driver Code Starts.
class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {

      String A = read.readLine().trim();
      String B = read.readLine().trim();

      Solution ob = new Solution();
      System.out.println(ob.findLastOccurence(A, B));
    }
  }
}
// } Driver Code Ends
