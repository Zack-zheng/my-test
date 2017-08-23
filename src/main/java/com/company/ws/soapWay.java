package com.company.ws;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.XMLType;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

//axis way

/**
 * webservices invoke way in soap
 * 
 * @author Jack_zheng
 * 
 */
public class soapWay {

	/**
	 * remote access webservice  interface:takeApplication
	 */
	@Test
	public void testSOAPtakeApplication() throws RemoteException,
			ServiceException, MalformedURLException {
		Service service = new Service();
		Call call = (Call) service.createCall();
		OperationDesc oper = new OperationDesc();

		//ws address
		call.setTargetEndpointAddress(new URL(message.url_tst_paystationforbank));
		//send message
		String message1 = message.msg_take_icbdsd_2;

		call.setOperationName(new QName("http://com/fenet/insurance/paystation/consume/ws","takeApplication"));
		ParameterDesc param = new ParameterDesc(new QName("http://com/fenet/insurance/paystation/consume/ws", "msg"),
				ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"),
				String.class, false, false);
		call.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
		oper.setReturnType(XMLType.XSD_STRING);
		oper.addParameter(param);
		call.setOperation(oper);
		System.out.println("request message:" + message1);
		String ret = (String) call.invoke(new Object[] { message1 });
		System.out.println("response message:" + ret);
	}
	
	/**
	 * remote access webservice  interface:consumeApplication
	 */
	@Test
	public void testSOAPconsumeApplication() throws RemoteException,
			ServiceException, MalformedURLException {
		Service service = new Service();
		Call call = (Call) service.createCall();
		OperationDesc oper = new OperationDesc();

		//ws address
		call.setTargetEndpointAddress(new URL(message.url_tst_paystationforbank));
		//send message
		String message1 = message.msg_comsume_icbc;
		
		call.setOperationName(new QName("http://com/fenet/insurance/paystation/consume/ws","consumeApplication"));
		ParameterDesc param = new ParameterDesc(new QName("http://com/fenet/insurance/paystation/consume/ws", "msg"),
				ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"),
				String.class, false, false);
		oper = new OperationDesc();
		oper.setReturnType(XMLType.XSD_STRING);
		oper.addParameter(param);
		call.setOperation(oper);
		System.out.println("request message:" + message1);
		String ret = (String) call.invoke(new Object[] { message1 });
		System.out.println("response message:" + ret);
	}
	
	@Test
	public void testSOAPqueryApplicationStatus() throws RemoteException,
			ServiceException, MalformedURLException {
		Service service = new Service();
		Call call = (Call) service.createCall();
		OperationDesc oper = new OperationDesc();
		
		//ws address
		call.setTargetEndpointAddress(new URL(message.url_tst_paystationforinsurance));
		//send message
		String message1 = message.msg_queryApplicationStatus;
		
		call.setOperationName(new QName("http://com/fenet/insurance/paystation/application/ws/","queryApplicationStatus"));
		ParameterDesc param = new ParameterDesc(new QName("http://com/fenet/insurance/paystation/application/ws/", "message"),
				ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"),
				String.class, false, false);
		oper = new OperationDesc();
		oper.addParameter(param);
		oper.setReturnType(XMLType.XSD_STRING);
		call.setOperation(oper);
		System.out.println("request message:" + message1);
		String ret = (String) call.invoke(new Object[] { message1 });
		System.out.println("response message:" + ret);
	}
	
	@Test
	public void testSOAPuploadApplication() throws ServiceException, MalformedURLException, RemoteException {
		Service service = new Service();
		Call call = (Call) service.createCall();
		OperationDesc oper = new OperationDesc();
		
		//ws address
		call.setTargetEndpointAddress(new URL(message.url_localhost_paystationforinsurance));
		//send message
		String message1 = message.msg_uplocadApplication;
		
		call.setOperationName(new QName("http://com/fenet/insurance/paystation/application/ws/","uploadApplication"));
		ParameterDesc param = new ParameterDesc(new QName("http://com/fenet/insurance/paystation/application/ws/", "message"),
				ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"),
				String.class, false, false);
		
		oper = new OperationDesc();
		oper.addParameter(param);
		oper.setReturnType(XMLType.XSD_STRING);
		
		//how much times?
			call.setOperation(oper);
			System.out.println("request message:" + message1);
			String ret = (String) call.invoke(new Object[] { message1 });
			System.out.println("response message:" + ret);
	}
	
	
	@Test
	public void testSOAPpostApplication() throws ServiceException, MalformedURLException, RemoteException {
		Service service = new Service();
		Call call = (Call) service.createCall();
		OperationDesc oper = new OperationDesc();
		
		//ws address
		call.setTargetEndpointAddress(new URL(message.url_tst_paystationforinsurance));
		//send message
		String message1 = message.msg_postApplication;
		//invoke times
		int times = 5;

		call.setOperationName(new QName("http://com/fenet/insurance/paystation/application/ws/","postApplication"));
		ParameterDesc param = new ParameterDesc(new QName("http://com/fenet/insurance/paystation/application/ws/", "message"),
				ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"),
				String.class, false, false);

		oper = new OperationDesc();
		oper.addParameter(param);
		oper.setReturnType(XMLType.XSD_STRING);

		System.out.println("request message:" + message1);

		//how much times?
		for(int i = 0 ; i < times ;i ++){
		call.setOperation(oper);
		String ret = (String) call.invoke(new Object[] { message1 });
		System.out.println(ret.substring(ret.indexOf("<PAY_APP_NO>")+12, ret.indexOf("</PAY_APP_NO>")));
//		System.out.println("response message:" + ret);
		}
	}
	
	
	@Test
	public void testSOAPpostApplicationForUnionVoicePay() throws ServiceException, MalformedURLException, RemoteException {
		Service service = new Service();
		Call call = (Call) service.createCall();
		OperationDesc oper = new OperationDesc();
		
		//ws address
		call.setTargetEndpointAddress(new URL(message.url_localhost_paystationforinsurance));
		//send message
		String message1 = message.msg_postApplicationForUnionVoicePay;
		//invoke times
		int times = 1;
		
		call.setOperationName(new QName("http://com/fenet/insurance/paystation/application/ws/","postApplicationForUnionVoicePay"));
		ParameterDesc param = new ParameterDesc(new QName("http://com/fenet/insurance/paystation/application/ws/", "message"),
				ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"),
				String.class, false, false);
		
		oper = new OperationDesc();
		oper.addParameter(param);
		oper.setReturnType(XMLType.XSD_STRING);
		
		System.out.println("request message:" + message1);
		
		//how much times?
		for(int i = 0 ; i < times ;i ++){
			call.setOperation(oper);
			String ret = (String) call.invoke(new Object[] { message1 });
			System.out.println(ret.substring(ret.indexOf("<PAY_APP_NO>")+12, ret.indexOf("</PAY_APP_NO>")));
//		System.out.println("response message:" + ret);
		}
	}
	
	
}
