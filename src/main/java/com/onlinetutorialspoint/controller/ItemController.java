package com.onlinetutorialspoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.onlinetutorialspoint.client.SoapClient;
import com.onlinetutorialspoint.soap.bindings.ItemRequest;
import com.onlinetutorialspoint.soap.bindings.ItemResponse;
import com.onlinetutorialspoint.soap.bindings.SearchRecordsByReport;
import com.onlinetutorialspoint.soap.bindings.SearchRecordsByReportResponse;

@RestController
public class ItemController {
	@Autowired
	SoapClient soapClient;

	@PostMapping("/item")
	public ItemResponse item(@RequestBody ItemRequest itemRequest) {
		return soapClient.getItemInfo(itemRequest);
	}

	@PostMapping("/searchRecordsByReport")
	public String item(@RequestBody SearchRecordsByReport searchRecordsByReportRequest) {
		return new Gson().toJson(soapClient.getRecordsByReportRequest(searchRecordsByReportRequest));
	}
}
