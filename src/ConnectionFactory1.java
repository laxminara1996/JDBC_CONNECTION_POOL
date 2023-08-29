import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

import javax.activation.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory1 {

		private static HikariDataSource datasource = null;
		
	static {
       try {
		File file  = new File("Db.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("db.url");
		String username = p.getProperty("db.userName");
		String pwd = p.getProperty("db.password");
		String poolSize = p.getProperty("db.poolSize");

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(pwd);
		System.out.println(config);
		//config.setMaximumPoolSize(poolSize);
		System.out.println("==================33");

		datasource = new HikariDataSource(config);
		
       }catch(Exception e) {
    	   e.printStackTrace();
       }
	}
       public static Connection getDBConnection() throws Exception{
    	   
    	   return datasource.getConnection();
       }
		
	

}
