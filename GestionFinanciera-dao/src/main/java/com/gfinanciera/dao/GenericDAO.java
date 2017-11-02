package com.gfinanciera.dao;

import java.util.List;
import java.util.Map;


public interface GenericDAO{
	
	 public <T> List<T> findAll(Class<?> clazz);
	 
	 public <T> List<T> findAllJoinFetch(Class<?> clazz,String... joins);

	 public <T> T edit(T arg0); 

	 public void create(Object arg0);
	 
	 public <T> T createReturnObject(T arg0);

	 public void delete(Class<?> type, Object id);
	 
	 public <T> List<T> findAllExceptId(Class<T> clazz, Object id);

	 public <T> List<T> findAll(Class<?> clazz,Object query);

	 public <T> T find(Object query);
	 
	 public <T> T searchObjectById(Class<T> clazz, int id);
	 
	 /**
		 * Devuelve la cantidad de registros de una entidad
	 * @param <T>
		 * 
		 * @param claseEntidad
		 *            Nombre simple de la entidad
		 * @return numeroRegistros
		 */
		public <T> Long Count(Class<T> claseEntidad);

		/**
		 * Busca el ultimo objeto agregado en una entidad.
		 * @param <T>
		 * 
		 * @param claseEntidad
		 *            Nombre simple de la entidad.
		 * @return T ultimo objeto ingresado.
		 */
		public <T> T searchLast(Class<T> claseEntidad);

		/**
		 * Devuelve una lista de registros definida en el namedQuery
		 * 
		 * @param namedQueryName
		 * @return List
		 */
		@SuppressWarnings("rawtypes")
		public List findWithNamedQuery(String namedQueryName);

		/**
		 * Devuelve una lista de registros definida en el namedQuery, recibe los
		 * parametros del query
		 * 
		 * @param namedQueryName
		 * @param parameters
		 * @return List
		 */
		@SuppressWarnings("rawtypes")
		public List findWithNamedQuery(String namedQueryName, Map parameters);

		/**
		 * Devuelve una lista de registros definida en el namedQuery, tiene un
		 * limite de registros a devolver
		 * 
		 * @param queryName
		 * @param resultLimit
		 * @return List
		 */
		@SuppressWarnings("rawtypes")
		public List findWithNamedQuery(String queryName, int resultLimit);

		/**
		 * Devuelve una lista de registros definida en un NativeQuery
		 * @param <T>
		 * 
		 * @param <T>
		 * @param sql
		 * @param type
		 * @return List
		 */
		public <T> List<T> findByNativeQuery(String sql);

		/**
		 * Devuelve el total de registros de una namedQuery
		 * 
		 * @param namedQueryName
		 * @return Long
		 */
		public Long countTotalRecord(String namedQueryName);

		/**
		 * Devuelve una lista con los registros definidos en el namedQuery,
		 * pasandole los parametros y definiendole un limite de registros a
		 * devolver.
		 * 
		 * @param namedQueryName
		 * @param parameters
		 * @param resultLimit
		 * @return List
		 */
		@SuppressWarnings("rawtypes")
		public List findWithNamedQuery(String namedQueryName, Map parameters, int resultLimit);

		/**
		 * Devuelve una lista con los registros definidos en el namedQuery,
		 * pasandole los parametros y definiendole un limite inferior y superior de
		 * registros a devolver.
		 * 
		 * @param namedQueryName
		 * @param parameters
		 * @param resultLimit
		 * @return List
		 */
		@SuppressWarnings("rawtypes")
		public List findWithNamedQuery(String namedQueryName, Map parameters, int start, int end);

		/**
		 * Returns the number of records that will be used with lazy loading /
		 * pagination
		 * 
		 * @param namedQueryName
		 * @param start
		 * @param end
		 * @return List
		 */
		@SuppressWarnings("rawtypes")
		public List findWithNamedQuery(String namedQueryName, int start, int end);

		/**
		 * Funcion encargad de traer una lista de objetos de una entidad definida,
		 * ingresando el nombre del parametro y el valor de ese parametro, tener en
		 * cuenta que debe ser de tipo String, en caso dado que el valor que se esta
		 * dando sea de otro tipo, modificar este metodo a conveniencia.
		 * @param <T>
		 * 
		 * @param claseEntidad
		 * @param parametro
		 * @param valor
		 * @return Lista de objetos encontrados según lo especificado
		 */

		public <T> List<T> searchAllWithOneArg(Class<T> claseEntidad, String parametro, String valor);

		/**
		 * 
		 * Funcion encargada de retornar un objeto de una entidad determinada segun
		 * el parametro buscado
		 * @param <T>
		 * 
		 * @param claseEntidad
		 *            Nombre Entidad.class
		 * @param parametro
		 *            Nombre de la propiedad
		 * @param valor
		 *            Valor de la propiedad (Debe ser de tipo String)
		 * @return Objeto encontrado
		 */

		public <T> T searchElementWithOneArg(Class<T> claseEntidad, String parametro, String valor);

		/**
		 * 
		 * Funcion encargada de retornar un objeto de una entidad determinada segun
		 * el parametro buscado
		 * @param <T>
		 * 
		 * @param claseEntidad
		 *            Nombre Entidad.class
		 * @param parametro
		 *            Nombre de la propiedad
		 * @param valor
		 *            Valor de la propiedad (Debe ser de tipo int)
		 * @return Objeto encontrado
		 */
		public <T> T searchElementWithOneArgInteger(Class<T> claseEntidad, String parametro, int valor);

		/**
		 * 
		 * Funcion encargada de retornar un objeto de una entidad determinada segun
		 * el parametro buscado
		 * @param <T>
		 * 
		 * @param claseEntidad
		 *            Nombre Entidad.class
		 * @param parametro
		 *            Nombre de la propiedad
		 * @param valor
		 *            Valor de la propiedad (Debe ser de tipo long)
		 * @return Objeto encontrado
		 */

		public <T> T searchElementWithOneArgLong(Class<T> claseEntidad, String parametro, long valor);
		
		public <T> T searchObjectWithOneArg(Class<T> claseEntidad, String parametro, String valor);
}
