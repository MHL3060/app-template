package local.tux.core.webapp.menu;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import local.tux.base.webapp.action.BasePage;
import local.tux.core.dao.MenuDao;
import local.tux.core.model.Menu;
import local.tux.core.model.User;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ManagedBean
@Component
public class MenuBean extends BasePage{

	private Log log = LogFactory.getLog(MenuBean.class);
	private MenuModel model;

	private MenuDao menuDao;
	@Autowired
	public void setMenuDao(MenuDao menuDao){
		this.menuDao = menuDao;
	}
	public MenuBean() {
		model = new DefaultMenuModel();
		
		/*String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		log.info(user);
		// First submenu
		DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");

		DefaultMenuItem item = new DefaultMenuItem("External");
		item.setUrl("http://www.primefaces.org");
		item.setIcon("ui-icon-home");
		firstSubmenu.addElement(item);

		model.addElement(firstSubmenu);

		// Second submenu
		DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");

		item = new DefaultMenuItem("Save");
		item.setIcon("ui-icon-disk");
		item.setUrl("/login");
		// item.setCommand("#{menuBean.save}");
		// item.setUpdate("messages");
		secondSubmenu.addElement(item);

		item = new DefaultMenuItem("Delete");
		item.setIcon("ui-icon-close");
		item.setCommand("#{menuBean.delete}");
		item.setAjax(false);
		secondSubmenu.addElement(item);

		item = new DefaultMenuItem("Redirect");
		item.setIcon("ui-icon-search");
		// item.setCommand("#{menuBean.redirect}");
		secondSubmenu.addElement(item);

		model.addElement(secondSubmenu);*/
	}
	
	public void populateMenu() {
		String loginName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		if (StringUtils.isEmpty(loginName) == false){
			User user = userManager.getUserByUsername(loginName);
			List<Menu> menus = menuDao.getTopMenu(user);
			for (Menu menu : menus){
				DefaultSubMenu item = new DefaultSubMenu(menu.getLabel());
				item.setIcon(menu.getIconUrl());
				addMenu(item, menus);
				model.addElement(item);
			}
		}
	}
	private void addMenu(DefaultSubMenu item, Collection<Menu> menus){
		for (Menu m : menus){
			DefaultMenuItem mi = new DefaultMenuItem(m.getLabel());
			mi.setUrl(m.getUrl());
			item.addElement(mi);
		}
	}
	public MenuModel getModel() {
		populateMenu();
		return model;
	}
}
