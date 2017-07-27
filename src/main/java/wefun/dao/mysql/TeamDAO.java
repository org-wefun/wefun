package wefun.dao.mysql;

import java.util.List;

import wefun.model.po.TeamPO;

public interface TeamDAO {
	
	List<TeamPO> list();
	
	Integer insert(TeamPO team);
	
	void update(TeamPO team);
	
	TeamPO get(int id);
	
	void delete(int id);

}
