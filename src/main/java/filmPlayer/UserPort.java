package filmPlayer;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public interface UserPort {

    /**
     * 用户登录使用
     * @param code
     * @return
     */
    @RequestMapping("login/{code}")
    public Map<String,Object> login(String code);

    /**{需要登陆}
     * 退出登录
     * @return
     */
    @RequestMapping("exit")
    public Map<String,Object> exit();

    /**{需要登陆}
     * 查询个人信息
     * 参数：userId:用户的id
     *
     * 返回：此用户的所有信息
     */
    @RequestMapping("getUserInfo/{userId}")
    public Map<String,Object> getUserInfo(int userId);

    /**{需要登陆}
     * 修改个人信息
     * 参数：gender:性别
     *       qq:
     *       phone:电话
     *
     * 返回：此用户的所有信息（调用getUserInfo(userId)）
     */
    @RequestMapping("changeUserInfo/{gender}/{qq}/{phone}")
    public Map<String,Object> changeUserInfo(String gender,String qq,String phone);



}


