package com.tbsm.projectla.utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldUtility {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public String getDecimal(String text) {
		StringBuilder sb = new StringBuilder();
		if(!text.contains("$") && !text.contains("%")) {
			String pattern = "[0-9]\\.[0-9]*";
			Matcher m = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE).matcher(text.replaceAll(",", ""));
			
			while (m.find()) {
				sb.append(m.group() + ",");					
		    }			
		}
		return sb.toString();
	 }
	
	public String getCurrency(String text) {
		StringBuilder sb = new StringBuilder();
		if(text.contains("$")) {
			String pattern = "(\\$)[0-9]+\\.*[0-9]*";
			Matcher m = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE).matcher(text.replaceAll(",", ""));
			
			while (m.find()) {
				sb.append(m.group().replaceAll("\\$", "") + ",");	
		    }			
		} 
		return sb.toString();
	}
	
	public String getPercent(String text) {
		StringBuilder sb = new StringBuilder();		
		if(text.contains("%")) {
			String pattern = "[0-9]+\\.*[0-9]*(\\%)";
			Matcher m = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE).matcher(text.replaceAll(",", ""));
			
			while (m.find()) {
				sb.append(m.group().replaceAll("\\%", "") + ",");	
		    }
		} 
		return sb.toString();
	}
	
	public String getDate(String text) {
		List<Date> allMatches = new ArrayList<>();
		
		allMatches.addAll( getMatch( text.replaceAll(" ", ""), "(0?[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d\\d", "MM/dd/yyyy" ) );
		allMatches.addAll( getMatch( text.replaceAll(" ", ""), "(0?[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d\\d", "MM/dd/yyyy" ) ); 
		allMatches.addAll( getMatch( text.replaceAll(" ", ""), "(0?[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])-(19|20)\\d\\d", "MM-dd-yyyy" ) );
		allMatches.addAll( getMatch( text.replaceAll(" ", ""), "(0?[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d\\d", "MM-dd-yy" ) );
		allMatches.addAll( getMatch( text.replaceAll(" ", ""), "(0?[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])-\\d\\d", "MM-dd-yy" ) );
		
		allMatches.addAll( getMatch( text.replaceAll(" ", ""), "(19|20)\\d\\d/(0?[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])", "yyyy/MM/dd" ) );
		allMatches.addAll( getMatch( text.replaceAll(" ", ""), "(19|20)\\d\\d-(0?[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])", "yyyy-MM-dd" ) );
				
		allMatches.addAll( getMatch( text.replaceAll(" ", ""), "(0[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/(19|20)\\d\\d", "dd/MM/yyyy" ) );
		allMatches.addAll( getMatch( text.replaceAll(" ", ""), "(0[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-(19|20)\\d\\d", "dd-MM-yyyy" ) );
		  
		allMatches.addAll( getMatch( text, "(0?[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(19|20)\\d\\d", "MMddyyyy" ) );
		allMatches.addAll( getMatch( text, "(0[1-9]|[12][0-9]|3[01])(0?[1-9]|1[0-2])(19|20)\\d\\d", "ddMMyyyy" ) );	
		allMatches.addAll( getMatch( text, "(0?[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])\\d\\d", "MMddyy" ) );
		allMatches.addAll( getMatch( text, "(0[1-9]|[12][0-9]|3[01])(0?[1-9]|1[0-2])\\d\\d", "ddMMyy" ) );
		
		allMatches.addAll( getMatch( text.replaceAll("Sept", "Sep"), "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec) (\\d{2}), (\\d{4})", "MMMM dd, yyyy" ) );
		
		allMatches.addAll( getMatch( text, "(January|February|March|April|May|June|July|August|September|October|November|December) (\\d{2}), (\\d{4})", "MMMM dd, yyyy" ) );
		
		allMatches.addAll( getMatch( text.replaceAll("Sept", "Sep"), "(\\d{2})-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec)-(\\d{4})", "dd-MMM-yyyy" ) );																			// 
		
		allMatches.addAll( getMatch( text.replaceAll("Sept", "Sep"), "(\\d{2})(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec)(\\d{4})", "ddMMMyyyy" ) );
		
		allMatches.addAll( getMatch( text.replaceAll("Sept", "Sep"), "(\\d{4})(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec)(\\d{2})", "yyyyMMMdd" ) );
		
		allMatches.addAll( getMatch( text, "(\\d{4}), (January|February|March|April|May|June|July|August|September|October|November|December) (\\d{2})", "yyyy, MMMM dd" ) );	
		allMatches.addAll( getMatch( text.replaceAll("Sept", "Sep"), "(\\d{4}), (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec) (\\d{2})", "yyy, MMMM dd" ) );
				
		allMatches.addAll( getMatch( text, "(\\d{2}) (January|February|March|April|May|June|July|August|September|October|November|December), (\\d{4})", "dd MMMM, yyyy" ) );																						// 27
		allMatches.addAll( getMatch( text.replaceAll("Sept", "Sep"), "(\\d{2}) (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec), (\\d{4})", "dd MMM, yyyy" ) );
		
		allMatches.addAll( getMatch( text.replaceFirst(",", ""), "(January|February|March|April|May|June|July|August|September|October|November|December) (\\d{4})", "MMMM yyyy" ) );																			 
		allMatches.addAll( getMatch( text.replaceFirst(",", ""), "(\\d{4}) (January|February|March|April|May|June|July|August|September|October|November|December)", "yyyy MMMM" ) );
		allMatches.addAll( getMatch( text.replaceFirst(",", "").replaceAll("Sept", "Sep"), "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec) (\\d{4})", "MMM yyyy" ) );																		 
		allMatches.addAll( getMatch( text.replaceFirst(",", "").replaceAll("Sept", "Sep"), "(\\d{4}) (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec)", "yyyy MMM" ) );
		
		allMatches.addAll( getMatch( text.replaceFirst(",", ""), "(January|February|March|April|May|June|July|August|September|October|November|December) (\\d{2})", "MMMM yy" ) ); 																	// 
		allMatches.addAll( getMatch( text.replaceFirst(",", ""), "(\\d{2}) (January|February|March|April|May|June|July|August|September|October|November|December)", "yy MMMM" ) ); 																// 
		allMatches.addAll( getMatch( text.replaceFirst(",", "").replaceAll("Sept", "Sep"), "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec) (\\d{2})", "MMM yy" ) ); 												// 
		allMatches.addAll( getMatch( text.replaceFirst(",", "").replaceAll("Sept", "Sep"), "(\\d{2}) (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Sep|Oct|Nov|Dec)", "yy MMM" ) ); 
		
		if(allMatches.isEmpty()) return null;
		
		StringBuilder sb = new StringBuilder();
		for(Date date : allMatches) {
			sb.append(DATE_FORMAT.format( date ) + ",");			
		}
		
		return sb.substring(0, sb.length() - 1);
	}
	
	private static List<Date> getMatch( String text, String pattern, String format ) {
		SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.US);
		List<Date> matches = new ArrayList<>();
		Matcher m = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE).matcher(text);

		try {
		    while (m.find()) {
		    	//matches.add( m.group() );
		    	matches.add( formatter.parse( m.group() ) );
		    }
		} catch (Exception e) {
			//System.out.println("********** " + m.group() + " **********");
		}
		return matches;
	}
}
