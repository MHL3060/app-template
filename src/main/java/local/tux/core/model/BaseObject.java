package local.tux.core.model;

import java.io.Serializable;

public interface BaseObject<T extends Serializable> extends Serializable{
	
	public T getId();

}
