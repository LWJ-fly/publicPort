package carPort;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: 狼芒
 * @Date: 2021/3/1 22:31
 * @Descrintion: 用户的相应接口调用
 * @version: 1.0
 */
public interface User {

    /**
     * 用户登录使用
     * @param session
     * @param code
     * @return
     */
    @RequestMapping("login/{code}")
    public Map<String,Object> login(String code);

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("exit")
    public Map<String,Object> exit();

    /**
     * 设置用户信息
     * 没有可为 null
     *      例如：updateUserInfo/null/null/null/212***121
     */
    @RequestMapping("updateUserInfo/{phone}/{email}/{WeChat}/{QQNum}")
    public Map<String,Object> updateUserInfo();


    /**
     * 查询所有的拼车信息，只返回条数后台进行设置
     * @return
     */
    @RequestMapping("findAllCarPooling")
    public Map<String,Object> findAllCarPooling();

    /**
     * 通过出发地搜索拼车信息
     * @return
     */
    @RequestMapping("findCarPoolingByOrigin/{origin}")
    public Map<String,Object> findCarPoolingByOrigin();

    /**
     * 通过目的地搜索拼车信息
     * @return
     */
    @RequestMapping("findCarPoolingByBourn/{bourn}")
    public Map<String,Object> findCarPoolingByBourn();

    /**
     * 通过出发地和目的地搜索拼车信息
     * @return
     */
    @RequestMapping("findCarPoolingByTrip/{origin}/{bourn}")
    public Map<String,Object> findCarPoolingByTrip();

}
