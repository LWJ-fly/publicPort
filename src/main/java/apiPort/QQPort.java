package apiPort;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Auther: 狼芒
 * @Date: 2021/2/21 21:18
 * @Descrintion: QQ的调用接口，关于QQ的调用类在这里找
 * @version: 1.0
 */

@Controller
public interface QQPort {

    /**
     * @param code 用户的授权码
     * @return 自己网站用户登录、进行判断 String login(失败) / index（成功）
     */
    @RequestMapping("/QQLogin/{code}")
    public Map<String,Object> QQLogin();

    /**
     * @Mehthod 获取用户登录信息——QQ相关信息
     * @param secret 给网站的授权
     * @return 返回用户登录信息
     */
    @RequestMapping("getUserInfo/{secret}")
    public Map<String,Object> getLoginInfo();

    /**
     * @Method 退出登录
     */
    @RequestMapping("exit")
    public Map<String,Object> exit();

    /**
     * 使用发出去的密钥，以及code换取用户信息
     * @param secret 分发出去的密钥
     * @param code 用户登录时QQ官网发出的登录令牌
     * @return 以Json串的形式返回用户的简略信息
     */
    @RequestMapping("/changeUserInfo/{secret}/{code}")
    public Map<String, Object> changeUserInfoBySecret(@PathVariable("secret") String secret,@PathVariable("code") String code);
}
