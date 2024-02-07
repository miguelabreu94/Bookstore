package services;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.AppUserRepository;

@Service
@AllArgsConstructor
public class AppUserService {

    private final static String USER_NOT_FOUND_msg = "user with email %s not found";

    private AppUserRepository appUserRepository;




}
