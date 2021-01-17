package substringsearch;

import entity.Result;

import javax.annotation.Nonnull;

public class KMPSubstringSearchWithTextPreparationAlgorithm extends AbstractSubstringSearchWithTextPreparationAlgorithm {
    private static final int R = 256;

    @Override
    protected Result searchImpl(@Nonnull String pattern) {
        int[] possibleResults = getPossibleResults(pattern.charAt(0));
        long start = System.currentTimeMillis();
        int[][] dfa;
        int m = pattern.length();
        dfa = new int[R][m];
        dfa[pattern.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];
            }
            dfa[pattern.charAt(j)][j] = j + 1;
            x = dfa[pattern.charAt(j)][x];
        }

        int n = text.length();
        int i, j, k;
        for (k = 0, j = 0, i = possibleResults[k]; i < n && j < m;) {
            j = dfa[text.charAt(i)][j];
            if (j == 0 && k < possibleResults.length - 1) {
                do {
                    k++;
                }   while (i > possibleResults[k]);
                i = possibleResults[k];
            } else {
                i++;
            }
        }
        if (j == m) {
            return Result.of(i - m, System.currentTimeMillis() - start);
        }
        return Result.of(-1, System.currentTimeMillis() - start);
    }
}