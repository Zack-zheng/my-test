/*
 * 创建日期 2008-3-26
 *
 * 更改所生成文件模板为
 * 窗口 > 首选项 > Java > 代码生成 > 代码和注释
 */
package com.zzz.tools.dom4j.xsd;



public class XmlParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7589465268131730846L;

	public XmlParseException(Exception e) {
		super(e);
	}

	public XmlParseException(String message) {
		super(message); 
	
	}

	public XmlParseException(String message, Exception e) {
		super(message,e);
	}
	
	
}
