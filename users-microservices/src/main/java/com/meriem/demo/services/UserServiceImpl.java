package com.meriem.demo.services;


import com.meriem.demo.entities.Role;

import java.util.List;
import java.util.Random;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.meriem.demo.entities.User;
import com.meriem.demo.repos.RoleRepository;
import com.meriem.demo.repos.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRep;
	@Autowired
	RoleRepository roleRep;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	 @Value("${spring.mail.username}")
	    private String from;
	    @Autowired
	    private JavaMailSender mailSender;
	    public String generateCode() {
	        Random rand = new Random();
	        return String.format("%06d", rand.nextInt(1000000));
	    }
	    public String sendCodeByEmail(String email) {
	        // Générez le code
	        String code = generateCode();

	        // Envoyez le code par e-mail
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setFrom(from);
	        msg.setTo(email);
	        msg.setSubject("Your authentication code is:");

	        msg.setText("Dear user," +
	                "\n\n" +
	                "Welcome! This is your code: " +
	                "\n\n" + code +
	                "\n\n");
	        mailSender.send(msg);
	        return code;
	    }
	    private User findByEmail(String email) {
	        return userRep.findByEmail(email);
	    }
	    /*@Override
	    public User verifyCode(String email,String verifcode) {
	    	User user=findByEmail(email);
	    	if(user!=null && user.getCode()== verifcode) {
	    		user.setEnabled(true);
	    		saveUser(user);
	    		return user;
	    	}else {
	    		return null;
	    	}
	    }*/
	@Override
	public User saveUser(User user) {
		/*Random rand = new Random();
        String code = String.format("%06d", rand.nextInt(1000000));
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setFrom(from);
	        msg.setTo(user.getEmail());
	        msg.setSubject("your code of the authentication is :");
	        

	        msg.setText(     "Dear " + user.getUsername() + "," +
	                "\n\n" +
	                "Welcome , This is your code: " +
	                "\n\n" + code +
	                "\n\n");
	        //msg.setText(code);
	        mailSender.send(msg);
	      

	        user.setEmail(user.getEmail());
	        user.setCode(code);

	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	return userRep.save(user);*/
		/*String code = generateCode();
        sendCodeByEmail(user.getEmail(), code);

        // Enregistrez le code généré dans l'utilisateur
        user.setCode(code);*/
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRep.save(user);
	}
	@Override
	public User addRoleToUser(String username, String rolename) {
	User usr = userRep.findByUsername(username);
	Role r = roleRep.findByRole(rolename);
	usr.getRoles().add(r);
	return usr;
	}
	@Override
	public Role addRole(Role role) {
	return roleRep.save(role);
	}
	@Override
	public User findUserByUsername(String username) {
	return userRep.findByUsername(username);
	}
	@Override
	public List<User> findAllUsers() {
		
		return userRep.findAll();
	}
	@Override
	public User updateUser(User user) {
		
		return userRep.save(user) ;
	}
	@Override
	public User getUserbyId(Long id) {
		
		return userRep.findById(id).get();
	}
	@Override
	public void deleteUserbyId(Long id) {
		
		 userRep.deleteById(id);
	}
	@Override
	public Role updateRole(Role role) {
		
		return roleRep.save(role);
	}
	@Override
	public void deleteRolebyId(Long id) {
		roleRep.deleteById(id);
		
	}
	@Override
	public Role getRolebyId(Long id) {
	
		return roleRep.findById(id).get();
	}
	@Override
	public List<Role> findAllRoles() {
		
		return roleRep.findAll();
	}
	@Override
    public User findUserByEmail(String email) {
        return userRep.findByEmail(email);
    }
	
	

}
