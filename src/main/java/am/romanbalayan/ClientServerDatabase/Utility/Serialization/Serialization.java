package am.romanbalayan.ClientServerDatabase.Utility.Serialization;

import am.romanbalayan.ClientServerDatabase.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;

@Component
public class Serialization {
    Gson gson = new GsonBuilder()
        .setLenient()
        .create();

    File file;

    public Serialization() {
        String path = "src/main/java/am/romanbalayan/ClientServerDatabase/Utility/Serialization/UserLocalDB.txt";
        file = new File(path);
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("File Created");
                } else throw new FileCreateException();
            }
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("\u001b[32m Please, check the path correctness\u001b[0m \n");
            System.exit(0);
        } catch (FileCreateException e){
            System.exit(0);
        }
    }

    public void serialize(User user) {
        ArrayList<User> list = deserialize();
        if (list == null) list = new ArrayList<>();
        if(list.stream().noneMatch(x -> user.getName().equals(x.getName()))) list.add(user);
        String json = gson.toJson(list);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write(json);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<User> deserialize() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            return gson.fromJson(reader, new TypeToken<ArrayList<User>>(){}.getType());
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}

class FileCreateException extends Exception{
    @Override
    public void printStackTrace() {
        System.out.println("\u001b[0m Exception creating file. Exiting \u001b[32m");
    }
}