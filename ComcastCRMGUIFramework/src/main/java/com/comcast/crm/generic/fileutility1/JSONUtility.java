package com.comcast.crm.generic.fileutility1;

import java.io.FileReader;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONUtility {
	public String getDataFromJsonFile(String Key) throws Throwable,ParseException {
FileReader fileR=new FileReader("./configAppData/appCommonData.json");
JSONParser parser=new JSONParser();
Object Obj=parser.parse(fileR);
JSONObject map=(JSONObject)Obj;
String data=(String)map.get(Key);
return data;
}
}
