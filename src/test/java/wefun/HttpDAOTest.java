package wefun;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import wefun.dao.http.HttpDataDAO;

public class HttpDAOTest extends BaseTest{
	@Autowired
	private HttpDataDAO httpDataDAO;
	@Test
	public void getDataFromUrl(){
		final String httpUrl = "http://www.youku.com";
		httpDataDAO.getMovie(httpUrl);
	}

}
