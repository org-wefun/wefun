package wefun.service;

import java.util.List;

import wefun.model.vo.MovieVO;

public interface HttpDataService extends BaseService{
	/**
	 * 通过URL获取电影信息
	 * @param httpUrl
	 * @return
	 */
	public List<MovieVO> getMovie(final String httpUrl);
}
