package local.tux.base.webapp.action;

import java.util.List;

import javax.faces.bean.ManagedBean;

import local.tux.core.dao.MenuDao;
import local.tux.core.model.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ManagedBean
@Component
public class MenuList extends BasePage{

	private MenuDao menuDao;
	
	public MenuList() {
		setSortColumn("label");
	}
	
	@Autowired
	public void setMenuDao(MenuDao menuDao){
		this.menuDao = menuDao;
	}
	
	public List<Menu> getMenus(){
		return sort(menuDao.getAll());
	}
	
}
