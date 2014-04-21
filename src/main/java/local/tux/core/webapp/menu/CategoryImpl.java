package local.tux.core.webapp.menu;

import java.util.ArrayList;
import java.util.Collection;

public class CategoryImpl implements Category{

	private String name;
	private Collection<Category> children = new ArrayList<Category>();
	public CategoryImpl(String name){
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Collection<Category> getChildCategories() {
		return children;
	}

}
