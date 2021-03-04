package com.onlinetutorialspoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinetutorialspoint.client.SoapClient;
import com.onlinetutorialspoint.soap.bindings.ItemRequest;
import com.onlinetutorialspoint.soap.bindings.ItemResponse;
import com.onlinetutorialspoint.soap.bindings.SearchRecordsByReport;

@RestController
public class ItemController {
	@Autowired
	SoapClient soapClient;

	@PostMapping("/item")
	public ItemResponse item(@RequestBody ItemRequest itemRequest) {
		return soapClient.getItemInfo(itemRequest);
	}

	@PostMapping("/searchRecordsByReport")
	public ItemResponse item(@RequestBody SearchRecordsByReport searchRecordsByReportRequest) {
		soapClient.getRecordsByReportRequest(searchRecordsByReportRequest);
		return null;
	}
}
