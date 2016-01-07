package com.zghome.testNGDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
	public void testProperties(String fileName) throws FileNotFoundException, IOException{
		Properties prop = new Properties();
		prop.load(new FileInputStream(fileName));
		System.out.println("aaaaaaaaaa");
	}
}
