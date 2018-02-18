import com.boot.child.dto.UserDto;
import org.springframework.web.client.RestTemplate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by manukg on 9/19/2016.
 */
@ManagedBean
@SessionScoped
public class AddUsersBean {

    private final String ADD_USER = "http://localhost:9098/user/data";

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private UserDto userDto;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }


    public String addNewUsers() {
        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = new UserDto();
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        restTemplate.postForObject(ADD_USER, userDto, UserDto.class);
        return "viewUsers";
    }
}
