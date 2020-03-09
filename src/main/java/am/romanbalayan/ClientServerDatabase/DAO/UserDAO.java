package am.romanbalayan.ClientServerDatabase.DAO;

import am.romanbalayan.ClientServerDatabase.Model.User;
import am.romanbalayan.ClientServerDatabase.Utility.Serialization.Serialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {
    default <S extends User> S saveUser(S s) {
        if(findByName(s.getName()).isEmpty()) {
            new Serialization().serialize(s);
            return save(s);
        }
        return null;
    }
    List<User> findByName(String name);
}
