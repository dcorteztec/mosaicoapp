package br.com.mosaicomodel.model.interfaces;

import java.io.Serializable;

public interface IEntity extends Serializable {
	public void setId(Object id);

	public Object getId();
}
