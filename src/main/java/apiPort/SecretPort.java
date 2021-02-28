package apiPort;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

/**
 * @Auther: 狼芒
 * @Date: 2021/2/21 21:23
 * @Descrintion: 密钥接口，相关密钥调用在这里查询
 * @version: 1.0
 */
@Controller
public interface SecretPort {

    /**
     * @param secret 给网站的授权
     * @return 返回登录用户的所有权限(应用)信息
     *          qq\alipay。。。
     */
    @RequestMapping("getPermissionInfos/{secret}")
    public Map<String,Object> getPermissionInfos();

    /**
     * @param secret 给网站的授权
     * @return 返回用户历史(失效)的所有权限(应用)信息
     */
    @RequestMapping("getPermissionHistoryInfos/{secret}")
    public Map<String,Object> getPermissionHistoryInfos();

    /**
     * 注意：需要设置IP白名单的用户才能调用
     * @return 返回用户申请的密钥
     */
    @RequestMapping("getSecret")
    public Map<String,Object> getSecret();


    /**
     * @param secret 给网站的授权
     * @param cancelSecret 撤销用户的密钥
     * @return 用户当前所有的权限，相当于调用 getPermissionInfos
     */
    @RequestMapping("concelPermission/{secret}/{cancelSecret}")
    public Map<String,Object> concelPermission();

    /**
     * @param secret 给网站的授权
     * @param permission 用户申请的权限 qq、Alipay中一个
     * @param ip  用户的ip白名单--有的话是30天有效期，没有的话是1天有效期
     * @return 用户当前所有的权限，相当于调用 getPermissionInfos
     */
    @RequestMapping("applyPermission/{secret}/{permission}/{ip}")
    public Map<String,Object> applyPermissionAndIp();
}
