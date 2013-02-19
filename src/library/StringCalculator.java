/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

import java.security.InvalidParameterException;
import java.util.regex.*;
/**
 *
 * @author slaeggan
 */
public class StringCalculator {

    private String[] calculateDelimiter(String input) {

        String[] result = new String[2];
        Pattern delimiterPattern = Pattern.compile("^//.+\\n");
        Matcher delimiterMatcher = delimiterPattern.matcher(input);

        if(delimiterMatcher.find()){
            int positionToParseFrom = delimiterMatcher.end();
            result[0] = delimiterMatcher.group().substring(2, positionToParseFrom - 1);
            result[1] = input.substring(positionToParseFrom);
        }
        else {
            result[0] = ",|\n";
            result[1] = input;
        }
        
        return result;
    }
    public int add(String input){
        if(input.length() == 0){
            return 0;
        }
        int result = 0;
        boolean negativeNumbers = false;
        String[] delimiterResult = calculateDelimiter(input);

        String negatives = "";
        String delimiter = delimiterResult[0];
        String numberString = delimiterResult[1];
        
        String[] numbers = numberString.split(delimiter);
        for(String number : numbers){
            int tuple = Integer.parseInt(number);
            if (tuple >= 0){
                result += tuple;
            }
            else {
                negativeNumbers = true;
                negatives += " " + tuple;
            }
        }
        if (negativeNumbers)
        {
            throw new InvalidParameterException("negatives not allowed:"+ negatives);
        }
        return result;
    }
}
