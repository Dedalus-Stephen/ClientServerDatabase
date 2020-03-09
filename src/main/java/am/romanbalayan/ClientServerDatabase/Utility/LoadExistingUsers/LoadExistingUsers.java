package am.romanbalayan.ClientServerDatabase.Utility.LoadExistingUsers;

import am.romanbalayan.ClientServerDatabase.DAO.UserDAO;
import am.romanbalayan.ClientServerDatabase.Model.User;
import am.romanbalayan.ClientServerDatabase.Utility.Serialization.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("loadUtil")
public class LoadExistingUsers {
    @Autowired
    Serialization serialization;

    @Autowired
    UserDAO userDAO;

    public void loadIntoH2(){
        ArrayList<User> list = serialization.deserialize();
        if (list != null && !list.isEmpty())
            list.forEach(userDAO::saveUser);
    }
}
