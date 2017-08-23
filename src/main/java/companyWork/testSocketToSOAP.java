package companyWork;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Jack on 07/04/2016.
 */
//http://yunchow.iteye.com/blog/741680
public class testSocketToSOAP {
    static final String ENDPOINT = "http://10.40.51.156:28888/testSoap/services/UserManage?wsdl";

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        Socket stub = new Socket();

        stub.connect(new InetSocketAddress("10.40.51.156", 28888), 500);

        OutputStream os = stub.getOutputStream();

        PrintWriter out = new PrintWriter(os);

        String header = "POST /testSoap/services/UserManage HTTP/1.0\n"

                + "Content-Type:text/xml;charset=utf-8\n"

                + "Accept:application/soap+xml, application/dime, multipart/related, text/*\n"

                + "User-Agent:Axis/1.4\n"

                + "Host:10.40.51.156:28888\n"

                + "Cache-Control: no-cache\n"

                + "Pragma: no-cache\n"

                + "SOAPAction: \"\"\n"

                + "Content-Length: ";

        String messge = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><ns1:queryUser soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://services.zhang.com\"><in0 xsi:type=\"ns2:UserInfo\" xsi:nil=\"true\" xmlns:ns2=\"http://tdo.zhang.com\"/></ns1:queryUser></soapenv:Body></soapenv:Envelope>";
        int length = messge.length();
        header += length + "\n\n";

        out.println(header + messge);

        out.flush();

        InputStream is = stub.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        for (String line = br.readLine(); line != null; line = br.readLine())
        {
            System.out.println(line);
        }

        is.close();
        br.close();
        out.close();

    }
}
