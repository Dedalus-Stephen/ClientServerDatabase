package am.romanbalayan.ClientServerDatabase.Utility.HTTP;

import am.romanbalayan.ClientServerDatabase.DAO.UserDAO;
import am.romanbalayan.ClientServerDatabase.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component("httpRepo")
public class HttpRequestDemo {
    @Autowired
    UserDAO userDAO;

    public void startListener(){
        ScheduledExecutorService execService = Executors.newScheduledThreadPool(5);
        execService.scheduleAtFixedRate(()->{
            try {
                URL url = new URL("https://clientserverdatabase.000webhostapp.com/db.txt");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line = reader.readLine();
                System.out.println(line);


                String[] data = line.split(" ");
                if(data[0] != null && data.length == 2) {
                    User user = new User(data[0], data[1]);
                    userDAO.saveUser(user);
                }

            } catch (IOException e) {
                System.out.println("Listener exception");
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }

}
