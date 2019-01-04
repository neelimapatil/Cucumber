package EJ.MODULES;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import managers.FileReaderManager;

import testDataTypes.Customer;


 
public class JsonDataReader<JSONString> {

 
// public JsonDataReader(){
 //customerList = getCustomerData();
// }
 
 //private List<Customer> getCustomerData()
 public void getCustomerData() throws IOException, ParseException
 {
	 String customerFilePath = "src/test/resources/" + "Customer.json";
	 List<Customer> customerList;
 Gson gson = new Gson();
//	 JSONString CompList = null;	 
 BufferedReader bufferReader = null;
 try {
 bufferReader = new BufferedReader(new FileReader(customerFilePath));
 Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
	//// JSONParser jsonParser = new JSONParser();			
//		Object obj = jsonParser.parse(new FileReader(customerFilePath));
	//	JSONArray jsonObject = (JSONArray) obj;
	//	JSONObject jasonobj =  (JSONObject) obj;
    // CompList = (JSONString) jasonobj.toJSONString();
     
 System.out.println(customers);
 System.out.println(customers[1].firstName);
//return Arrays.asList(customers);
 }catch(FileNotFoundException e) {
 throw new RuntimeException("Json file not found at path : " + customerFilePath);
 }finally {
 try { if(bufferReader != null) bufferReader.close();}
 catch (IOException ignore) {}
 }
 }
}
