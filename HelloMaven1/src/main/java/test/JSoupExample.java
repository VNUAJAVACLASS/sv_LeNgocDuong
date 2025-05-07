package test;

import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;

public class JSoupExample {  
   public static void main( String[] args ) throws IOException{  
	   Document doc = Jsoup.connect("http://facebook.com").get();  
       String title = doc.title();  
       System.out.println("Title : " + title);  
   }  
}