package com.meriem.demo.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meriem.demo.entities.Role;
import com.meriem.demo.entities.User;

import com.meriem.demo.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
	@Autowired
	UserService userService;
	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
	return userService.findAllUsers();
	}
	@RequestMapping(path = "allRole", method = RequestMethod.GET)
	public List<Role> getAllRoles() {
	return userService.findAllRoles();
	}
	 @GetMapping("/generate-code")
	    public String generateCode() {
	      return  userService.generateCode();
	    }

	    @PostMapping("/send-code")
	    public String sendCodeByEmail(@RequestBody String email) {
	        return userService.sendCodeByEmail(email);
	    }
	  /*  @PostMapping("/verifcode")
	    public String verifyUser(@RequestBody User user) {
	    	String mail=user.getEmail();
	    	String verifcode=user.getCode();
	    	System.out.println("user activated:"+verifcode);
	    	User user1=userService.verifyCode(mail, verifcode);
	    	if(user1!=null)
	    		return "compte verifiée";
	    	else
	    		return "compte non verifiée";
	    	
	    }*/
	@RequestMapping(path = "/adduser", method = RequestMethod.POST)
	public User createuser(@RequestBody User user) {
		
		return userService.saveUser(user);
	}
	@RequestMapping(path = "/addrole", method = RequestMethod.POST)
	public Role createrole(@RequestBody Role role) {
		return userService.addRole(role);
	}
	@RequestMapping(path = "/updateuser", method = RequestMethod.PUT)
	public User modifieruser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	@RequestMapping(path = "/updaterole", method = RequestMethod.PUT)
	public Role modifierrole(@RequestBody Role role) {
		return userService.updateRole(role);
	}
	@RequestMapping(path = "/getbyid/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") Long id) {
		return userService.getUserbyId(id);
	}
	@RequestMapping(path = "/getrolebyid/{id}", method = RequestMethod.GET)
	public Role getRoleById(@PathVariable("id") Long id) {
		return userService.getRolebyId(id);
	}
	@RequestMapping(path = "/deluser/{id}", method = RequestMethod.DELETE)
	public void supprimeruser(@PathVariable("id") Long id) {
		userService.deleteUserbyId(id);
	}
	@RequestMapping(path = "/delrole/{id}", method = RequestMethod.DELETE)
	public void supprimerrole(@PathVariable("id") Long id) {
		userService.deleteRolebyId(id);
	}
}
