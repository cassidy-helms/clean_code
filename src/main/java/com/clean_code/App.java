package com.clean_code;

import java.util.Arrays;

import com.clean_code.args_refactor_4.Args;
import com.clean_code.args_refactor_4.exception.ArgsException;

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
            String[] fakeArgs = { "-l", "-p", "8080", "-d", "C:/home/code", "-x", "0.01", "-y", "1,2,3" };
            Args arg = new Args("l,p#,d*,x##,y[*]", fakeArgs);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            double db = arg.getDouble('x');
            String[] arr = arg.getStringArray('y');
            System.out.println("Logging: " + logging);
            System.out.println("Port: " + port);
            System.out.println("Directory: " + directory);
            System.out.println("Double: " + db);
            System.out.println("Array: ");
            Arrays.stream(arr).forEach(System.out::println);
        } catch(ArgsException e) {
            e.printStackTrace();
        }
    }
}
