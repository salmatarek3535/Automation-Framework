package wrappers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader
{
	static String propertiesFilePath="testData.properties";
	public static Properties properties= new Properties();
	
	static
	{

		FileInputStream propertiesFile=null;
		try {
			propertiesFile= new FileInputStream(propertiesFilePath);
			properties.load(propertiesFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				propertiesFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getValue(String key)
	{
		try{
			return properties.getProperty(key);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}

	}

}
