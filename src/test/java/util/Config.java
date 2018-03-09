package util;

import java.io.*;
import org.ini4j.*;


public class Config {

	static Ini configINI = null;
	/**
	 * <b>Description</b> Loads Config .ini file and returns static ini. 
	 */
	private static Ini loadinifile() {
		configINI = new Ini();		
		try {
			InputStream file = Config.class.getResourceAsStream("/Config.ini");
			if(file==null) file= Config.class.getResourceAsStream("Config.ini");
			
			configINI.load(file);
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return configINI;
	}
	
	/*public static synchronized String get(String keyName){
		//ITestContext
		//String keyValue = context.getCurrentXmlTest().getParameter("selenium.host");
		
		//return (keyValue==null)	? ""	: keyValue;
		return "";
	}*/
	
	public static synchronized String get(String sectionName, String keyName){
		if(configINI == null){
			configINI = loadinifile();
		}
		
		String keyValue = configINI.get(sectionName, keyName);
		
		return (keyValue==null)	? ""	: keyValue;
	}
	
	public static synchronized String get(String sectionName, String keyName, String defaultValue){
		if(configINI == null){
			configINI = loadinifile();
		}
		
		String keyValue = configINI.get(sectionName, keyName);
		
		return (keyValue==null || keyValue=="")	? defaultValue : keyValue;
	}
}