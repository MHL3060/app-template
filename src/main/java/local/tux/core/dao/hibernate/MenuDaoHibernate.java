package local.tux.core.dao.hibernate;

import java.util.List;

import local.tux.core.dao.MenuDao;
import local.tux.core.model.Menu;
import local.tux.core.model.User;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDaoHibernate extends GenericDaoHibernate<Menu, Long> implements MenuDao {

	public MenuDaoHibernate() {
		super(Menu.class);
		
	}
	@Override
	public List<Menu> getTopMenu(User user) {
		
		@SuppressWarnings("unchecked")
		List<Menu> result = getSession().createCriteria(Menu.class, "menu")
						.createCriteria("menu.roles", "role")
						.add(Restrictions.in("role.name", getRoleNames(user)))
						.add(Restrictions.isNull("menu.parent"))
						//.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
						.list();
		return result;			
	}

}
