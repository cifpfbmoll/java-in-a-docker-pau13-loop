package edu.pingpong.javaindocker.domain.regex;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RomanNumberTest {

    // RULES TO TEST ROMAN NUMBERS
    /**
     * M, C, X and I can be appear from one to three consecutive times (just on
     * summative)
     * 
     * I just can be behind V or X X just can be behind L or C C just can be behind
     * D or M
     */

    private RomanNumber romanNumber;

    @Before
    public void setUpRomanNumber() {
        romanNumber = new RomanNumber();
        romanNumber.initRegexDictionary();

    }

    // SETTERS AND GETTERS

    @Test
    public void testGetNumbers() {
        romanNumber.setRomanNum("XX");
        romanNumber.setDecimalNum(150);

        assertEquals("XX", romanNumber.getRomanNum());
        assertEquals(150, romanNumber.getDecimalNum());
    }

    // SUMMATIVE GROUP I

    @Test
    public void testOnes_I_summative() {

        // Possible cases
        String caseOne = "I";
        String caseTwo = "II";
        String caseThree = "III";
        String caseRandom = "WIRRI"; // II --> 0

        // Case I
        romanNumber.setRomanNum(caseOne);
        assertEquals(1, romanNumber.toDecimal());

        // Case II
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseTwo);
        assertEquals(2, romanNumber.toDecimal());

        // Case III
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseThree);
        assertEquals(3, romanNumber.toDecimal());

        // Case Random
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseRandom);
        assertEquals(0, romanNumber.toDecimal());
    }

    // SUBSTRACTIVE GROUP IV

    @Test
    public void testFour_IV_substractive() {

        String caseFour = "IV";
        String caseRandom = "WRIVRR"; // IV --> 0

        // Case IV
        romanNumber.setRomanNum(caseFour);
        assertEquals(4, romanNumber.toDecimal());

        // Case Random
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseRandom);
        assertEquals(0, romanNumber.toDecimal());
    }

    // SUMMATIVE GROUP V and X

    @Test
    public void testFive_V_ten_X_summative() {

        String caseFive = "V";
        String caseTen = "X";
        String caseFifteen = "XV";
        String caseThirteen = "XXX";
        String caseRandomFive = "WVWW"; // V --> 0

        // Case V
        romanNumber.setRomanNum(caseFive);
        assertEquals(5, romanNumber.toDecimal());

        // Case X
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseTen);
        assertEquals(10, romanNumber.toDecimal());

        // Case XV
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseFifteen);
        assertEquals(15, romanNumber.toDecimal());

        // Case XXX
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseThirteen);
        assertEquals(30, romanNumber.toDecimal());

        // Case Random
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseRandomFive);
        assertEquals(0, romanNumber.toDecimal());
    }

    // SUMMATIVE GROUP L and C
    @Test
    public void testFifty_L_hundred_C_summative() {

        String caseFifty = "L";
        String caseHundred = "C";
        String caseThreeHundred = "CCC";
        String caseRandomMix = "QRCWWL"; // CL --> 0

        // Case L
        romanNumber.setRomanNum(caseFifty);
        assertEquals(50, romanNumber.toDecimal());

        // Case C
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseHundred);
        assertEquals(100, romanNumber.toDecimal());

        // Case CCC
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseThreeHundred);
        assertEquals(300, romanNumber.toDecimal());

        // Case Random
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseRandomMix);
        assertEquals(0, romanNumber.toDecimal());
    }

    // SUBSTRACTIVE GROUP XL and XC
    @Test
    public void test_XL_XC_substractive() {

        String caseXL = "XL";
        String caseXC = "XC";

        // Case XL
        romanNumber.setRomanNum(caseXL);
        assertEquals(40, romanNumber.toDecimal());

        // Case XC
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseXC);
        assertEquals(90, romanNumber.toDecimal());
    }

    @Test
    public void test_D_M_summative() {

        String caseD = "D";
        String caseM = "M";
        String caseMMM = "MMM";

        // Case D
        romanNumber.setRomanNum(caseD);
        assertEquals(500, romanNumber.toDecimal());

        // Case M
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseM);
        assertEquals(1000, romanNumber.toDecimal());

        // Case MMM
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseMMM);
        assertEquals(3000, romanNumber.toDecimal());
    }

    // SUBSTRACTIVE GROUP CD and CM
    @Test
    public void test_CD_CM_substractive() {

        String caseCD = "CD";
        String caseCM = "CM";

        // Case CD
        romanNumber.setRomanNum(caseCD);
        assertEquals(400, romanNumber.toDecimal());

        // Case CM
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseCM);
        assertEquals(900, romanNumber.toDecimal());
    }

    // Possible Roman Numbers Combinations
    @Test
    public void testRomanNumMix() {

        String caseMix1 = "MMCDLXXIV";
        String caseMix2 = "CCXLVIII";
        String caseMix3 = "MMCMXLIV";
        String caseMix4 = "DCXLIX";

        // Case MMCDLXXIV
        romanNumber.setRomanNum(caseMix1);
        assertEquals(2474, romanNumber.toDecimal());

        // Case CCXLVIII
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseMix2);
        assertEquals(248, romanNumber.toDecimal());

        // Case MMCMXLIV
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseMix3);
        assertEquals(2944, romanNumber.toDecimal());

        // Case CM
        romanNumber.setDecimalNum(0);
        romanNumber.setRomanNum(caseMix4);
        assertEquals(649, romanNumber.toDecimal());
    }
}
