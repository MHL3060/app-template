package local.tux.core.dao;

import java.util.List;

import local.tux.core.model.Menu;
import local.tux.core.model.User;

public interface MenuDao extends GenericDao<Menu, Long>{

	public List<Menu> getTopMenu(User user);
	
}
