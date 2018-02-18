package com.tapestry5.child.pages;

import com.boot.child.dto.UserDto;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;

public class Login
{
  private final String USERS="http://localhost:9098/user/data/all";

  @Inject
  private Logger logger;

  @Inject
  private AlertManager alertManager;

  @InjectComponent
  private Form login;
  
  @InjectComponent("firstName")
  private TextField firstNameField;
  
  @InjectComponent("lastName")
  private TextField lastNameField;

  @Property
  private String firstName;

  @Property
  private String lastName;



  void onValidateFromLogin() {
    RestTemplate restTemplate = new RestTemplate();
    UserDto[] users = restTemplate.getForObject(USERS, UserDto[].class);
    int fName=0;
    int lName=0;
    for (UserDto userDto : users) {
      if (!firstName.equals(userDto.getFirstName())) {
        fName++;
      }

      if (!lastName.equals(userDto.getLastName())) {
        lName++;
      }
    }
    if(fName==users.length){
      login.recordError(firstNameField, "Try with firstName:" + firstName);
    }
    if(lName==users.length){
      login.recordError(lastNameField, "Try with lastName: " + lastName);
    }
  }

  Object onSuccessFromLogin()
  {
    logger.info("Login successful!");
    alertManager.success("Welcome aboard!");

    return ViewUsers.class;
  }

  void onFailureFromLogin()
  {
    logger.warn("Login error!");
    alertManager.error("I'm sorry but I can't log you in!");
  }

}
