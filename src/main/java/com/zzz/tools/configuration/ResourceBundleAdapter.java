package com.zzz.tools.configuration;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * TODO Comment of ResourceBundleAdapter
 *
 * @author dengsilinming
 * @version $Id: ResourceBundleAdapter.java 2013-1-30 下午1:35:47 $
 */
public class ResourceBundleAdapter extends Properties {
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