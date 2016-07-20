package tableTest;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class createTableTest {

	   public static void main(String args[]) throws ClassNotFoundException{
		  
		   new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	  }
		 
		 

}
