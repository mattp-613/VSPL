
import java.util.List;
import java.util.ArrayList;

import java.io.*;  
import java.util.Scanner;  

public class VSPL{

    static List<String> text;
    static int index;
    static String token;
    static boolean error;

    VSPL(){
        //this.text = text;
        //index = 0;
        //token = text.get(index);
    }

    public static void parseText(List<String> inputText){

        text = inputText;
        index = 0;
        token = text.get(index);
        error = false;

        System.out.println("Parsing grammar...");

        program();

        if (!error){
            System.out.println("SUCCESS");
        }
        else{
            System.out.println("ERROR");
        }
    }

    private static void iterateToken(){
        index++;
        token = text.get(index);
    }

    private static String program(){

        if(token.equals("{")){
            iterateToken();

            if(!token.equals("}"){ //if it doesnt end with a }
                error = true;
            }
        }

        else{ //if it doesn't start with a {
            error = true;
        }

        return null;
    }

    private static String statement_list(){
        return null;
    }

    private static String statement(){
        return null;
    }

    private static String procedure_call(){
        return null;
    }

    private static String parameters(){
        return null;
    }

    private static String expression(){
        return null;
    }

    private static String factor(){
        return null;
    }



	private static List<String> read(String filename) throws Exception {
		
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

        for(int i = 0;i < textList.size(); i++){
            String token = textList.get(i);

            System.out.println("\n");
            System.out.println("Current Token: "+token);



        }

        VSPL vspl = new VSPL();
        
        vspl.parseText(textList);
    }

}