package mx.com.sidlors.persistence.jpa.test;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.hsqldb.cmdline.SqlFile;
import com.ibatis.common.jdbc.ScriptRunner;
import mx.com.sidlors.persistence.jpa.test.app.Main;

public class TransactionsTest {
	
	
	private static final Logger out = Logger
			.getLogger(TransactionsTest.class);
	private Main main;
	Connection conn;  
//	private List<Person> listPerson=null;
	
	@BeforeClass
	public static void setDB() throws SQLException{

	  //RunScript.execute( "jdbc:h2:mem:HR;MODE=Oracle;DB_CLOSE_DELAY=-1;", "", "", "src/test/resources/sql/export.sql", null, false);
	  
	  //"jdbc:derby://myhost:1527/memory:myDB;drop=true"
	  
	}



	@Before
	public void setUp() throws Exception {
		
		Main main=new  Main();
//		SqlFile sql=new SqlFile(new File( "src/test/resources/sql/export.sql") );
//		 // Load the HSQL Database Engine JDBC driver
//    // hsqldb.jar should be in the class path or made part of the current jar
//    Class.forName("org.hsqldb.jdbcDriver");
//
//    // connect to the database.   This will load the db files and start the
//    // database if it is not alread running.
//    // db_file_name_prefix is used to open or create files that hold the state
//    // of the db.
//    // It can contain directory names relative to the
//    // current working directory
//    conn = DriverManager.getConnection("jdbc:hsqldb:mem:HR;sql.syntax_ora=true", "sa",  "");   
//    sql.setConnection( conn );
//		sql.execute();
		String aSQLScriptFilePath = "src/test/resources/sql/export.sql";
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/memory:myDB;drop=true");
		try {
      // Initialize object for ScripRunner
      ScriptRunner sr = new ScriptRunner(con, false, false);

      // Give the input file to Reader
      Reader reader = new BufferedReader(
                               new FileReader(aSQLScriptFilePath));

      // Exctute script
      sr.runScript(reader);

    } catch (Exception e) {
      System.err.println("Failed to Execute" + aSQLScriptFilePath
          + " The error is " + e.getMessage());
    }
		
	}

	@Test
	public void test() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		try {
			factory = Persistence.createEntityManagerFactory("PersistenceUnitTest");
			entityManager = factory.createEntityManager();
			assertNotNull(factory);
			assertNotNull(entityManager);
			main.persistGeek(entityManager);
//			listPerson=main.loadPersons(entityManager);
//			assertNotNull(listPerson);
//			out.error(listPerson.size());
//			
//			for (Person p : listPerson){
//				
//				out.info(p.getFirstName()+" "+p.getPhones());
//			}
		}catch (Exception e) {
			out.error(e.getMessage());
		}finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		
		
	}

}