package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	public ReadConfig() {
		File src=new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exceptions is "+e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		String url = prop.getProperty("baseurl");
	return url;
	}
	
	public String getUsername() {
		String username = prop.getProperty("username"); 
		return username;
	}
	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}
	

}
