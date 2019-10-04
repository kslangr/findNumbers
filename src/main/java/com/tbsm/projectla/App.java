package com.tbsm.projectla;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import com.tbsm.projectla.models.Numbers;
import com.tbsm.projectla.utility.FieldUtility;

/**
 * Date Information from Document
 *
 */
public class App {
private static final String testFile = "test.pdf";
	
	public static void main( String[] args ) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource(testFile).getFile());
		
		//System.out.println(readPdfDocument(file));
		
		// Breaking Document up by Rows in ArrayList
		List<String> rows = Arrays.asList(readPdfDocument(file).split("\\r?\\n|\\r"));
		
		
		// Find All Rows with Numbers in them, NOT Percents or Currency
		Map<String, String> foundStuff = new HashMap<>();
		for(String text : rows) {
			String foundIt = new FieldUtility().getDecimal(text);
			if( foundIt != null ) {
				foundStuff.put(foundIt, text);
			}
		}
				
		// Print out rows with Number Fields in them
		System.out.println(" ************************************* ");
		foundStuff.forEach((found, text) -> {
			System.out.println("Found: " + found + " --- " + text);
		});
		
		// Search for Numbers in the Document and add to List
		// Process Document to Numbers
		Numbers numbers = new FindNumbers(foundStuff).processNumbers();
						
		// Print Output
		System.out.println( numbers.toString() );
	}

	private static String readPdfDocument(File file) {
    	try ( PDDocument document = PDDocument.load(file) ) {
       		document.getClass();
               
            if (!document.isEncrypted()) {            
            	PDFTextStripper stripper = new PDFTextStripper();
                return stripper.getText(document).trim();
            }

    	} catch (InvalidPasswordException e) {           
    		e.printStackTrace();
        } catch (IOException e) {           
            e.printStackTrace();
        }
    	return null;
    } 
}