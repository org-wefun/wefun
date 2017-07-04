package wefun.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.commons.util.MD5Utils;
import wefun.dao.mysql.UserDAO;
import wefun.model.po.UserPO;
import wefun.service.CacheService;
import wefun.service.UserService;
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	@Autowired
    private UserDAO userDAO;
	@Autowired
	private CacheService cacheService;
	@Override
	public UserPO getUser(String account) {
		if(!StringUtils.hasText(account)){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		UserPO userPO = userDAO.findByAccount(account);
		return userPO;
	}
	
	@Override
	public String login(UserPO userPO) {
		if(null == userPO){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		} 
		final String account = userPO.getAccount().trim();
		final String password = userPO.getPassword().trim();
		if(!StringUtils.hasText(account)){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		if(!StringUtils.hasText(password)){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		UserPO userPODB = userDAO.findByAccount(account);
		if(null == userPODB){
			throw new BusinessRuntimeException(CodeAndMsg.INVALID_ACCOUNT);
		}
		final String password_DB = userPODB.getPassword();
		if(!Objects.equals(password, password_DB)){
			throw new BusinessRuntimeException(CodeAndMsg.PASSWORD_ACCOUNT_ERROR);
		}
		//写入缓存
		final String key = MD5Utils.MD5(account);
		cacheService.set(key, userPODB);
		return key;
	}

}
