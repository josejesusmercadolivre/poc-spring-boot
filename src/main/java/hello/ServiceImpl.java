package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {

    @Autowired
    private SimpleUserRepository simpleUserRepository;

    public void save(User user){
        simpleUserRepository.save(user);
    }

    public Iterable<User> list(){
        return simpleUserRepository.findAll();
    }
}
