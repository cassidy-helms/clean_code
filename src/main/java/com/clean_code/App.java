package com.clean_code;

import java.text.ParseException;

import com.clean_code.args_refactor_2.Args;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        try {
            String[] fakeArgs = { "-l", "-p", "8080", "-d", "C:/home/code" };
            Args arg = new Args("l,p#,d*", fakeArgs);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            System.out.println("Logging: " + logging);
            System.out.println("Port: " + port);
            System.out.println("Directory: " + directory);
        } catch(ParseException e) {
            e.printStackTrace();
        }
    }
}
