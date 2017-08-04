package com.sap.wtl.services.impls;

import com.sap.wtl.daos.UserDao;
import com.sap.wtl.models.User;
import com.sap.wtl.services.UserService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
public class DefaultUserService implements UserService {
    @Resource
    private UserDao hibernateUserDao;

    @Override
    public void createUser(User user) {
        hibernateUserDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        hibernateUserDao.update(user);
    }

    @Override
    public void createUpdateUser(User user) {
        hibernateUserDao.saveOrUpdate(user);
    }

    @Override
    public List<User> listUser() {
        return listUser();
    }

    @Override
    public void deleteUser(int deleteId) {
        hibernateUserDao.delete(deleteId);
    }

    @Override
    public User getUser(int id) {
        return hibernateUserDao.getUser(id);
    }

//    @Override
//    public User registerNewUserAccount(User accountDto)
//            throws EmailExistsException {
//
//        if (emailExist(accountDto.getEmail())) {
//            throw new EmailExistsException(
//                    "There is an account with that email adress: "
//                            +  accountDto.getEmail());
//        }
//
//    }
//    private boolean emailExist(String email) {
//        User user = hibernateUserDao.findByEmail(email);
//        if (user != null) {
//            return true;
//        }
//        return false;
//    }
}
