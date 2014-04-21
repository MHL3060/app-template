package local.tux.base.webapp.action;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import local.tux.core.model.field.FieldProperty;


import org.primefaces.extensions.model.dynaform.DynaFormControl;
import org.primefaces.extensions.model.dynaform.DynaFormLabel;
import org.primefaces.extensions.model.dynaform.DynaFormModel;
import org.primefaces.extensions.model.dynaform.DynaFormRow;
import org.springframework.stereotype.Component;

@Component("dynaForm")
public class DynaForm extends BasePage implements Serializable {

   /**
	 * 
	 */
	private static final long serialVersionUID = 7944820047496743566L;

	private DynaFormModel model;

   private static List<SelectItem> LANGUAGES = new ArrayList<SelectItem>();
   
   public DynaForm() {
	   log.info("hello");
   }
   @PostConstruct 
   public void initialize(){
	   model = new DynaFormModel();

      // add rows, labels and editable controls
      // set relationship between label and editable controls to support outputLabel with "for" attribute

      // 1. row
	  List<FieldProperty> fields = new ArrayList<FieldProperty>();
	  int rowNum = 0;
	  DynaFormRow row = model.createRegularRow();
      for (FieldProperty fp : fields){
    	  if (rowNum != fp.getRow()){
    		  row = model.createRegularRow();
    		  rowNum++;
    	  }
    	  DynaFormLabel label = row.addLabel(fp.getName());
    	  DynaFormControl control = row.addControl(fp.getValue(), fp.getType(), fp.getColSpan(), fp.getRowSpan());
    	  label.setForControl(control);
      
      }
      

   /*   DynaFormLabel label11 = row.addLabel("Author", 1, 1);
      DynaFormControl control12 = row.addControl(new FieldProperty("Author", true), "input", 1, 1);
      label11.setForControl(control12);

      DynaFormLabel label13 = row.addLabel("ISBN", 1, 1);
      DynaFormControl control14 = row.addControl(new FieldProperty("ISBN", true), "input", 1, 1);
      label13.setForControl(control14);

      // 2. row
      row = model.createRegularRow();

      DynaFormLabel label21 = row.addLabel("Title", 1, 1);
      DynaFormControl control22 = row.addControl(new FieldProperty("Title", false), "input", 3, 1);
      label21.setForControl(control22);

      // 3. row
      row = model.createRegularRow();

      DynaFormLabel label31 = row.addLabel("Publisher", 1, 1);
      DynaFormControl control32 = row.addControl(new FieldProperty("Publisher", false), "input", 1, 1);
      label31.setForControl(control32);

      DynaFormLabel label33 = row.addLabel("Published on", 1, 1);
      DynaFormControl control34 = row.addControl(new FieldProperty("Published on", false), "calendar", 1, 1);
      label33.setForControl(control34);

      // 4. row
      row = model.createRegularRow();

      DynaFormLabel label41 = row.addLabel("Language", 1, 1);
      DynaFormControl control42 = row.addControl(new FieldProperty("Language", false), "select", 1, 1);
      label41.setForControl(control42);

      DynaFormLabel label43 = row.addLabel("Description", 1, 2);
      DynaFormControl control44 = row.addControl(new FieldProperty("Description", false), "textarea", 1, 2);
      label43.setForControl(control44);

      // 5. row
      row = model.createRegularRow();

      DynaFormLabel label51 = row.addLabel("Rating", 1, 1);
      DynaFormControl control52 = row.addControl(new FieldProperty("Rating", 3, true), "rating", 1, 1);
      label51.setForControl(control52);*/
    }

    public DynaFormModel getModel() {
        return model;
    }

    public String submitForm() {
       return "";
    }

    public List<SelectItem> getLanguages() {
        if (LANGUAGES.isEmpty()) {
            LANGUAGES.add(new SelectItem("en", "English"));
            LANGUAGES.add(new SelectItem("de", "German"));
            LANGUAGES.add(new SelectItem("ru", "Russian"));
            LANGUAGES.add(new SelectItem("tr", "Turkish"));
        }

        return LANGUAGES;
    }
}

