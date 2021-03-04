package com.onlinetutorialspoint;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Send_XML_Post_Request_2 {
	public static void main(String[] args) {
		try {
			String url = "https://grcb.archer.rsa.com/ws/search.asmx?op=GetReports";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "text/html; charset=utf-8");
			String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://archer-tech.com/webservices/\"><soapenv:Header/><soapenv:Body><web:GetReports><web:sessionToken>EF01FFB56DA3F128629C102CFF52F3F7</web:sessionToken></web:GetReports></soapenv:Body></soapenv:Envelope>";
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(xml);
			wr.flush();
			wr.close();
			String responseStatus = con.getResponseMessage();
			System.out.println(responseStatus);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println("response:" + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
