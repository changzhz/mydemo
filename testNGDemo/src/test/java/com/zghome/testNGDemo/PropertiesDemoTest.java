package com.zghome.testNGDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.ITestObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

@PrepareForTest(value = {PropertiesDemo.class})
public class PropertiesDemoTest extends PowerMockTestCase{
	
	@ObjectFactory
	public ITestObjectFactory getObjectFactory() {
		return new PowerMockObjectFactory();
	}
	
	@Test
	public void testProp(){
		Properties prop = Mockito.mock(Properties.class);
		FileInputStream input = Mockito.mock(FileInputStream.class);
		try {
			
			PowerMockito.whenNew(FileInputStream.class).withArguments("12345").thenReturn(input);
			PowerMockito.whenNew(Properties.class).withNoArguments().thenReturn(prop);
			PowerMockito.doNothing().when(prop).load(input);
			PropertiesDemo demo = new PropertiesDemo();
			demo.testProperties("12345");
			Mockito.verify(prop).load(new FileInputStream("12345"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
}
