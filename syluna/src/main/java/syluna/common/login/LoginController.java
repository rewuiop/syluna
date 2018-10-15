package syluna.common.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common/login/*")
public class LoginController {

    @RequestMapping("openLogin.do")
    public String openLogin() throws Exception {
        
        return "common/login/openLogin";
    }
    
    
}
