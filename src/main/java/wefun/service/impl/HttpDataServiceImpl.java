package wefun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.dao.http.HttpDataDAO;
import wefun.model.vo.MovieVO;
import wefun.service.HttpDataService;
@Service
public class HttpDataServiceImpl extends BaseServiceImpl implements HttpDataService{
	@Autowired
    private HttpDataDAO httpDataDAO;
	@Override
	public List<MovieVO> getMovie(String httpUrl) {
		if(!StringUtils.hasText(httpUrl)){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		String html = httpDataDAO.getMovie(httpUrl);
		if(!StringUtils.hasText(html)){
			throw new BusinessRuntimeException(CodeAndMsg.INVALID_PARAM);
		}
		return this.htmlDataHandle(html);
	}
	
	private List<MovieVO> htmlDataHandle(String html){
		//TODO 处理解析HTML页面获取有效的信息！并存入对象！
		return null;
	}

}
