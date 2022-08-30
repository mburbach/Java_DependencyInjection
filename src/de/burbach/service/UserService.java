package de.burbach.service;

import java.util.List;

import de.burbach.dao.UserDao;
import de.mbuframework.injection.*;
import de.mbuframework.service.Service;

public class UserService extends Service
{
    @MegaInjection( singleton = true )
    private UserDao userDao;

    public List < String > getAllUsers()
    {
        if( userDao != null ) {
            return userDao.findUserNames();
        }
        System.out.println( "userDao has no instance" );
        return null;

    }

}
