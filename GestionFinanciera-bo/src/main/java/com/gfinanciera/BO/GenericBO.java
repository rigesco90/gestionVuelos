package com.gfinanciera.BO;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface GenericBO {

	public <T> List<T> findAll(Class<T> clazz);
	
	public <T> List<T> findAllJoinFetch(Class<?> clazz, String...  joins);

	public <T> T edit(T arg0);
	
	public <T> T searchObjectById(Class<T> clazz, int id);

	void create(Object arg0);
	
	public <T> T createReturnObject(T arg0);

	public <T> void delete(Class<T> type, Object id);
	
	public <T> List<T> findAllExceptId(Class<T> clazz, Object id);

	public <T> List<T> findAll(Class<T> clazz, Object query);

	public <T> T find(Object query);	
	
	public <T> Long Count(Class<T> claseEntidad);
	
	public <T> T searchLast(Class<T> claseEntidad);
	
	public <T> List<T> findWithNamedQuery(String namedQueryName);

	public <T> List<T> findWithNamedQuery(String namedQueryName, Map<?, ?> parameters);

	public <T> List<T> findWithNamedQuery(String queryName, int resultLimit);

	public <T> List<T> findByNativeQuery(String sql);

	public Long countTotalRecord(String namedQueryName);

	public <T> List<T> findWithNamedQuery(String namedQueryName, Map<?, ?> parameters, int resultLimit);

	public <T> List<T> findWithNamedQuery(String namedQueryName, Map<?, ?> parameters, int start, int end);

	public <T> List<T> findWithNamedQuery(String namedQueryName, int start, int end);

	public <T> List<T> searchAllWithOneArg(Class<T> claseEntidad, String parametro, String valor);

	public <T> T searchElementWithOneArg(Class<T> claseEntidad, String parametro, String valor);

	public <T> T searchElementWithOneArgInteger(Class<T> claseEntidad, String parametro, int valor);

	public <T> T searchElementWithOneArgLong(Class<T> claseEntidad, String parametro, long valor);
	
	public <T> T searchObjectWithOneArg(Class<T> claseEntidad, String parametro, String valor);

}
