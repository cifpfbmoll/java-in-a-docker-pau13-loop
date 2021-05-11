package edu.pingpong.javaindocker.domain.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.pingpong.javaindocker.domain.enums.RomanSymbol;

public class RomanNumber {

    private String romanNum = null;
    private int decimalNum = 0;

    private RegexRomanNumber regex = new RegexRomanNumber();

    // Construcotr Overloading
    public RomanNumber() {
    }

    public RomanNumber(String romanNum) {
        this.romanNum = romanNum;
    }

    // SETTERS
    public void setRomanNum(String romanNum) {
        this.romanNum = romanNum;
    }

    public void setDecimalNum(int decimalNum) {
        this.decimalNum = decimalNum;
    }

    // GETTERS
    public String getRomanNum() {
        return this.romanNum;
    }

    public int getDecimalNum() {
        return this.decimalNum;
    }

    // GET REGEX
    public RegexRomanNumber getRegexDictionary() {
        return this.regex;
    }

    // INIT Regex Dictionary
    public void initRegexDictionary() {
        getRegexDictionary().addRegex("Summative", "(?<!I)[VX](?![CL])|I(?![VX])|(?<!X)[CL](?![DM])|(?<!C)[DM]");

        /**
         * INITIAL MISTAKE making the substractory group, it takes one by one when their
         * substractive and added to the result instead of take the substractive group
         * together and added to it like a group
         * 
         * First substractive created -->
         * "I(?=[VX])|(?<=I)[VX]|X(?=[CL])|(?<=X)[CL]|C(?=[DM])|(?<=C)[DM]"
         * 
         * The correct substractive group is the one it appears below this comment
         */
        getRegexDictionary().addRegex("Substractive", "I[VX]|X[LC]|C[DM]");
    }

    /// SUMMATIVE ///

    // Avoid summative that should be substractive
    // (I!<?V) or I(?!V) --> not match IV
    // I(?!X) --> not match IX
    // SIMPLIFY I(?![VX]) --> not match IV or IX

    // X(?!L) --> not match XL
    // X(?!C) --> not match XC
    // SIMPLIFY X(?![LC]) not match XL or XC

    // X(?!D) --> not match CD
    // X(?!M) --> not match CM
    // SIMPLIFY C(?![DM]) --> not match CD or CM

    // NEGATIVE LOOKBEHIND
    // Add summative regex
    // (?<!C)[MD] --> match M or D not preceed by C
    // (?<!X)[CL] --> match C or L not preceed by X
    // (?<!I)[XV] --> match X or V not preceed by I

    // NEGATIVE LOOKAHEAD
    // Add summative ones I
    // I(?![VX]) --> match I not followed by X or V

    /// SUBSTRACTIVE ///

    // I([VX]) --> match IV or IX
    // X([LC]) --> match XL or XC
    // C([DM]) --> match CD or CM

    // COMPILE AND MATCH
    public Matcher createMatcher(String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.romanNum);
        return matcher;
    }

    // GET Decimal Value
    private int decimalValue(String romanNum) {
        RomanSymbol symbol = Enum.valueOf(RomanSymbol.class, String.valueOf(romanNum));
        return symbol.getDecimalValue();
    }

    public void sumatoryToDecimal(Matcher matcher) {
        while (matcher.find()) {
            this.decimalNum += decimalValue(matcher.group());
        }
    }

    public int toDecimal() {
        if (romanNumValidation()) {
            for (String regex : getRegexDictionary().getValueRegex()) {
                Matcher matcher = createMatcher(regex);
                sumatoryToDecimal(matcher);
            }
        } else {
            return 0;
        }
        return getDecimalNum();
    }

    // Should add a regex to test if the Roman Number introduced is a valid roman
    // number

    /**
     * ===== RULES ===== - X, C and M can be 3 consecutive times - V, L and D can
     * NOT be 3 consecutive times - V can NOT be substractive
     * 
     */

    public boolean romanNumValidation() {
        return getRomanNum().matches("^(M{0,3})(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

        // ATTEMPTS

        // ^(M{0,3})(D)(C[DM])(C{0,3})(L)(X[LC])(X{0,3})(I[XV])(V)(I{0,3})

        // ^(M{0,3})|C(?=[MD])(C{0,3})\S

        // MMDCDCCLXLXXIVVIII
        // ^(M{0,3})(C[DM])(D?C{0,3})(X[LC])(L?X{0,3})(I[XV])(V?I{0,3})

        // Not following the roman numeration standart
        // MCMDDCDCCXCLL
        // ^(M{0,3})(C[MD])(D{0,3})(CD)(C{0,3})(XC)(L{0,3})
    }
}

