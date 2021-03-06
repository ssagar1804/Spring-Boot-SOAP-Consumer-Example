package com.onlinetutorialspoint.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.onlinetutorialspoint.soap.bindings.ItemRequest;
import com.onlinetutorialspoint.soap.bindings.ItemResponse;
import com.onlinetutorialspoint.soap.bindings.SearchRecordsByReport;
import com.onlinetutorialspoint.soap.bindings.SearchRecordsByReportResponse;
import com.onlinetutorialspoint.soap.json.response.Root;

@Service
public class SoapClient {

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	private WebServiceTemplate webServiceTemplate;

	public ItemResponse getItemInfo(ItemRequest itemRequest) {
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		return (ItemResponse) webServiceTemplate.marshalSendAndReceive("https://grcb.archer.rsa.com/", itemRequest);
	}

	public SearchRecordsByReportResponse getRecordsByReportRequest(SearchRecordsByReport searchRecordsByReportRequest) {
		SearchRecordsByReportResponse res = null;
		try {
			webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
			res = (SearchRecordsByReportResponse) webServiceTemplate.marshalSendAndReceive(
					"https://grcb.archer.rsa.com/ws/search.asmx?wsdl", searchRecordsByReportRequest,
					webServiceMessage -> ((SoapMessage) webServiceMessage)
							.setSoapAction("http://archer-tech.com/webservices/SearchRecordsByReport"));

			System.out.println(res.getSearchRecordsByReportResult());
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			Root poppy = xmlMapper.readValue(res.getSearchRecordsByReportResult(), Root.class);

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(poppy);

			System.out.println(json);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
