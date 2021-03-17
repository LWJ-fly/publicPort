package carPort;

import Nouse.Carfriend;
import Nouse.Uinacarinfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: 狼芒
 * @Date: 2021/3/14 1:37
 * @Descrintion: 拼车管理类
 * @version: 1.0
 */

@Controller
public interface CarFriendController {

    /**
     * 发起请出队友，请出队友的ID  请出其他人，两个人的话不允许请出他人，建议自己退出
     * @param outId 被请出去人的ID
     * @param carId 此次拼车的ID
     * @return 返回
     */
    @RequestMapping("letOut/{carId}/{outId}/{leavecause}")
    public Map<String,Object> letOut(int carId,int outId,String leavecause);

    /**
     * 获取发起请出的信息
     * @param carId 拼车ID
     * @return 返回发起请出的信息
     */
    @RequestMapping("getCallOut/{carId}")
    public Map<String,Object> getCallOut(int carId);


    /**
     * 获取发起请出的所有队友决定信息，详细信息可参见查看拼车信息方法
     * @param callleaveid 发起请出他人的callleaveid，也就是此表中的ID
     * @return 返回发起请出的信息
     */
    @RequestMapping("getCallOutDec/{callleaveid}")
    public Map<String,Object> getCallOutDec(int callleaveid);

    /**
     * 处理拼车信息
     *      队友同意 、 拒绝 请出其他人，两个人的话不允许请出他人，建议自己退出
     * @param callleaveid 请出他人表中的ID
     * @param deal 处理结果，true/false
     * @return
     */
    @RequestMapping("dealCallOut/{callleaveid}/{deal}")
    public Map<String,Object> dealCallOut(int callleaveid,Boolean deal);

    /**
     * 查询所有的拼车信息，只返回条数后台进行设置
     * @return
     */
    @RequestMapping("findAllCarFriend")
    public Map<String,Object> findAllCarFriend();

    /**
     * 查询所有的拼车完成的拼车信息，只返回条数后台进行设置
     * @return
     */
    @RequestMapping("findAllOkCarFriend")
    public Map<String,Object> findAllOkCarFriend();

    /**
     * 通过出发地搜索拼车信息————精确查询
     * @return
     */
    @RequestMapping("findCarFriendByOrigin/{origin}")
    public Map<String,Object> findCarFriendByOrigin(@PathVariable("origin") String origin);
    /**
     * 通过出发地搜索拼车信息————模糊查询
     * @return
     */
    @RequestMapping("findCarFriendByLikeOrigin/{origin}")
    public Map<String,Object> findCarFriendByLikeOrigin(@PathVariable("origin") String origin);

    /**
     * 通过目的地搜索拼车信息————不需要登录
     *                                  【精确查询】
     * @return
     */
    @RequestMapping("findCarFriendByBourn/{bourn}")
    public Map<String,Object> findCarFriendByBourn(@PathVariable("bourn") String bourn);

    /**
     * 通过目的地搜索拼车信息————不需要登录
     *                                  【模糊查询】
     * @return
     */
    @RequestMapping("findCarFriendByLikeBourn/{bourn}")
    public Map<String,Object> findCarFriendByLikeBourn(@PathVariable("bourn") String bourn);


    /**
     * 通过出发地和目的地搜索拼车信息————不需要登录
     *                                  【精确查询】
     * @return
     */
    @RequestMapping("findCarFriendByTrip/{origin}/{bourn}")
    public Map<String,Object> findCarFriendByTrip(@PathVariable("origin") String origin,@PathVariable("bourn") String bourn);


    /**
     * 通过出发地和目的地搜索拼车信息————不需要登录
     *                                  【模糊查询】
     * @return
     */
    @RequestMapping("findCarFriendByLikeTrip/{origin}/{bourn}")
    public Map<String,Object> findCarFriendByLikeTrip(@PathVariable("origin") String origin,@PathVariable("bourn") String bourn);

    /**
     * 发起拼车 填写发起拼车信息
     * @return 返回拼车信息
     */
    @RequestMapping(value = "createCarFriend",method = RequestMethod.POST)
    public Map<String,Object> createCarFriend(HttpSession session, Carfriend carfriend) ;

    /**
     * 加入拼车 填写加入拼车的信息
     * @return 返回拼车状态
     */
    @RequestMapping(value = "joinCarFriend",method = RequestMethod.POST)
    public Map<String,Object> joinCarFriend(HttpSession session, Uinacarinfo uinacarinfo, Boolean listenerStatus) ;

    /**
     * 查看详细拼车信息
     *      ————如果没有加入拼车，相应信息会进行保密处理
     *      ————如果加入拼车，相应信息会进行展示
     * @param carId
     * @return
     */
    @RequestMapping("findDetailCarFriend/{carId}")
    public Map<String,Object> findMyDetailCarFriend(HttpSession session, @PathVariable("carId") int carId);

    /**
     * 退出拼车
     * @param carId
     * @return
     */
    @RequestMapping("quitCarFriend/{carId}")
    public Map<String,Object> quitCarFriend(HttpSession session,@PathVariable("carId") int carId);

}
