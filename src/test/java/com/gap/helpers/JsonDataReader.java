package com.gap.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.gap.helpers.FileReaderManager;
import com.gap.pojo.Address;
import com.gap.pojo.Customer;
import com.gap.pojo.PhoneNumber;

public class JsonDataReader {
	
private final String customerFilePath = "C:\\Users\\sadia\\eclipse-workspace\\SeleniumTryOut\\Customer.json";
private List<Customer> customerList;

public JsonDataReader(){
	customerList = getCustomerData();
}

private List<Customer> getCustomerData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(customerFilePath));
		Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
		return Arrays.asList(customers);
	}catch(FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + customerFilePath);
	}finally {
		try { if(bufferReader != null) bufferReader.close();}
		catch (IOException ignore) {}
	}
}

public String getCustomerFullName() {
	Customer customer = getCustomerData().get(0);
	return customer.getFirstName() + " " + customer.getLastName();
}

public String getCustomerAddress() {
	Customer customer = getCustomerData().get(0);
	Address address = customer.getAddress();
	return address.getStreetAddress();
}
	
public String getCustomercity() {
	Customer customer = getCustomerData().get(0);
	Address address = customer.getAddress();
	return address.getCity();
}
public String getCustomerpostCode() { 
	Customer customer = getCustomerData().get(0);
	Address address = customer.getAddress();
	return address.getPostCode();
}
public String getCustomerstate() { 
	Customer customer = getCustomerData().get(0);
	Address address = customer.getAddress();
	return address.getState();
}
public String getCustomercountry() { 
	Customer customer = getCustomerData().get(0);
	Address address = customer.getAddress();
	return address.getCountry();
}
public String getCustomergetMob() { 
	Customer customer = getCustomerData().get(0);
	PhoneNumber phonenumber = customer.getPhoneNumber();
	return phonenumber.getMob();
}
}