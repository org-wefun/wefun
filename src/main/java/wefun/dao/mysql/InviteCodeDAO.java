package wefun.dao.mysql;

import java.util.List;

import wefun.model.po.InviteCode;

public interface InviteCodeDAO {
	
	void insert(InviteCode inviteCode);
	
	void update(InviteCode inviteCode);
	
	void delete(String code);
	
	InviteCode  get(String code);
	
	List<InviteCode> getList(); 

}
