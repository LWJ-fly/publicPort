package carPort;

import Nouse.Uinfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public interface UInfoController {

    /**
     * 设置用户信息
     * 没有可为 null
     *      例如：updateUserInfo/null/null/null/212***121
     */
    @RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
    public Map<String,Object> updateUserInfo(HttpSession httpSession, Uinfo uinfo);

    /**
     * 获取用户信息
     * @param session
     * @return
     */
    @RequestMapping(value = "getUserInfo")
    public Map<String,Object> getLoginInfo(HttpSession session);

}
