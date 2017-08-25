package com.zzz.tools.configuration;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * TODO Comment of JProperties
 * 
 * @author dengsilinming
 * @version $Id: JProperties.java 2013-1-30 下午1:34:32 $
 */
public class OperateProperties {
	public final static int BY_PROPERTIES = 1;
	public final static int BY_RESOURCEBUNDLE = 2;
	public final static int BY_PROPERTYRESOURCEBUNDLE = 3;
	public final static int BY_CLASS = 4;
	public final static int BY_CLASSLOADER = 5;
	public final static int BY_SYSTEM_CLASSLOADER = 6;

	public final static Properties loadProperties(final String name,
			final int type) throws IOException {
		Properties p = new Properties();
		InputStream in = null;
		if (type == BY_PROPERTIES) {
			in = new BufferedInputStream(new FileInputStream(name));
			assert (in != null);
			p.load(in);
		} else if (type == BY_RESOURCEBUNDLE) {
			ResourceBundle rb = ResourceBundle.getBundle(name, Locale.ENGLISH);
			assert (rb != null);
			p = new ResourceBundleAdapter(rb);
		} else if (type == BY_PROPERTYRESOURCEBUNDLE) {
			in = new BufferedInputStream(new FileInputStream(name));
			assert (in != null);
			ResourceBundle rb = new PropertyResourceBundle(in);
			p = new ResourceBundleAdapter(rb);
		} else if (type == BY_CLASS) {
			assert (OperateProperties.class.equals(new OperateProperties()
					.getClass()));
			in = OperateProperties.class.getResourceAsStream(name);
			assert (in != null);
			p.load(in);
			// return new JProperties().getClass().getResourceAsStream(name);
		} else if (type == BY_CLASSLOADER) {
			assert (OperateProperties.class.getClassLoader()
					.equals(new OperateProperties().getClass().getClassLoader()));
			in = OperateProperties.class.getClassLoader().getResourceAsStream(
					name);
			assert (in != null);
			p.load(in);
			// return new
			// JProperties().getClass().getClassLoader().getResourceAsStream(name);
		} else if (type == BY_SYSTEM_CLASSLOADER) {
			in = ClassLoader.getSystemResourceAsStream(name);
			assert (in != null);
			p.load(in);
		}

		if (in != null) {
			in.close();
		}
		return p;
	}

	public static class ResourceBundleAdapter extends Properties {
		/** 
         *  
         */
		private static final long serialVersionUID = 1L;

		public ResourceBundleAdapter(ResourceBundle rb) {
			assert (rb instanceof java.util.PropertyResourceBundle);
			this.rb = rb;
			Enumeration<String> e = rb.getKeys();
			while (e.hasMoreElements()) {
				Object o = e.nextElement();
				this.put(o, rb.getObject((String) o));
			}
		}

		private ResourceBundle rb = null;

		public ResourceBundle getBundle(String baseName) {
			return ResourceBundle.getBundle(baseName);
		}

		public ResourceBundle getBundle(String baseName, Locale locale) {
			return ResourceBundle.getBundle(baseName, locale);
		}

		public ResourceBundle getBundle(String baseName, Locale locale,
				ClassLoader loader) {
			return ResourceBundle.getBundle(baseName, locale, loader);
		}

		public Enumeration<?> getKeys() {
			return rb.getKeys();
		}

		public Locale getLocale() {
			return rb.getLocale();
		}

		public Object getObject(String key) {
			return rb.getObject(key);
		}

		public String getString(String key) {
			return rb.getString(key);
		}

		public String[] getStringArray(String key) {
			return rb.getStringArray(key);
		}

		protected Object handleGetObject(String key) {
			return ((PropertyResourceBundle) rb).handleGetObject(key);
		}
	}
}
