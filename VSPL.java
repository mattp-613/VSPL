
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
        System.out.println("Parsing: " + token);

        program();

        if (!error){
            System.out.println("SUCCESS");
        }
        else{
            System.out.println("ERROR");
        }
    }

    private static void iterateToken(){
        if(index >= text.size()){
            index = text.size();
        }
        else{
        index++;
        token = text.get(index);
        }

        System.out.println("Parsing: " + token);
    }

    private static void program(){

        if(!token.equals("{")){
            error = true;
        }
        iterateToken();
        statement_list();
        if(!token.equals("}")){ //if it doesnt end with a }
            error = true;
        }
        //iterateToken(); //check for any extra text after it ends
        if(!token.equals("}")){ //if it doesnt end with a }
        error = true;
        }

        //return null;
    }

    private static void statement_list(){
        statement();
        if(!token.equals(";")){
            error = true;
        }
        statement_list_prime();
    }

    private static void statement_list_prime(){
        
        if(!token.equals("$") | !token.equals("}")){
            statement();
            if(!token.equals(";")){
                error = true;
            }
        }

    }

    private static void statement(){
        boolean call = false;
        if(!token.equals("call") || !token.equals("compute")){
            error = true;
        }
        if(token.equals("call")){ //to determine whether the next operation will be call or compute
            call = true;
        }
        iterateToken();
        if(!token.equals(":")){
            error = true;
        }

        //after this point, we will assume if there was an error that it would be a computation, not a call
        //so by default if the grammar is wrong and we don't know whether to call or compute, we compute

        if(call){
            procedure_call();
        }
        else{
            expression();
        }
        
    }

    private static void procedure_call(){
        //return null;
    }

    private static void parameters(){
        //return null;
    }

    private static void expression(){
        //return null;
    }

    private static void factor(){
        //return null;
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