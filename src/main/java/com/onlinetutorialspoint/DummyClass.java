package com.onlinetutorialspoint;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DummyClass {

	public static void main(String[] args) {
		try {
			String url = "https://grcb.archer.rsa.com/ws/search.asmx?op=SearchRecordsByReport";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
			String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?> "
					+ "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://archer-tech.com/webservices/\"><soapenv:Header/><soapenv:Body><web:SearchRecordsByReport><web:sessionToken>8146EAAF884D8A47D9D1F2435CD57A33</web:sessionToken><web:reportIdOrGuid>4a001f8f-c2f5-400e-9564-bfde43929149</web:reportIdOrGuid><web:pageNumber>1</web:pageNumber></web:SearchRecordsByReport></soapenv:Body></soapenv:Envelope>";
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
