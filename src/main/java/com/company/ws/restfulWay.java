package com.company.ws;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * 
 * @author Jack_zheng
 * 
 */
public class restfulWay {
	
	@Test
	public void testpostApplication(){
		
		System.out.println("请求报文：" + message_post);
		for(int i = 0 ;i<1;i++){
			HttpResponse<String> result = null;
			try {
				result = Unirest.post(url_tst)
						.header("accept", "text/plain;charset=utf-8").body(message_post)
						.asString();
			} catch (UnirestException e) {
				e.printStackTrace();
			}
			String body = null;
			try {
				body = new String(result.getBody().getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			System.out.println("返回报文：" + body);
		}
	}
	/**
	 * 补传接口
	 */
	@Test
	public void testuploadInterface(){
		String urlpost2 = "http://10.1.109.7:10180/paystation/services/Restful/uploadApplication";
		HttpResponse<String> result = null;
		try {
			result = Unirest.post(urlpost2)
					.header("accept", "text/plain;charset=utf-8").body(message_upload)
					.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		String body = null;
		try {
			body = new String(result.getBody().getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println("返回报文：" + body);
	}
	/**
	 * 支付状态查询
	 */
	@Test
	public void testqueryApplicationStatus(){
		String urlpost2 = "http://10.1.109.7:10180/paystation/services/Restful/queryApplicationStatus";
		HttpResponse<String> result = null;
		try {
			System.out.println(message_queryApplicationStatus);
			result = Unirest.post(urlpost2)
					.header("accept", "text/plain;charset=utf-8").body(message_queryApplicationStatus)
					.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		String body = null;
		try {
			body = new String(result.getBody().getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println("返回报文：" + body);
	}
	static String url_stg = "http://10.1.109.8:10180/paystation/services/Restful/postApplication";
	static String outnet = "http://localhost:8080/stgpaystation/services/Restful/postApplication";
	static String url_tst = "http://10.1.109.7:10180/paystation/services/Restful/postApplication";
	static String url_pro = "http://10.1.102.3:10180/paystation/services/Restful/postApplication";
	static String message_queryApplicationStatus ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
			"<PACKET TYPE=\"REQUEST\">"+
			"<HEAD>"+
			"<TRAN_CODE>B0</TRAN_CODE>"+
			"<USER>Hx01</USER>"+
			"<PASSWORD>Hx01pwd</PASSWORD>"+
			"</HEAD>"+
			"<BODY>"+
			"<BASE>"+
			"<PAY_APP_NO>153000039304</PAY_APP_NO>"+
			"</BASE>"+
			"</BODY>"+
			"</PACKET>";
	static String message_upload ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
			"<PACKET TYPE=\"REQUEST\">"+
			"<HEAD>"+
			"<TRAN_CODE>D0</TRAN_CODE>"+
			"<USER>Hx01</USER>"+
			"<PASSWORD>Hx01pwd</PASSWORD>"+
			"</HEAD>"+
			"<BODY>"+
			"<APP_BASE>"+
			"<PAY_APP_NO>18CPIC230309400101</PAY_APP_NO>"+
			"<INPAYMENTDATE>20110312</INPAYMENTDATE>"+
			"<INPAYMENTTIME>112315</INPAYMENTTIME>"+
			"<CHECK_CODE>00000001</CHECK_CODE>"+
			"<INSU_MIDNO>000000000000001</INSU_MIDNO>"+  /*保险商户号*/
			"<AMOUNT>1000</AMOUNT>"+
			"<REMARK>收保费</REMARK>"+	 /*备注信息可用于描述一些有数据维护修改单的修改数据备注，也可用于描述撤销支付号原因*/
			"<OPCODE>tester</OPCODE>"+/* 对应支票支付方式的支票操作员姓名*/
			"<OPPW>162710</OPPW>"+ /*对应支票支付方式支付确认用户密码*/
			"<RECOGNITIONID>123</RECOGNITIONID>"+
			"<PAYTYPE>3</PAYTYPE>"+		/*01	现金收款
										02	POS刷卡
										03	客户转账
										04	批量扣款
										05	银保通
										06	支票收款
										07	WEB在线支付
										08	快钱垫付
										09	语音在线支付
										00	不限制
										10	信用卡分期*/
			"<PAYCHANNEL>POS</PAYCHANNEL>"+
										
			"<PAYWAY>2</PAYWAY>"+
			"<CHECKNO>1232123</CHECKNO>"+
			"<CHECKSERRAL>12345678</CHECKSERRAL>"+
			"<POLICYSTARTDATE>20081020171900</POLICYSTARTDATE>"+
			"<SUBCOMPANY>5020100</SUBCOMPANY>"+
			"<CURRENCYTYPE>CNY</CURRENCYTYPE>"+
			"<PARANORMALDAY>0</PARANORMALDAY>"+
			"<INSUREDNAME>上海XXX有限责任公司</INSUREDNAME>"+
			"<DEPARTMENTCODE>502010110</DEPARTMENTCODE>"+
			"<CUSTACCOUNTNAME>上海XXX有限公司</CUSTACCOUNTNAME>"+
			"<CUSTACCOUNTNO>6245098745683214</CUSTACCOUNTNO>"+
			"<BANKNAME>招商银行股份有限公司杭州城东支行</BANKNAME>"+
			"<CUSTBANKNO>308331012062</CUSTBANKNO>"+
			"<BANKCITY>杭州市</BANKCITY>"+
			"<BANKPROVINCE>浙江省</BANKPROVINCE>"+
			"<BANKTYPE>CMB</BANKTYPE>"+
			"<ISPAYPUBLIC>1</ISPAYPUBLIC>"+
			"<MOBILENUMBER>18712345678</MOBILENUMBER>"+
			"<CARDFLAG>2</CARDFLAG>"+
			"<CERTIFICATETYPE>0</CERTIFICATETYPE>"+
			"<CERTIFICATENO>320125198310212351</CERTIFICATENO>"+
			"<CUSTEMAIL>EMAIL@126.COM</CUSTEMAIL>"+
			"</APP_BASE>"+
			"<DETAILS>"+
			"<APP_INFO>"+
			"<CUSTSEQ>10021345</CUSTSEQ>"+
			"<APPLICANTNO>2000002134333000000091</APPLICANTNO>"+
			"<POLICYNO>26101000030001120000069</POLICYNO>"+
			"<ENDORSENO/>"+
			"<CURRENCYTYPE>CNY</CURRENCYTYPE>"+
			"<AMOUNT>500</AMOUNT>"+
			"<TRANSACTORNAME>业务经办</TRANSACTORNAME>"+
			"<APPLICANTNAME>投保人</APPLICANTNAME>"+
			"<INSUREDCODE/>"+
			"<APPLICANTCODE/>"+
			"<INSUREDNAME>上海XXX有限责任公司</INSUREDNAME>"+
			"<STARTDATE>20081020171900</STARTDATE>"+
			"<DATATYPE>0</DATATYPE>"+
			"<DATASOURCE>AUTOUW</DATASOURCE>"+
			"<DEPARTMENTCODE>502010110</DEPARTMENTCODE>"+
			"<INSTALLMENTSTIMES/>"+
			"</APP_INFO>"+
			"<APP_INFO>"+
			"<CUSTSEQ>10021345</CUSTSEQ>"+
			"<APPLICANTNO>2000002134333000000091</APPLICANTNO>"+
			"<POLICYNO>26101000030001120000069</POLICYNO>"+
			"<ENDORSENO/>"+
			"<CURRENCYTYPE>CNY</CURRENCYTYPE>"+
			"<AMOUNT>500</AMOUNT>"+
			"<TRANSACTORNAME>业务经办</TRANSACTORNAME>"+
			"<APPLICANTNAME>投保人</APPLICANTNAME>"+
			"<INSUREDCODE/>"+
			"<APPLICANTCODE/>"+
			"<INSUREDNAME>上海XXX有限责任公司</INSUREDNAME>"+
			"<STARTDATE>20081020171900</STARTDATE>"+
			"<DATATYPE>0</DATATYPE>"+
			"<DATASOURCE>AUTOUW</DATASOURCE>"+
			"<DEPARTMENTCODE>502010110</DEPARTMENTCODE>"+
			"<INSTALLMENTSTIMES/>"+
			"</APP_INFO>"+
			"</DETAILS>"+
			"</BODY>"+
			"</PACKET>";
	static String message_post = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<PACKET TYPE=\"REQUEST\">" + "<HEAD>"
			+ "<TRAN_CODE>A0</TRAN_CODE>" + "<USER>Hx01</USER>"
			+ "<PASSWORD>Hx01pwd</PASSWORD>" + "</HEAD>" + "<BODY>"
			+ "<APP_BASE>" + "<CHECK_CODE>0101</CHECK_CODE>"
			+ "<INSU_MIDNO></INSU_MIDNO>" + "<AMOUNT>000000000001</AMOUNT>"
			+ "<DIRECT_BANKCODE></DIRECT_BANKCODE>"
			+ "<DIRECT_ORDERBANKCODE></DIRECT_ORDERBANKCODE>"
			+ "<REMARK>测试backurl</REMARK>" + "<OPCODE>郑泽洲</OPCODE>"
			+ "<OPPW>test</OPPW>" + "<RECOGNITIONID></RECOGNITIONID>"
			+ "<PAYTYPE>2</PAYTYPE>" + "<PAYWAY>00</PAYWAY> "
			+ "<CHECKNO></CHECKNO>" + "<CHECKSERRAL></CHECKSERRAL>"
			+ "<POLICYSTARTDATE>20161020142730</POLICYSTARTDATE>"
			+ "<SUBCOMPANY>04</SUBCOMPANY>"
			+ "<CURRENCYTYPE>CNY</CURRENCYTYPE>"
			+ "<PARANORMALDAY>0</PARANORMALDAY>"
			+ "<INSUREDNAME>测试</INSUREDNAME>"
			+ "<DEPARTMENTCODE>04010007</DEPARTMENTCODE>"
			+ "<BANKCODE></BANKCODE>            "
			+ "<CUSTACCOUNTNAME></CUSTACCOUNTNAME>"
			+ "<CUSTACCOUNTNO></CUSTACCOUNTNO>" + "<BANKNAME></BANKNAME>"
			+ "<CUSTBANKNO></CUSTBANKNO> " + "<BANKCITY></BANKCITY>"
			+ "<BANKPROVINCE></BANKPROVINCE> " + "<BANKTYPE></BANKTYPE>"
			+ "<ISPAYPUBLIC></ISPAYPUBLIC>"
			+ "<MOBILENUMBER></MOBILENUMBER>" + "<CARDFLAG></CARDFLAG>"
			+ "<CERTIFICATETYPE></CERTIFICATETYPE>"
			+ "<CERTIFICATENO></CERTIFICATENO>" + "<CUSTEMAIL></CUSTEMAIL>"
			+ "<EXPIRYDATE></EXPIRYDATE><STAGENUM></STAGENUM>" +"<BACKURL>http://172.16.1.28:8888/shop/sycp/car/toubao.html?target=payback&amp;orderNo=12111448277100522</BACKURL>"
			+ "</APP_BASE>" + "<DETAILS>"
			+ "<APP_INFO>" + "<CUSTSEQ>10021346</CUSTSEQ>"
			+ "<APPLICANTNO>2000002134333000000092</APPLICANTNO>"
			+ "<POLICYNO>26101000030001120000068</POLICYNO>"
			+ "<ENDORSENO>12</ENDORSENO>"
			+ "<CURRENCYTYPE>CNY</CURRENCYTYPE>" + "<AMOUNT>1</AMOUNT>"
			+ "<TRANSACTORNAME>郑泽洲</TRANSACTORNAME>"
			+ "<APPLICANTNAME>郑泽洲</APPLICANTNAME>"
			+ "<INSUREDNAME>郑泽洲</INSUREDNAME>"
			+ "<APPLICANTCODE>0001</APPLICANTCODE>"
			+ "<INSUREDCODE>123</INSUREDCODE>"
			+ "<STARTDATE>20150820142730</STARTDATE>"
			+ "<DATATYPE>1</DATATYPE>" + "<DATASOURCE>99</DATASOURCE>"
			+ "<DEPARTMENTCODE>04010007</DEPARTMENTCODE>"
			+ "<INSTALLMENTSTIMES></INSTALLMENTSTIMES>" + "</APP_INFO>"
			+ "</DETAILS>" + "</BODY></PACKET>";
}
