package apiPort;

import java.util.Map;

/**
 * @Auther: 狼芒
 * @Date: 2021/2/21 21:18
 * @Descrintion: QQ的调用接口，关于QQ的调用类在这里找
 * @version: 1.0
 */

@Consoller
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
    @RequestMapping("getLoginInfo/{secret}")
    public Map<String,Object> getLoginInfo();

    /**
     * @Method 退出登录
     * @param session 服务器给每个用户分配的session对象、返回 login
     */
    @RequestMapping("exit")
    public Map<String,Object> exit();

    /**
     * @Method 获取当前登录的基本信息——手机号，邮箱等
     * @param secret 给网站的授权
     * @return 返回我的基本信息
     */
    @RequestMapping("getBaseInfo/{secret}")

    /**
     * @Method 设置邮箱手机号
     * @param email 邮箱账号
     * @param secret 给网站的授权
     * @param phone 手机号
     * @return 返回设置后的用户信息
     */
    @RequestMapping("setEmailOrPhone2BaseInfo/{secret}/{email}/{phone}")

    /**
     * @param secret 手机号
     * @return 返回用户的所有权限(应用)信息
     *          qq\alipay。。。
     */
    @RequestMapping("getPermissionInfos/{secret}")
    public Map<String,Object> getPermissionInfos();

    /**
     * @Mehthod 其他网站可以调用，返回用户信息
     * @param code 用户的授权码
     * @param secret 给网站的授权
     * @return 返回用户登录基本信息
     */
    @RequestMapping("getLoginInfo/{code}/{secret}")
    public Map<String,Object> getUserInfo();


}
