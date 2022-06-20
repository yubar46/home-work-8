package service;

import domain.User;
import repository.UserRepository;

public class UserServiceImpl extends BaseServiceImpl<User,Integer, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
