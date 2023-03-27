
import java.util.List;
import java.util.ArrayList;

import java.io.*;  
import java.util.Scanner;  


public class VSPL{

	public static List<String> read(String filename) throws Exception {
		
        List<String> text = new ArrayList<String>(); 
    
        Scanner sc = new Scanner(new File(filename));  
        // sets the delimiter pattern to be every new line
        //sc.useDelimiter("\n");
    
        // read points
        while (sc.hasNext())  
        {  
            String x = sc.next();
            text.add(x);  
        }   
    
        sc.close();  //closes the scanner  
    
        return text;
        }


    public static void main(String[] args)throws Exception {

        String file = new String("input1.txt");
        
        try {
            file = args[0];
        } catch (Exception e) {
            // TODO: handle exception
            ;
        }

        List<String> textList = new ArrayList<String>(); 
        textList = read(file);
        System.out.println("Grammar: \n\n"+textList);

        



    }

}