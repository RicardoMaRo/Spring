package org.plexus.hibernate.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;



@Repository         //indica que es un bean de acceso a datos
@Transactional      //Antes de usar un metodo crea transaccion   y la cierra al salir
public class UserDao {

		/**Esta anotacion es del estandar Java
		 * 	Busca una factoria de Entity manager
		 * 	Construye un entitymanager en particular
		 * 	Inyectarlo en la variable siguiente
		 */
		
	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(User user) {
		entityManager.persist(user);
	}
	
	public void delete(User user) {
		if (entityManager.contains(user))
			entityManager.remove(user);
		else
			entityManager.remove(entityManager.merge(user));
	}
	
	public void update(User user) {  
		entityManager.merge(user);
	}
	
	//Metodos de consulta
	public User getById(int id) {
		return entityManager.find(User.class,1);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAll(){
		return entityManager.createQuery("select u from User u").getResultList();
		
	}
	
	
}
