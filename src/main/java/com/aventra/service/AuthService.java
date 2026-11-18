package com.aventra.service;
import com.aventra.exception.*; import com.aventra.model.User; import com.aventra.repository.UserRepository; import java.sql.SQLException;
public class AuthService {
 private final UserRepository users; public AuthService(UserRepository users){this.users=users;}
 public User login(String email,String password)throws AuthenticationException,DatabaseException{
  try{User user=users.findByEmail(email.trim().toLowerCase());if(user==null||!PasswordUtil.matches(password,user.getPasswordHash()))throw new AuthenticationException("Email or password is incorrect.");return user;}
  catch(SQLException e){throw new DatabaseException("Could not access account data. Check your database connection.",e);}
 }
 public User register(String name,String email,String password,String phone)throws ValidationException,DatabaseException{
  if(name==null||name.isBlank()||email==null||!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")||password==null||password.length()<6)throw new ValidationException("Enter a name, valid email and password of at least 6 characters.");
  try{String normalized=email.trim().toLowerCase();if(users.findByEmail(normalized)!=null)throw new ValidationException("An account with this email already exists.");return users.create(name.trim(),normalized,PasswordUtil.hash(password),phone==null?"":phone.trim());}
  catch(SQLException e){throw new DatabaseException("Could not create account. Check your database connection.",e);}
 }
}
