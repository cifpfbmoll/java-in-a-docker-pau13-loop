package edu.pingpong.javaindocker.domain.regex;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ValidationRomanNumTest {

    private RomanNumber romanNumber;

    @Before
    public void setUpRomanNumber() {
        romanNumber = new RomanNumber();
    }

    // Check for the first three numbers
    // Check that is able to start with any combination of three numbers following
    // the numeric roman standarts
    @Test
    public void testFirstThreeNumbers() {

        String caseI = "III";
        String caseX = "XXX";
        String caseC = "CCC";
        String caseM = "MMM";
        String failMoreThanThree = "CCCC";

        romanNumber.setRomanNum(caseI);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(caseX);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(caseC);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(caseM);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(failMoreThanThree);
        assertEquals(false, romanNumber.romanNumValidation());
    }

    // Check for the first non three consecutive numbers
    // Check that is possible to start with any substractive combination
    @Test
    public void testFirstNonConsecutive() {

        String caseIV = "IV";
        String caseIX = "IX";
        String caseXL = "XL";
        String caseXC = "XC";
        String caseCD = "CD";
        String caseCM = "CM";
        String fail1 = "DM";
        String fail2 = "XR";

        romanNumber.setRomanNum(caseIV);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(caseIX);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(caseXL);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(caseXC);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(caseCD);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(caseCM);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(fail1);
        assertEquals(false, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(fail2);
        assertEquals(false, romanNumber.romanNumValidation());
    }

    @Test
    public void checkRandomCases() {

        String case1 = "DXXXIII";
        String case2 = "CCCXCIX";
        String case3 = "MMCMLXXIV";
        String fail1 = "MMDCIVIII";
        String fail2 = "CDXLLIV";
        String fail3 = "CCCXLIVII";

        romanNumber.setRomanNum(case1);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(case2);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(case3);
        assertEquals(true, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(fail1);
        assertEquals(false, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(fail2);
        assertEquals(false, romanNumber.romanNumValidation());
        romanNumber.setRomanNum(fail3);
        assertEquals(false, romanNumber.romanNumValidation());
    }
}

