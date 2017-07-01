package wefun.dao.mysql;

import wefun.model.po.UserPO;

public interface UserDAO {
	/**
	 * 根据账号找用户信息
	 * @param account
	 * @return
	 */
	public UserPO findByAccount(String account);

}
