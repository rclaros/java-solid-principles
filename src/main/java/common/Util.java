package common;

import java.util.Properties;

public class Util {
	public static void outputInLine(String message) {
		System.out.print(message);
	}

	public static void output(String message) {
		System.out.println(message);
	}
	
	public static String getPropertyValue(String configPropertiesName, String propertyKey) throws Exception
    {
		String value = "";		
    	try {
    		Properties properties = new Properties();
    		properties.load(ClassLoader.getSystemResourceAsStream(configPropertiesName));
    		value = properties.getProperty(propertyKey);
    	} catch(Exception ex) {
    		throw ex;
    	}
    	return value;
    }
}