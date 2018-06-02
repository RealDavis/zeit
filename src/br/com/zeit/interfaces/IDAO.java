package br.com.zeit.interfaces;

import java.util.List;

import br.com.zeit.exceptions.PersistenciaException;

public interface IDAO<T> {

	public boolean insert(T obj);
	
	public boolean edit(T obj);
	
	public List<T> getAll() throws PersistenciaException;
	
	public boolean getByid(int id);
	
}
