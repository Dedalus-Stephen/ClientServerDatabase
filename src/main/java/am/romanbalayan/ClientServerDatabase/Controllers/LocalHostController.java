package am.romanbalayan.ClientServerDatabase.Controllers;

import am.romanbalayan.ClientServerDatabase.DAO.UserDAO;
import am.romanbalayan.ClientServerDatabase.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LocalHostController {
    @Autowired
    UserDAO userDAO;

    @RequestMapping("/userLoginPage")
    public String login() {
        return "userLoginPage";
    }

    @RequestMapping("/acceptUser")
    public ModelAndView acceptUser(User user) {
        ModelAndView mv = new ModelAndView();
        if (user.getName() != null && !user.getName().isEmpty() && !user.getPassword().isEmpty()) {
            userDAO.saveUser(user);
            mv.addObject("success",
                    "Success. Your account has been created and stored on server");
        } else {
            mv.addObject("failed", "Sorry, try again. " +
                    "Both fields must be filled");
        }
        mv.setViewName("userLoginPage");
        return mv;
    }
}
