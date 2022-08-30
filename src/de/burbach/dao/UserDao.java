package de.burbach.dao;

import java.util.ArrayList;
import java.util.List;

public class UserDao
{

    public UserDao() {
        super();
    }
    
    
    public List<String> findUserNames() {
        List<String> userNames = new ArrayList<String>();
        userNames.add( "Linus Torvalds " );
        userNames.add( "Ada Lovelace" );
        userNames.add( "Alan Turing" );
        userNames.add( "Konrad Zuse" );
        userNames.add( "Edsger W. Dijkstra" );
        userNames.add( "Donald E. Knuth" );
        userNames.add( "Dennis Ritchie" );
        userNames.add( "Ken Thompson" );
        userNames.add( "John W. Backus" );
        userNames.add( "Grace Hopper" );
        userNames.add( "Niklaus Wirth" );
        
        return userNames;
    }
    
}
