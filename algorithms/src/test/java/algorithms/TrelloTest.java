package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrelloTest {

    private static final String LETTERS = "acdegilmnoprstuw";

    @Test
    public void testHash() {
        assertEquals(680131659347L, hash("leepadg"));
    }

    @Test
    public void testSolver() {
        String word = "acd";
        long hash = hash(word);
        assertEquals(word, findWordFromHash(hash, word.length()));
    }

    @Test
    public void solveTrelloTest() {
        long hash = 25180466553932L;
        String word = findWordFromHash(hash, 8);
        System.out.println("The solution is " + word);
    }


    public String findWordFromHash(long hash, int wordLength) {
        return findWordFromHashInner(hash, new char[wordLength], 0);
    }

    private String findWordFromHashInner(long hash, char[] chars, int idx) {
        if (idx == chars.length) {
            String str = String.valueOf(chars);
            if (hash(str) == hash) {
                return str;
            }
            return null;
        }
        for (int i = 0; i < LETTERS.length(); i++) {
            chars[idx] = LETTERS.charAt(i);
            String combination = findWordFromHashInner(hash, chars, idx + 1);
            if (combination != null)
                return combination;
        }
        return null;
    }

    private long hash(String s) {
        long h = 7;

        for (int i = 0; i < s.length(); i++) {
            h = (h * 37 + LETTERS.indexOf(s.charAt(i)));
        }
        return h;
    }
}
