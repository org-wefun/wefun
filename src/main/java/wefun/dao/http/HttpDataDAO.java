package wefun.dao.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import wefun.commons.util.HttpConenection;

@Component
public class HttpDataDAO {
	private static final Logger LOG = LoggerFactory.getLogger(HttpDataDAO.class);
	public String getMovie(final String httpUrl){
		HttpConenection conn = HttpConenection.getInstance();
		String result = conn.sendHttpGet(httpUrl);
		if(result != null){
			LOG.info(result);
		}
		return result;
	}
}
