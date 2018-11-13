package wefun.service;

import wefun.model.po.UserPO;

public interface UserService extends BaseService{
	UserPO getUser(String account);
    String login(UserPO userPO);
	void modifyPwd(UserPO userPO);
}
