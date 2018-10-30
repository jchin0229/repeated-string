import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long countInOne = 0;
        int pos = 0;
        while (pos < s.length() && pos < n){
            if (s.charAt(pos) == 'a'){
                countInOne++;
            }
            pos++;
        }
        long totalCount = n < s.length()? countInOne : n / s.length() * countInOne;
        if (n > s.length() && n % s.length() != 0){
            int endChar = (int) (n % s.length());
            String remainingString = s.substring(0, endChar);
            pos = 0;
            countInOne = 0;
            while (pos < remainingString.length()){
                if (remainingString.charAt(pos) == 'a'){
                    countInOne++;
                }
                pos++;
            }
            totalCount += countInOne;
        }
        return totalCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
