package com.zzz.tools.dom4j.xsd;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class parseXML {
	private static final Logger logger = Logger.getLogger(parseXML.class);

	public void parseMsg(String message) throws XmlParseException {
		SAXReader reader = new SAXReader(true);// 初始化新的SAXReader,并且打开验证
		//InputStream in = parseXML.class.getResourceAsStream("/BankConsumeRequest.xsd");
		System.out.println("parseXML.class:"+parseXML.class);
		System.out.println("getClass():"+getClass());
		try {
			EntityResolver resolver = new EntityResolver() 
			{
				public InputSource resolveEntity(String publicId,String systemId) 
				{
					System.out.println("insideclass:"+getClass());
					InputStream in = getClass().getResourceAsStream("/BankConsumeRequest.xsd");
					return new InputSource(in);
				}
			};
			reader.setEntityResolver(resolver);
			reader.setFeature("http://apache.org/xml/features/validation/schema", true);// 设置验证为schema验证，不设置则为dtd验证
			// 指定校验XML的xsd文件
			reader.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation","BankConsumeRequest.xsd");

			InputStream ins = new ByteArrayInputStream(message.getBytes("UTF-8"));
			Document document = reader.read(ins);

			Element root = document.getRootElement();
			// 获得相应的结点元素
			Element headElm = root.element("HEAD");
			Element tran_code = headElm.element("TRAN_CODE");
			Element userName = headElm.element("USER");
			Element password = headElm.element("PASSWORD");

			Element body = root.element("BODY");
			Element base = body.element("BASE");

			logger.info("打印出BANK_CODE.getTextTrim():"+ base.element("BANK_CODE").getTextTrim());

		} catch (SAXException e) {
			throw new XmlParseException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new XmlParseException(e.getMessage(), e);
		} catch (DocumentException e) {
			throw new XmlParseException(e.getMessage(), e);
		} catch (NumberFormatException e) {
			throw new XmlParseException("PAYCOUNT value invalid."
					+ e.getMessage(), e);
		}

	}

	public static void main(String[] args) {
		parseXML test = new parseXML();
		String message = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<PACKET TYPE=\"REQUEST\">" + "<HEAD>"
				+ "<TRAN_CODE>20</TRAN_CODE>" + "<USER>SYSTEMPAY</USER>"
				+ "<PASSWORD>systempay</PASSWORD>" + "</HEAD>" + "<BODY>"
				+ "<BASE>" + "<BANK_CODE>1</BANK_CODE>"
				+ "<INSURE_ID>AC000000</INSURE_ID>" + "<MIDNO>0</MIDNO>"
				+ "<TIDNO>0</TIDNO>" + "<BK_ACCT_DATE>20140102</BK_ACCT_DATE>"
				+ "<BK_ACCT_TIME>122602</BK_ACCT_TIME>"
				+ "<BK_SERIAL>1</BK_SERIAL>"
				+ "<BK_TRAN_CHNL>TER01</BK_TRAN_CHNL>"
				+ "<PAY_APP_NO>011410015876</PAY_APP_NO>"
				+ "<AMOUNT>000003003272</AMOUNT>" + "<PAYCOUNT>1</PAYCOUNT>"
				/*
				 * + "<CHECK_OPCODE/>" + "<CHECK_OPNAME/>"
				 */
				+ "<CURRENCYTYPE>CNY</CURRENCYTYPE>" + "</BASE>" + "<DETAILS>"
				+ "<PAYINFO>" + "<BATCH_NO>1</BATCH_NO>"
				+ "<CASH_NO>0</CASH_NO>" + "<CARD_NO>0</CARD_NO>"
				+ "<SUB_AMOUNT>000003003272</SUB_AMOUNT>" + "</PAYINFO>"
				+ "</DETAILS>" + "</BODY></PACKET>";
		try {
			logger.info("打印待解析xml:" + message);
			logger.info("begin parse xml");
			test.parseMsg(message);
			logger.info("parse end!");
		} catch (XmlParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
