package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    private ServiceImpl service;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void saveUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getuserName());
        user.setLastname(userRequest.getLastName());
        user.setFirstname(userRequest.getFirstName());
        service.save(user);

    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Iterable<User> getUsers() {

        return service.list();

    }

}