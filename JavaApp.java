package javaapplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodrigues rafael
 *
 * @since February, 25, 2020
 * @Belem-PA, Brasil
 * @see simple way to formatting String for date
 */
public class FormattingStringToDate {

    public static void main(String[] args) {

        try {
            String str = "19831020";
                /* 'October, 20, 1983' <<<-- returning like this from database */
            
                /* FIRST STEP - to use Class StringBuilder to split the string into date format */
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.insert(str.length() - 2, '-');
            stringBuilder.insert(str.length() - 4, '-');
            
            System.out.println(stringBuilder.toString()); 
                /* '1983-10-20' <<<-- output */
            
                /* SECOND STEP - to use the appropriate date format, according to split the string */
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = format.parse(stringBuilder.toString());
            
                /* THIRD STEP - formatting the output as desired */
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            String result = df.format(date);
            
            System.out.println(result); 
                /* '10/20/1983' <<<-- show on screen */
            
        } catch (ParseException ex) {
            Logger.getLogger(FormattingStringToDate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }