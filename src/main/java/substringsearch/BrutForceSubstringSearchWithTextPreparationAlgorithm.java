package substringsearch;

import entity.Result;

import javax.annotation.Nonnull;

public class BrutForceSubstringSearchWithTextPreparationAlgorithm extends AbstractSubstringSearchWithTextPreparationAlgorithm {
    @Override
    protected Result searchImpl(@Nonnull String pattern) {
        int[] possibleResults = getPossibleResults(pattern.charAt(0));
        long start = System.currentTimeMillis();
        int m = pattern.length();
        for (int k = 0; k < possibleResults.length; k++) {
            int i = possibleResults[k];
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return Result.of(i, System.currentTimeMillis() - start);
            }
        }
        return Result.of(-1, System.currentTimeMillis() - start);
    }
}
