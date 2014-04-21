package local.tux.core.webapp.menu;

import java.util.Collection;

public interface Category {
    String getName();
    Collection<Category> getChildCategories();
}
