package UtilFiles;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//import config.ConfiguratorSupport;

public class Accessories {
	
	//public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");
	/**
	 * Returns the current time stamp in yyyyMMddhhmmss format
	 * @return
	 */
	public static String getTimeStamp(){
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hhmmss");
		//System.out.println( sdf.format(cal.getTime()) );
		return sdf.format(cal.getTime());
	}
	/**
	 * Returns the Current Timestamp
	 * @return
	 */
	public static long currTimeStamp(){
		return System.currentTimeMillis();
	}

	/**
	 * Returns the Current Date
	 * @return
	 */
	public static String getDate(){
		Calendar cal = Calendar.getInstance();		
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
		//System.out.println( sdf.format(cal.getTime()) );
		return sdf.format(cal.getTime());
	}
	public static String addDate() throws Exception{
		Calendar cal = Calendar.getInstance();		
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
		//Calendar c = Calendar.getInstance();
		String dt = sdf.format(cal.getTime());
		cal.setTime(sdf.parse(dt));
		cal.add(Calendar.DATE, 1);  // number of days to add
		dt = sdf.format(cal.getTime());  // dt is now the new date
		return dt;
	}
	/**
	 * Return the Operating System
	 * @return
	 */

	public static String operatingSys(){
		Map<String,String> map=new HashMap<String,String>(); 
		map=System.getenv();
		String os=map.get("OS");
		return os;
	}
	/**
	 * Returns the System User Name
	 * @return
	 */
	public static String userName(){
		Map<String,String> map=new HashMap<String,String>(); 
		map=System.getenv();
		String os=map.get("USERNAME");
		return os;
	}
//	public static String getFilePath(){
//		String path = configProps.getProperty("filePath");
//		File f = new File(configProps.getProperty("filePath"));
//		if(f.exists()){
//			f.delete();			
//		}
//		return path;
//	}

	public static void getPackageName(){
		try {
			Class c = Class.forName("package_name.MyClass");

			Object o = c.newInstance();

			Package p = o.getClass().getPackage();

			System.out.println("Package Name :: " + p.getName());

		} catch (ClassNotFoundException e) {            
			e.printStackTrace();
		} catch (InstantiationException e) {            
			e.printStackTrace();
		} catch (IllegalAccessException e) {            
			e.printStackTrace();
		}
	}
	
	public static String createFile(String filePath){
		try{
			File f = new File(filePath+"_"+Accessories.getTimeStamp());
			return f.getName();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	

	
	public void report(String filePath){
		File f = new File(filePath+"_"+Accessories.getTimeStamp()+".html");
		try {
			FileWriter fw = new FileWriter(f);
			fw.write("<html><body><head><h1>Test Case Report</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}
