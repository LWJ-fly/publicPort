package apiPort;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Auther: 狼芒
 * @Date: 2021/2/21 21:58
 * @Descrintion: 用户信息类，用户信息的相关接口
 * @version: 1.0
 */
@Controller
public interface UserPort {


    /**
     * @Method 获取当前登录的基本信息——手机号，邮箱等
     * @param secret 给网站的授权
     * @return 返回我的基本信息
     */
    @RequestMapping("getBaseInfo/{secret}")
    public Map<String,Object> getBaseInfo();

    /**
     * @Method 设置邮箱手机号
     * @param email 邮箱账号
     * @param secret 给网站的授权
     * @param phone 手机号
     * @return 返回设置后的用户信息
     */
    @RequestMapping("setEmailOrPhone2BaseInfo/{secret}/{email}/{phone}")
    public Map<String,Object> setEmailOrPhone2BaseInfo();

}
