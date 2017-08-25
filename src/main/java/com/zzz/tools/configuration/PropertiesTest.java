package com.zzz.tools.configuration;

import java.util.Properties;

import junit.framework.TestCase;

/**
 * TODO Comment of PropertiesTest
 * 
 * @author dengsilinming
 * @version $Id: PropertiesTest.java 2013-1-30 下午1:40:52 $
 */
public class PropertiesTest extends TestCase {

	OperateProperties jProperties;
	String key = "helloworld.title";
	String value = "Hello World!";

	public void testLoadProperties() throws Exception {
		String name = null;
		Properties p = new Properties();

		name = "F:/workspace/DailyPractise/src/com/dengsilinming/read/properties/localeProperties.properties";
		p = OperateProperties.loadProperties(name,
				OperateProperties.BY_PROPERTIES);
		assertEquals(value, p.getProperty(key));

		name = "com.dengsilinming.read.properties";
		p = OperateProperties.loadProperties(name,
				OperateProperties.BY_RESOURCEBUNDLE);
		assertEquals(value, p.getProperty(key));
		assertEquals(value,
				((OperateProperties.ResourceBundleAdapter) p).getString(key));

		name = "F:/workspace/DailyPractise/src/com/dengsilinming/read/properties/localeProperties.properties";
		p = OperateProperties.loadProperties(name,
				OperateProperties.BY_PROPERTYRESOURCEBUNDLE);
		assertEquals(value, p.getProperty(key));
		assertEquals(value,
				((OperateProperties.ResourceBundleAdapter) p).getString(key));

		name = "\\com\\dengsilinming\\read\\properties\\localeProperties.properties";
		p = OperateProperties.loadProperties(name,
				OperateProperties.BY_SYSTEM_CLASSLOADER);
		assertEquals(value, p.getProperty(key));

		name = "\\com\\dengsilinming\\read\\properties\\localeProperties.properties";
		p = OperateProperties.loadProperties(name,
				OperateProperties.BY_CLASSLOADER);
		assertEquals(value, p.getProperty(key));

		name = "\\properties\\localeProperties.properties";
		p = OperateProperties.loadProperties(name, OperateProperties.BY_CLASS);
		assertEquals(value, p.getProperty(key));
	}
}

/*在日常使用中经常会读取properties文件，现在把自己在网上搜集的一些java读取properties的方法汇总如下：

1、使用java.util.Properties类的load()方法
如： 
[java] view plaincopy
InputStream is = new BufferedInputStream(new FileInputStream(new File(properties文件所在路径));  
Properties properties = new Properties();  
properties.load(is);  
2、使用java.util.ResourceBundle类的getBundle()方法
如：
[java] view plaincopy
ResourceBundle rb = ResourceBundle.getBundle(name, Locale.getDefault());  
3、使用java.util.PropertyResourceBundle类的构造函数
如： 
[java] view plaincopy
InputStream is = new BufferedInputStream(new FileInputStream(name));  
ResourceBundle rb = new PropertyResourceBundle(is);  
4、使用class变量的getResourceAsStream()方法
如： 
[java] view plaincopy
InputStream in = 类名.class.getResourceAsStream(name);  
Properties p = new Properties();  
p.load(in);  
5、使用class.getClassLoader()所得到的java.lang.ClassLoader的getResourceAsStream()方法
如：
[java] view plaincopy
 InputStream in = 类名.class.getClassLoader().getResourceAsStream(name);  
Properties p = new Properties();  
p.load(in);  
6、使用java.lang.ClassLoader类的getSystemResourceAsStream()静态方法
如： 
[java] view plaincopy
InputStream in = ClassLoader.getSystemResourceAsStream(name);  
Properties p = new Properties();  
p.load(in);  */