package local.tux.core.webapp.menu;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIViewRoot;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import org.primefaces.component.menuitem.UIMenuItem;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;

public class CategoryMenuModel implements MenuModel, ActionListener, Serializable {
    
    private static final long serialVersionUID = -2866930830066526910L;
    protected Category category;
    protected List<MenuElement> contents = new ArrayList<>();
    protected static UIViewRoot uiViewRoot = new UIViewRoot();
    
    public Category getCategory() {
        return category;
    }
    
    // Creates and adds the MenuItems to the Menu
    public void setCategory(Category category) throws IOException {
        this.category = category;
        resetContents();
        for(Category childCategory : category.getChildCategories()) {
        	UIMenuItem subCategoryItem = new UIMenuItem();
            subCategoryItem.setValue(childCategory.getName());
            subCategoryItem.setId(uiViewRoot.createUniqueId());
            subCategoryItem.setAjax(false);
            subCategoryItem.getAttributes().put("category", childCategory);
            subCategoryItem.addActionListener(this);
            addMenuItem(subCategoryItem);
        }
    }
    
    // Gets called when a MenuItem is clicked. The clicked MenuItem becomes the new top level MenuItem.
    @Override
    public void processAction(ActionEvent event)
            throws AbortProcessingException {
        if(event.getSource().getClass() == MenuItem.class) {
             UIMenuItem sourceItem = (UIMenuItem) event.getSource();
             Category newCategory = (Category) sourceItem.getAttributes().get("category");
             try {
            	 setCategory(newCategory);
             }catch (IOException e){
            	 e.printStackTrace();
             }
        }
    }
    
    
    
    public void addSubmenu(Submenu submenu) {
        contents.add(submenu);
    }

    
    public void addMenuItem(MenuItem menuItem) {
        contents.add(menuItem);
    }
    
    protected void resetContents() {
        contents = new ArrayList<MenuElement>();
    }

	@Override
	public List<MenuElement> getElements() {
		return contents;
	}

	@Override
	public void addElement(MenuElement element) {
		contents.add(element);
		
	}

	@Override
	public void generateUniqueIds() {
		 Math.random();
		
	}
}