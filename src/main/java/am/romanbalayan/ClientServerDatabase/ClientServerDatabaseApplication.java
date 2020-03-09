package am.romanbalayan.ClientServerDatabase;

import am.romanbalayan.ClientServerDatabase.Utility.HTTP.HttpRequestDemo;
import am.romanbalayan.ClientServerDatabase.Utility.LoadExistingUsers.LoadExistingUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClientServerDatabaseApplication {

	@Autowired
	static LoadExistingUsers loadExistingUsers;


	@Autowired
	static HttpRequestDemo httpRequestDemo;


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ClientServerDatabaseApplication.class, args);
		loadExistingUsers = (LoadExistingUsers) context.getBean("loadUtil");
		loadExistingUsers.loadIntoH2();


		// Listens to the https://clientserverdatabase.000webhostapp.com/
		// Made just for fun
		/*
		httpRequestDemo = (HttpRequestDemo) context.getBean("httpRepo");
		httpRequestDemo.startListener();
		*/
	}

}
