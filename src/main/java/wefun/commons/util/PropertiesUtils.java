package wefun.commons.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class PropertiesUtils {

	public static void main(String[] args) throws Exception {
		String PROPERTY_FILE = "nonLogin.properties";
		// String val = readData(PROPERTY_FILE, "log4j.appender.stdout");
		// System.out.println(val);

		// String key = readData("key");

		// writeData(PROPERTY_FILE, "key", "22");
	//	Map<String, String> map = readDatas(PROPERTY_FILE);
		Set<String> set = readDatasValue(PROPERTY_FILE);
		Iterator<String> it = set.iterator();
		while(it.hasNext())//判断是否有下一个
		System.out.println(it.next());
	}

	/**
	 * 
	 * @param path
	 * @param key
	 * @return
	 */
	public static String readData(String fileName, String key) {
		Properties props = new Properties();
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
//			InputStream is = new BufferedInputStream(new FileInputStream(path));
			props.load(is);
			is.close();
			String value = props.getProperty(key);
			return value;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static Map<String, String> readDatas(String fileName) {
		Properties props = new Properties();
		Map<String, String> propMap = new HashMap<String, String>();
		InputStream is = null;
		try {
//			is = new BufferedInputStream(new FileInputStream(path));
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			props.load(is);
			Set<Object> keyset = props.keySet();
			String tempKey;
			for (Object object : keyset) {
				tempKey = object.toString();
				String propValue = props.getProperty(tempKey).toString();
				propMap.put(tempKey, propValue);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return propMap;
	}
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static Set<String> readDatasValue(String fileName) {
		Properties props = new Properties();
		Set<String> list = new HashSet<>();
		InputStream is = null;
		try {
//			is = new BufferedInputStream(new FileInputStream(path));
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			props.load(is);
			Set<Object> keyset = props.keySet();
			String tempKey;
			for (Object object : keyset) {
				tempKey = object.toString();
				String propValue = props.getProperty(tempKey).toString();
				list.add(propValue);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 
	 * @param path
	 * @param key
	 * @param value
	 */
	public static void writeData(String fileName, String key, String value) {
		Properties prop = new Properties();
		try {
			String path = PathUtils.getProjectClassPath()+fileName;
			File file = new File(path);
			if (!file.exists()){
				file.createNewFile();
			}
			InputStream fis = new FileInputStream(file);
			prop.load(fis);
			fis.close();
			
			OutputStream fos = new FileOutputStream(new File(path));
			prop.setProperty(key, value);
			prop.store(fos, "Update '" + key + "' value");
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @param path
	 * @param key
	 * @param value
	 */
	public static void writeDatas(String fileName, Map<String, String> map) {
		Properties prop = new Properties();
		try {
			String path = PathUtils.getProjectClassPath()+fileName;	
			File file = new File(path);
			if (!file.exists()){
				file.createNewFile();
			}
			InputStream fis = new FileInputStream(file);
			prop.load(fis);
			fis.close();
			
			OutputStream fos = new FileOutputStream(path);
			Set<String> setKey = map.keySet();
			String key;
			for(Object obj : setKey){
				key = obj.toString();
				prop.setProperty(key, map.get(key));
			}
			prop.store(fos, "Update	Coll '" + map.toString());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * 
	 * @param path
	 * @param key
	 */
	public static void removeDatas(String path, String key) {
		if(StringUtils.isBlank(key)){
			return ;
		}
		Properties prop = new Properties();
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			InputStream fis = new FileInputStream(file);
			prop.load(fis);
			fis.close();
			OutputStream fos = new FileOutputStream(path);
			prop.remove(key);
			prop.store(fos, "delete	Coll '"+key);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param path
	 * @param keyList
	 */
	public static void removeDatas(String path, List<String> keyList) {
		if(keyList==null || keyList.isEmpty()){
			return ;
		}
		Properties prop = new Properties();
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}
			InputStream fis = new FileInputStream(file);
			prop.load(fis);
			fis.close();
			OutputStream fos = new FileOutputStream(path);
			for(String key : keyList){
				prop.remove(key);
			}
			prop.store(fos, "delete	Coll '"+keyList.toString());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
