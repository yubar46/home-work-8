package repository;

import domain.User;

import javax.persistence.EntityManager;

public class UserRepositoryIml extends BaseRepositoryImpl<User,Integer>  implements UserRepository {


    public UserRepositoryIml(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<User> getClassObject() {
        return User.class;
    }

        

}
