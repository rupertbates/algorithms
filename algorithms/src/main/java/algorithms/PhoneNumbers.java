package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhoneNumbers {
    HashMap<String, String[]> data = new HashMap<String, String[]>();

    public PhoneNumbers() {
        data.put("0", new String[]{"0"});
        data.put("1", new String[]{"1"});
        data.put("2", new String[]{"a", "b", "c"});
        data.put("3", new String[]{"d", "e", "f"});
        data.put("4", new String[]{"g", "h", "i"});
        data.put("5", new String[]{"j", "k", "l"});
        data.put("6", new String[]{"m", "n", "o"});
        data.put("7", new String[]{"p", "q", "r", "s"});
        data.put("8", new String[]{"t", "u", "v"});
        data.put("9", new String[]{"w", "x", "y", "z"});
    }


    /**
     * Get an array of all the possible characters for each of the input digits
     * this method has a complexity of O(n3)
     * @param input
     * @return
     */
    String[][] getCandidates(String[] input) {
        String[][] candidates = new String[input.length][];
        for (int i = 0; i < input.length; i++) {
            candidates[i] = data.get(input[i]);
        }
        return candidates;
    }


    List<String> getCombinations(String[] input) {
        String[][] candidates = getCandidates(input);

        //Create a list to hold the combinations
        List<String> combinations = new ArrayList<String>();

        //Add each possibility for the first digit to the list of combinations
        Collections.addAll(combinations, candidates[0]);

        //for each of the remaining digits, combine its possibilities with
        //those already in the list of possible combinations
        for (int i = 1; i < candidates.length; i++) {
            String[] candidate = candidates[i];
            combinations = combine(combinations, candidate);
        }
        return combinations;
    }

    /**
     * Combine a list of possible digits with a list of precombined possibilities
     * to return
     * @param current
     * @param candidates
     * @return
     */
    List<String> combine(List<String> current, String[] candidates) {
        List<String> result = new ArrayList<String>();
        for (String combination : current) {
            for (String candidate : candidates) {
                result.add(combination + candidate);
            }
        }
        return result;
    }
}
