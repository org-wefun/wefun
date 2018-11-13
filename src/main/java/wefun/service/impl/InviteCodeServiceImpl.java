package wefun.service.impl;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.dao.mysql.InviteCodeDAO;
import wefun.model.po.InviteCode;
import wefun.service.InviteCodeService;

@Service
public class InviteCodeServiceImpl implements InviteCodeService {
	@Autowired
	private InviteCodeDAO inviteCodeDAO;

	@Override
	public void insert(InviteCode inviteCode) {
		if (null == inviteCode) {
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		String code = inviteCode.getCode();
		InviteCode inviteCodeDB = null;
		if (StringUtils.hasText(code)) {
			// 如果传了就去验证数据库是否已经存在
			inviteCodeDB = inviteCodeDAO.get(code);
			if (inviteCodeDB != null) {
				throw new BusinessRuntimeException(CodeAndMsg.SYSTEM_EXCEPTION.getCode(), "邀请码已经存在,请重新输入");
			}
		} else {
			while (inviteCodeDB != null) {
				code = this.getCode();
				inviteCodeDB = inviteCodeDAO.get(code);
			}

		}
		inviteCode.setCode(code.toUpperCase());
		inviteCodeDAO.insert(inviteCode);
	}

	@Override
	public void update(InviteCode inviteCode) {
		if (null == inviteCode) {
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		inviteCodeDAO.update(inviteCode);
	}

	@Override
	public void delete(String code) {
		if (null == code) {
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		inviteCodeDAO.delete(code);
	}

	@Override
	public List<InviteCode> getList() {
		return inviteCodeDAO.getList();
	}

	private String getCode() {
		// 生成随机数字字符串
		return RandomStringUtils.random(6, new char[] { '1','2','3','4' ,'5', '6', '7', '8', '9','0', 'A', 'B', 'C', 'D', 'E', 'F' });
	}

	public static void main(String[] args) {
		System.out.println(new InviteCodeServiceImpl().getCode());
		System.out.println(new InviteCodeServiceImpl().getCode());

	}

	@Override
	public void check(String code) {
		if(!StringUtils.hasText(code)){
			throw new BusinessRuntimeException(CodeAndMsg.SYSTEM_EXCEPTION.getCode(), "请输入邀请码");
		}
		InviteCode inviteCodeDB = inviteCodeDAO.get(code.toUpperCase());
		if(null == inviteCodeDB){
			throw new BusinessRuntimeException(CodeAndMsg.SYSTEM_EXCEPTION.getCode(), "无效的邀请码");
		}
		final long expire = inviteCodeDB.getExpire();
		if(expire != 0  && expire < System.currentTimeMillis()){
			throw new BusinessRuntimeException(CodeAndMsg.SYSTEM_EXCEPTION.getCode(), "邀请码已经过期");
		}
	}

}
