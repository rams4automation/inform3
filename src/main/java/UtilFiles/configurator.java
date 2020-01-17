package UtilFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class configurator {
	static Properties prop = new Properties();
	String strFileName;
	String strValue;

	public configurator(String fileName){
		this.strFileName=fileName;
	}

	public String getProperty(String StrKey){		
		try{
			File f = new File(strFileName);
			if(f.exists()){
				FileInputStream fis = new FileInputStream(f);
				prop.load(fis);
				strValue=prop.getProperty(StrKey);		
				fis.close();
			}
		}catch(Exception e){
			e.getMessage();			
		}
		return strValue;
	}
	
	public void setProperty(String strKey,String srtValue){
		try{
			File f = new File(strFileName);
			if(f.exists()){
				FileInputStream in = new FileInputStream(f);
				prop.load(in);
				prop.setProperty(strKey, srtValue);
				prop.store(new FileOutputStream(strFileName), null);
				in.close();
			}else
				System.out.println("File not found");
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
