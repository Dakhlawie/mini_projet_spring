package com.meriem.demo.services;


import java.util.List;

import com.meriem.demo.entities.Role;


import com.meriem.demo.entities.User;

public interface UserService {
	User saveUser(User user);
	User updateUser(User user);
	void deleteUserbyId(Long id);
	User findUserByUsername (String username);
	Role addRole(Role role);
	Role updateRole(Role role);
	void deleteRolebyId(Long id);
	User addRoleToUser(String username, String rolename);
	List<User> findAllUsers();
	List<Role> findAllRoles();
	User getUserbyId(Long id);
	Role getRolebyId(Long id);
	User findUserByEmail(String email);
	String  generateCode() ;
	String sendCodeByEmail(String email);
	/*User verifyCode(String email,String verifcode);*/
     
    
	  /*User activateUser(String username , String code);*/
}
