package local.tux.core.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import local.tux.core.model.Menu;
import local.tux.core.model.Role;
import local.tux.core.model.User;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MenuDaoTest extends BaseDaoTestCase{

	
	private MenuDao menuDao;
	private UserDao userDao;
	private RoleDao roleDao;
	
	private User user;
	@Autowired
	public void setMenuDao(MenuDao menuDao){
		this.menuDao = menuDao;
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Autowired
	public void setRoleDao(RoleDao roleDao){
		this.roleDao = roleDao;
	}
	@Before
	public void setup() {
		
	}
	
	@Test
	public void testGetMenu(){
		user = userDao.get(-1l);
		List<Menu> menues = menuDao.getMenu(user);
		assertEquals(menues.size() ,1);
	}
	@Test
	public void testGetMenuMultipleRoles(){
		user = userDao.get(-1l);
		List<Role> roles = roleDao.getAll();
		for (Role r : roles) {
			user.addRole(r);
		}
		userDao.save(user);
		List<Menu> menues = menuDao.getMenu(user);
		assertEquals(menues.size() ,2);
	}
}
