package wefun.service;

import java.util.List;

import wefun.model.po.InviteCode;

public interface InviteCodeService {
	
	void insert(InviteCode inviteCode);
	
	void update(InviteCode inviteCode);
	
	void delete(String code);
	
	void check(String code);
	
	List<InviteCode> getList(); 
	
}
