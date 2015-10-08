package jIslas.aspects;

import jIslas.Utils.PersistentManagerFactory;
import jIslas.model.Administrador;
import jIslas.model.LogAuditoria;
import jIslas.model.Usuario;

import java.lang.reflect.Method;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public aspect AuditAspect {

	//POINTCUTS	
  
     
   public pointcut altaPointcut(Object unObject):execution( void *jIslas.DAOImpl.GenericDao.alta(Object)) && args(unObject);
   
   public pointcut updatePointcut(Object unObject):execution( void *jIslas.DAOImpl.GenericDao.update(Object)) && args(unObject);
   
   public pointcut eliminarPointcut(Object unObject):execution( void *jIslas.DAOImpl.GenericDao.eliminar(Object)) && args(unObject);
  
   
      
 	
  //ADVICES 
   
   void around(Object unObject): altaPointcut(unObject){
	   proceed(unObject);
	   auditar("Alta",unObject);
	   
   }
   void around(Object unObject): updatePointcut(unObject){
	   proceed(unObject);
	   auditar("Actualizar",unObject);
	   
   }
   void around(Object unObject): eliminarPointcut(unObject){
	   proceed(unObject);
	   auditar("Eliminar",unObject);
	   
   }
   
   private EntityManager entityManager = PersistentManagerFactory.getEntityManager();

	EntityManager getEntityManager() {
		return entityManager;
	}
	EntityManager setEntityManager() {
		return entityManager;
	}

   public void auditar(String operacion, Object unObject){
	   try{
		   Class clas = unObject.getClass();
		   Class[] cArg = new Class[0];
		   Method met=null;
		   System.out.println("Ejecucion oper"+operacion+" obj:"+unObject.toString());
		   
		   if (clas.equals(Usuario.class) || clas.equals(Administrador.class)) {
			    met = clas.getSuperclass().getDeclaredMethod("getId", cArg);

		   }else{
			   met = clas.getDeclaredMethod("getId",cArg);   

		   }
		      
		   Long id = (Long)met.invoke(unObject, new Object[0]);
		  
		   LogAuditoria lA = new LogAuditoria(operacion,new Date(),clas.getSimpleName(),id);
		   EntityTransaction et = this.entityManager.getTransaction();
			et.begin();
			this.entityManager.persist(lA);
			et.commit();
		   }
		   catch(Exception e){
			   System.out.println(e.getCause());
		   }
   }
}
