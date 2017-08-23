package com.zzz.tools.http;

import java.io.UnsupportedEncodingException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * 
 * @author Jack_zheng 使用unirest-java-1.3.8.jar post请求
 * 
 */
public class unitestHttp {

	public static void main(String[] args) {
		String urlpost1 = "http://10.1.109.8:10180/paystation/services/Restful/postApplication";
		HttpResponse<String> result = null;
		HttpResponse<String> result1 = null;
		try {
			result = Unirest.post(urlpost1)
					.header("accept", "text/plain;charset=utf-8")
					.body(messagePaymentApply).asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		String body = null;
		try {
			body = new String(result.getBody().getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("返回结果：\n" + body);
		/*
//post情请求
HttpResponse<JsonNode> jsonResponse = Unirest.post("http://httpbin.org/post")
				  .header("accept", "application/json")
				  .field("parameter", "value")
				  .field("foo", "bar")
				  .asJson();
				  
//参数处理
Unirest.get("http://httpbin.org/{method}")
  .routeParam("method", "get")
  .field("name", "Mark")
  .asJson();
 
//异步请求
Future<HttpResponse<JsonNode>> future = Unirest.post("http://httpbin.org/post")
  .header("accept", "application/json")
  .field("param1", "value1")
  .field("param2", "value2")
  .asJsonAsync(new Callback<JsonNode>() {
 
    public void failed(UnirestException e) {
        System.out.println("The request has failed");
    }
 
    public void completed(HttpResponse<JsonNode> response) {
         int code = response.getCode();
         Map<String, String> headers = response.getHeaders();
         JsonNode body = response.getBody();
         InputStream rawBody = response.getRawBody();
    }
 
    public void cancelled() {
        System.out.println("The request has been cancelled");
    }
 
});











				  */
	}

	// submit payment apply
	static String messagePaymentApply = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<PACKET TYPE=\"REQUEST\">"
			+ "<HEAD>"
			+ "<TRAN_CODE>A0</TRAN_CODE>"
			+ "<USER>Hx01</USER>"
			+ "<PASSWORD>Hx01pwd</PASSWORD>"
			+ "</HEAD>"
			+ "<BODY>"
			+ "<APP_BASE>"
			+ "<CHECK_CODE>1234</CHECK_CODE>"
			+ "<INSU_MIDNO></INSU_MIDNO>"
			+ "<AMOUNT>000000000001</AMOUNT>"
			+ "<DIRECT_BANKCODE></DIRECT_BANKCODE>"
			+ "<DIRECT_ORDERBANKCODE></DIRECT_ORDERBANKCODE>"
			+ "<REMARK>测试backurl</REMARK>"
			+ "<OPCODE>郑泽洲</OPCODE>"
			+ "<OPPW>test</OPPW>"
			+ "<RECOGNITIONID></RECOGNITIONID>"
			+ "<PAYTYPE>2</PAYTYPE>"
			+ "<PAYWAY>00</PAYWAY> "
			+ "<CHECKNO></CHECKNO>"
			+ "<CHECKSERRAL></CHECKSERRAL>"
			+ "<POLICYSTARTDATE>20151020142730</POLICYSTARTDATE>"
			+ "<SUBCOMPANY>01</SUBCOMPANY>"
			+ "<CURRENCYTYPE>CNY</CURRENCYTYPE>"
			+ "<PARANORMALDAY>0</PARANORMALDAY>"
			+ "<INSUREDNAME>测试</INSUREDNAME>"
			+ "<DEPARTMENTCODE>01080001</DEPARTMENTCODE>"
			+ "<BANKCODE></BANKCODE>            "
			+ "<CUSTACCOUNTNAME></CUSTACCOUNTNAME>"
			+ "<CUSTACCOUNTNO></CUSTACCOUNTNO>"
			+ "<BANKNAME></BANKNAME>"
			+ "<CUSTBANKNO></CUSTBANKNO> "
			+ "<BANKCITY></BANKCITY>"
			+ "<BANKPROVINCE></BANKPROVINCE> "
			+ "<BANKTYPE></BANKTYPE>"
			+ "<ISPAYPUBLIC></ISPAYPUBLIC>"
			+ "<MOBILENUMBER></MOBILENUMBER>"
			+ "<CARDFLAG></CARDFLAG>"
			+ "<CERTIFICATETYPE></CERTIFICATETYPE>"
			+ "<CERTIFICATENO></CERTIFICATENO>"
			+ "<CUSTEMAIL></CUSTEMAIL>"
			+ "<EXPIRYDATE></EXPIRYDATE><STAGENUM></STAGENUM>"
			+ "<BACKURL>http://www.baidu.com</BACKURL>"
			+ "</APP_BASE>"
			+ "<DETAILS>"

			+ "<APP_INFO>"
			+ "<CUSTSEQ>10021346</CUSTSEQ>"
			+ "<APPLICANTNO>2000002134333000000092</APPLICANTNO>"
			+ "<POLICYNO>26101000030001120000068</POLICYNO>"
			+ "<ENDORSENO>12</ENDORSENO>"
			+ "<CURRENCYTYPE>CNY</CURRENCYTYPE>"
			+ "<AMOUNT>1</AMOUNT>"
			+ "<TRANSACTORNAME>郑泽洲</TRANSACTORNAME>"
			+ "<APPLICANTNAME>郑泽洲</APPLICANTNAME>"
			+ "<INSUREDNAME>郑泽洲</INSUREDNAME>"
			+ "<APPLICANTCODE>0001</APPLICANTCODE>"
			+ "<INSUREDCODE>123</INSUREDCODE>"
			+ "<STARTDATE>20150820142730</STARTDATE>"
			+ "<DATATYPE>1</DATATYPE>"
			+ "<DATASOURCE>99</DATASOURCE>"
			+ "<DEPARTMENTCODE>01080001</DEPARTMENTCODE>"
			+ "<INSTALLMENTSTIMES></INSTALLMENTSTIMES>"
			+ "</APP_INFO>"
			+ "</DETAILS>" + "</BODY></PACKET>";
}
