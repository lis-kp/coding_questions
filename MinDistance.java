import java.awt.print.Printable;

/*
Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.
*/


/*
 * In fact, the problem is to seek the largest common sequence of two strings
 *  in disguise because, for each string, out of the common subsequence 
 *  are part of the need to be deleted.
 * */
public class MinDistance {
	public static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 1; i<=m;i++) {
			for(int j = 1; j<=n;j++) {
				System.out.println(word1.charAt(i-1) +" "+ word2.charAt(j-1));
				printMatrix(dp, m, n);
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] +1;
					
				}else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return m+n-2*dp[m][n];
	}
	//ueue
	
	private static void printMatrix(int[][] matrix, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) {
		System.out.println(minDistance("seat", "qqweat"));
	}
}
