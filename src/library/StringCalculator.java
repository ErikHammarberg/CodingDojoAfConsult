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

        Pattern delimiterPattern = Pattern.compile("^//.+\\n");
        Matcher delimiterMatcher = delimiterPattern.matcher(input);
        String delimiter;
        String stringToParse;

        if(delimiterMatcher.find()){
            int positionToParseFrom = delimiterMatcher.end();

            delimiter = delimiterMatcher.group().substring(2, positionToParseFrom - 1);
            stringToParse = input.substring(positionToParseFrom);
            
        }
        else {
            delimiter = ",|\n";
            stringToParse = input;
        }
        String[] result = {delimiter, stringToParse};
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
