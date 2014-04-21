package local.tux.core.model.field;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="field_property")
public class FieldProperty implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="field_name")
	private String name;
	@Column(name="default_value")
    private String value;
	@Column(name="required")
    private boolean required;
	@Column(name="row_span")
    private int rowSpan;
	@Column(name="col_span")
    private int colSpan;
	@Column(name="form_type")
    private String type;
	@Column(name="row")
	private int row;
	@Column(name="converter_name")
	private String converterName;
	@Transient
    private List<SelectItem> selectList = new ArrayList<SelectItem>();
    
    public FieldProperty() {}
    
    public FieldProperty(String name, String value, String type, boolean required, int colSpan, int rowSpan) {
        this.name = name;
        this.value = value;
        this.required = required;
        this.rowSpan = rowSpan;
        this.colSpan = colSpan;
        this.type = type;
    }

	public void setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
	}

	public void setColSpan(int colSpan) {
		this.colSpan = colSpan;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSelectList(List<SelectItem> selectList) {
		this.selectList = selectList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public int getRowSpan() {
		return rowSpan;
	}

	public int getColSpan() {
		return colSpan;
	}

	public List<SelectItem> getSelectList() {
		return selectList;
	}
	
	public String getType() {
		return type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public String getConverterName() {
		return converterName;
	}

	public void setConverterName(String converterName) {
		this.converterName = converterName;
	}

	@Override
	public String toString() {
		return "FieldProperty [id=" + id + ", name=" + name + ", value="
				+ value + ", required=" + required + ", rowSpan=" + rowSpan
				+ ", colSpan=" + colSpan + ", type=" + type + ", selectList="
				+ selectList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colSpan;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (required ? 1231 : 1237);
		result = prime * result + rowSpan;
		result = prime * result
				+ ((selectList == null) ? 0 : selectList.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldProperty other = (FieldProperty) obj;
		if (colSpan != other.colSpan)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (required != other.required)
			return false;
		if (rowSpan != other.rowSpan)
			return false;
		if (selectList == null) {
			if (other.selectList != null)
				return false;
		} else if (!selectList.equals(other.selectList))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
    
    
}

