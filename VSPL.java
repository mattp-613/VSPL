
import java.util.List;
import java.util.ArrayList;

import java.io.*;  
import java.util.Scanner;  


public class VSPL{

	public static List<String> read(String filename) throws Exception {
		
        List<Point3D> points= new ArrayList<Point3D>(); 
        double x,y,z;
    
        Scanner sc = new Scanner(new File(filename));  
        // sets the delimiter pattern to be , or \n \r
        sc.useDelimiter(",|\n|\r");  
    
        // skipping the first line x y z
        sc.next(); sc.next(); sc.next();
    
        // read points
        while (sc.hasNext())  
        {  
            x= Double.parseDouble(sc.next());
            y= Double.parseDouble(sc.next());
            z= Double.parseDouble(sc.next());
            points.add(new Point3D(x,y,z));  
        }   
    
        sc.close();  //closes the scanner  
    
        return points;
        }


    public static void main(String[] args){








    }

}