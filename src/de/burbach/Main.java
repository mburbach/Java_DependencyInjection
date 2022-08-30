package de.burbach;

import de.burbach.service.UserService;

public class Main
{
    public static void main(String[] args ) {
        UserService userService = new UserService();
        
        for( String name : userService.getAllUsers() ) {
            System.out.println( name );
        }        
        
    }
    
}
