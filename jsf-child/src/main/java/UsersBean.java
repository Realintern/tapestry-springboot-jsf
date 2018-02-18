import com.boot.child.dto.UserDto;
import org.springframework.web.client.RestTemplate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manukg on 9/19/2016.
 */
@ManagedBean
@SessionScoped
public class UsersBean {

    private static final String GET_USERDTO_BY_ID = "http://localhost:9098/user/data/";
    private final String USERS="http://localhost:9098/user/data/all";

    private final String DELETE_USERS="http://localhost:9098/user/data/delete/";


    private List<UserDto> userDtos;

    private List<UserDto> fillAllUserDtosList(){
        RestTemplate restTemplate=new RestTemplate();
        UserDto[] forObject = restTemplate.getForObject(USERS, UserDto[].class);
        return Arrays.asList(forObject);
    }

    public String deleteUser(Long userId){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.delete(DELETE_USERS+userId);
        return "viewUsers";

    }

    public List<UserDto> getUserDtos() {
        return fillAllUserDtosList();
    }

    public void setUserDtos(List<UserDto> userDtos) {
        this.userDtos = userDtos;
    }

    public String editAction(UserDto userDto){
        userDto.setEditable(true);
        return null;
    }

    public void saveAction(){


    }




}
