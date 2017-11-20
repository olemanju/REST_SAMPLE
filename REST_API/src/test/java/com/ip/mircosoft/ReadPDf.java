package com.ip.mircosoft;

import java.io.IOException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class ReadPDf {

	  public static void main(String[] args) {
	        try {
	        	
	        	String path1="C:\\Users\\mramasw2\\git\\REST_FINAL\\REST_API\\src\\test\\resources\\Testdata\\readpdf.pdf";
	           //The line below creates a PdfReader which we will use to read the PDF file (change the location of the PDF file as per your environment):  
	            PdfReader reader = new PdfReader(path1);
	            
	            //The line below gets the number of pages in the PDF:
	            System.out.println("This PDF has "+reader.getNumberOfPages()+" pages.");
	            
	            //The line below gets the content of the PDF for the specified page number. The content is returned as String:
	            String page = PdfTextExtractor.getTextFromPage(reader, 2);
	            
	            // The line below gets the content of the PDF for the specified page number. The content is returned as String:
	            System.out.println("Page Content:\n\n"+page+"\n\n");
	            
	            //The line below can be used to check if the document was changed in any way:
	            System.out.println("Is this document tampered: "+reader.isTampered());
	            
	            //The line below checks if the document is encrypted:
	            System.out.println("Is this document encrypted: "+reader.isEncrypted());
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	    }
	 
}
