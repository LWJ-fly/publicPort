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
     * 发送意见邮件
     * @param title 发送的标题
     * @param content 发送的内容
     * @return 返回发送状态
     */
    @RequestMapping("sendEmail/{title}/{content}")
    public Map<String,Object> sendEmail(String title , String content);



    /**
     * 用户登录使用
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
     * @return 返回更新后的用户信息
     */
    @RequestMapping("updateUserInfo/{phone}/{email}/{WeChat}/{QQNum}")
    public Map<String,Object> updateUserInfo();


    /**
     * 查询所有的拼车信息，只返回条数后台进行设置————不需要登录
     * @return
     */
    @RequestMapping("findAllCarPooling")
    public Map<String,Object> findAllCarPooling();

    /**
     * 通过出发地搜索拼车信息————不需要登录
     *                                  【精确查询】
     * @return
     */
    @RequestMapping("findCarPoolingByOrigin/{origin}")
    public Map<String,Object> findCarPoolingByOrigin();

    /**
     * 通过出发地搜索拼车信息————不需要登录
     *                                  【模糊查询】
     * @return
     */
    @RequestMapping("findCarPoolingByLikeOrigin/{origin}")
    public Map<String,Object> findCarPoolingByLikeOrigin();

    /**
     * 通过目的地搜索拼车信息————不需要登录
     *                                  【精确查询】
     * @return
     */
    @RequestMapping("findCarPoolingByBourn/{bourn}")
    public Map<String,Object> findCarPoolingByBourn();

    /**
     * 通过目的地搜索拼车信息————不需要登录
     *                                  【模糊查询】
     * @return
     */
    @RequestMapping("findCarPoolingByLikeBourn/{bourn}")
    public Map<String,Object> findCarPoolingByLikeBourn();

    /**
     * 通过出发地和目的地搜索拼车信息————不需要登录
     *                                  【精确查询】
     * @return
     */
    @RequestMapping("findCarPoolingByTrip/{origin}/{bourn}")
    public Map<String,Object> findCarPoolingByTrip();


    /**
     * 通过出发地和目的地搜索拼车信息————不需要登录
     *                                  【模糊查询】
     * @return
     */
    @RequestMapping("findCarPoolingByLikeTrip/{origin}/{bourn}")
    public Map<String,Object> findCarPoolingByLikeTrip();



    /**
     * 发起拼车 填写发起拼车信息            需要登录
     * @param origin 出发地
     * @param bourn 目的地
     * @param readyTime 最早出发时间
     * @param GoTime    最晚出发时间
     * @param totalNum  拼车总人数
     * @param getNum    需要拼车的人数
     * @param inCarMsg  车主在拼车中的留言——为空则为null
     * @param QQNum     QQ号——为空则为null
     * @param WXNum     微信号——为空则为null
     * @param phoneNum  手机号——为空则为null
     * @param email 拼车结果通知邮箱——为空则为null
     * @return 返回拼车状态
     */
    @RequestMapping("createCarPooling/{origin}/{bourn}/{readyTime}/{GoTime}/{totalNum}/{getNum}/{inCarMsg}/{QQNum}/{WXNum}/{phoneNum}/{email}")
    public Map<String,Object> createCarPooling(String origin,String bourn,String readyTime,String GoTime,String totalNum,String getNum,String inCarMsg,String QQNum,String WXNum,String phoneNum,String email);




    /**
     * 加入拼车 填写加入拼车的信息
     * @param inCarMsg  在拼车中的留言——为空则为null
     * @param QQNum     QQ号——为空则为null
     * @param WXNum     微信号——为空则为null
     * @param phoneNum  手机号——为空则为null
     * @param email 拼车结果通知邮箱——为空则为null
     * @return 返回拼车状态
     */
    @RequestMapping("joinCarPooling/{carId}/{inCarMsg}/{QQNum}/{WXNum}/{phoneNum}/{email}")
    public Map<String,Object> joinCarPooling(String carId,String inCarMsg,String QQNum,String WXNum,String phoneNum,String email);

    /**
     * 查看我的拼车信息——未完结的，当前还在拼车的信息
     * @return
     */
    @RequestMapping("findMyCarPooling")
    public Map<String,Object> findMyCarPooling();

    /**
     * 查看我的全部的拼车信息
     * @return
     */
    @RequestMapping("findMyAllCarPooling")
    public Map<String,Object> findMyAllCarPooling();


    /**
     * 查看详细拼车信息
     *      ————如果没有加入拼车，相应信息会进行保密处理
     *      ————如果加入拼车，相应信息会进行展示
     * @param carId
     * @return
     */
     @RequestMapping("findDetailCarPooling/{carId}")
    public Map<String,Object> findMyDetailCarPooling(String carId);


    /**
     * 查看所有历史拼车信息
     * @return
     */
    @RequestMapping("findHistoryCarPooling")
    public Map<String,Object> findHistoryCarPooling();

    /**
     * 退出拼车
     * @param carId
     * @return
     */
    @RequestMapping("quitCarPooling/{carId}")
    public Map<String,Object> quitCarPooling(String carId);








}
