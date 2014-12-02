package algorithms;

import org.junit.Test;

public class PhoneNumbersTest {
    @Test
    public void testPhoneNumbers(){
        String[] input = new String[]{"0", "2", "3", "5"};
        for (String s : new PhoneNumbers().getCombinations(input)) {
            System.out.println(s);
        }
    }
}
