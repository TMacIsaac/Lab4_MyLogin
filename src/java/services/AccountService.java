
package services;



/**
 *
 * @author 838771
 */
public class AccountService {
    
    public User login(String username, String password){
       
        
            if(username.equals("adam") || username.equals("betty")){
                
             if(password.equals("password")){   
                 User user = new User(username);
                return user; 
            }
        }
            
        return null;
    }
    
}
