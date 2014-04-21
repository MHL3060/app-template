package local.tux.core.webapp.menu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@SessionScoped
public class BloggerBean {
    
    private MenuModel simpleMenuModel = new DefaultMenuModel();
   
    public BloggerBean() {
    	DefaultMenuItem menuItem = new DefaultMenuItem();
        menuItem.setId("Computers");
        menuItem.setUrl("#");
        simpleMenuModel.addElement(menuItem);
       
        menuItem = new DefaultMenuItem();
        menuItem.setValue("Clothes");
        menuItem.setUrl("#");
        simpleMenuModel.addElement(menuItem);
        
        menuItem = new DefaultMenuItem();
        menuItem.setValue("Gaming");
        menuItem.setUrl("#");
        simpleMenuModel.addElement(menuItem);
        
        menuItem = new DefaultMenuItem();
        menuItem.setValue("Books");
        menuItem.setUrl("#");
        simpleMenuModel.addElement(menuItem);
        
        menuItem = new DefaultMenuItem();
        menuItem.setValue("Jewellery and Watches");
        menuItem.setUrl("#");
        simpleMenuModel.addElement(menuItem);
    }
    
    public MenuModel getSimpleMenuModel() {
        return simpleMenuModel;
    }
}