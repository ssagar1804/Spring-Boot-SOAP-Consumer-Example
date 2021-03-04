package com.onlinetutorialspoint.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.onlinetutorialspoint.soap.bindings.ItemRequest;
import com.onlinetutorialspoint.soap.bindings.ItemResponse;
import com.onlinetutorialspoint.soap.bindings.SearchRecordsByReport;
import com.onlinetutorialspoint.soap.bindings.SearchRecordsByReportResponse;

@Service
public class SoapClient {

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	private WebServiceTemplate webServiceTemplate;

	public ItemResponse getItemInfo(ItemRequest itemRequest) {
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		return (ItemResponse) webServiceTemplate.marshalSendAndReceive("https://grcb.archer.rsa.com", itemRequest);
	}

	public void getRecordsByReportRequest(SearchRecordsByReport searchRecordsByReportRequest) {
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		SearchRecordsByReportResponse res = (SearchRecordsByReportResponse) webServiceTemplate
				.marshalSendAndReceive("https://grcb.archer.rsa.com/ws/search.asmx", searchRecordsByReportRequest);
	}
}
