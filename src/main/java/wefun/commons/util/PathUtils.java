package wefun.commons.util;

import org.apache.commons.lang.StringUtils;


public class PathUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//		/D:/apache-tomcat-7.0.37/webapps/moffice/WEB-INF/classes/com/xinzhi/commons/
		
		String path = "/D:/apache-tomcat-7.0.37/webapps/moffice/WEB-INF/classes/com/xinzhi/commons/";
		path = path.substring(1, path.indexOf("classes")+8);
		path = "dfasdfasd/fasdfasdf";
		path = path.replaceAll("/", "\\\\");
		System.out.println(path);
		
		path = getTomcatWebApp(PathUtils.class);
		System.out.println(path);
	}
	
	/**
	 * 打成jar 失效
	 * D:/apache-tomcat-7.0.37/webapps/
	 * @return
	 */
	public static String getTomcatWebApp(){
		String path = new PathUtils().getClass().getResource("").getPath();
		path = path.substring(1, path.indexOf("webapps")+8);
		return path;
	}
	
	/**
	 * D:/apache-tomcat-7.0.37/webapps/
	 * @param classObj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getTomcatWebApp(Class classObj){
		String path = classObj.getResource("").getPath();
		path = path.substring(1, path.indexOf("webapps")+8);
		return path;
	}
	
	/**
	 * D:/apache-tomcat-7.0.37/webapps/moffice/WEB-INF/classes/
	 * @return
	 */
	public static String getTomcatClass(){
		String path = new PathUtils().getClass().getResource("").getPath();
		path = path.substring(1, path.indexOf("classes")+8);
		return path;
	}
	
	/**
	 * 获取当前项目class路径
	 * @return	D:/apache-tomcat-7.0.37/webapps/moffice/WEB-INF/classes/
	 */
	public static String getProjectClassPath(){
		String path = new PathUtils().getClass().getResource("/").getPath();
//		path = path.substring(1, path.indexOf("classes")+8);
		return path;
	}
	
	
	/**
	 * 获取指定项目class路径
	 * @param projectName
	 * @return
	 */
	public static String getOneProjectClassPath(String projectName){
		if(StringUtils.isBlank(projectName)){
			return null;
		}
		String webRoot = getTomcatWebApp();
		String path = webRoot+projectName+"/WEB-INF/classes/";
		return path;
	}
	
	
	

}
