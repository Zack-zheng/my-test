package com.zzz.tools.dom4j.TEST;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.AbstractAttribute;


public class ReadXMLTest {

	public static void main(String[] args) {
		String fStr = ReadXMLTest.class.getResource("s.xml").getPath();
		fStr = fStr.substring(1);
		System.out.println(fStr);
		File xmlFile = new File(fStr);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(xmlFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("File is not exsit!");
		}

		SAXReader saxReader = new SAXReader();
		List rowList = null;
		try {
			// 生成文档对应实体
			Document doc = saxReader.read(fis);
			// 获取指定路径下的元素列表,这里指获取所有的data下的row元素
			rowList = doc.selectNodes("//data/row");
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		for (Iterator iter = rowList.iterator(); iter.hasNext();) {
			// 获得具体的row元素
			Element element = (Element) iter.next();
			// 获得row元素的所有属性列表
			List elementList = element.attributes();
			for (Iterator iter1 = elementList.iterator(); iter1.hasNext();) {
				// 将每个属性转化为一个抽象属性，然后获取其名字和值
				AbstractAttribute aa = (AbstractAttribute) iter1.next();
				System.out.println("Name:" + aa.getName() + ";Value:"
						+ aa.getValue());
			}
			// 输出：
			// Name:queryDTO.enterpriseId;Value:gfd
			// Name:queryDTO.loginName;Value:gdfg
			// Name:queryDTO.state;Value:0
			System.out.println(element.getName());
			// 输出：
			// row
			// 取得row元素的queryDTO.enterpriseId属性的值
			System.out.println(element.attributeValue("queryDTO.enterpriseId"));
			// 输出：
			// gfd
			// 如果element下有子元素，(类似width="**")，要想获得该子元素的值，可以用如下方法
			System.out.println(element.elementText("width"));// 因为没有，所以输出为null。
		}

	}
}