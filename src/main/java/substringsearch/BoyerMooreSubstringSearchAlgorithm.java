package substringsearch;

import entity.Result;

import javax.annotation.Nonnull;

public class BoyerMooreSubstringSearchAlgorithm extends AbstractSubstringSearchAlgorithm {
    private static final int R = 256;

    @Override
    protected Result searchImpl(@Nonnull String pattern) {
        int[] right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;
        for (int j = 0; j < pattern.length(); j++)
            right[pattern.charAt(j)] = j;

        long start = System.currentTimeMillis();
        int m = pattern.length();
        int n = text.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = Math.max(1, j - right[text.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) return Result.of(i, System.currentTimeMillis() - start);
        }
        return Result.of(-1, System.currentTimeMillis() - start);
    }
}
