package carPort;

import Nouse.Drivercar;
import Nouse.Drivervie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 司机抢单的控制类
 */
@RestController
public interface DriverVieController {
/*
需要新增
    查询所有拼车完成的订单
    申请载客，
        相应的用户应该有
            一个查看申请载客信息
            一个用户拒绝载客信息
            一个用户同意载客信息
            //根据此订单查询所有的拼车信息
    退出载客申请
 */

    @RequestMapping("upDateDriverCar")
    public Map<String,Object> upDateDriverCar(HttpSession session, Drivercar drivercar);
    /**
     * 获取拼车司机的拼车信息
     */
    @RequestMapping("getDriverCar")
    public Map<String,Object> getDriverCar(HttpSession session);

    /**
     * 【用户使用】 查看当前拼车信息的中，司机抢单信息
     * @param session
     * @param poolingcarid 当前拼车的ID
     * @return
     */
    @RequestMapping("findPullInfo/{poolingcarid}")
    public Map<String,Object> findPullInfo(HttpSession session,Integer poolingcarid);

    /**
     * 拒绝 / 同意 司机载客的信息
     * @param vieid  抢单的ID，司机抢单后生成表中的ID
     * @param reply 答复，同意或者不同意
     * @return
     */
    @RequestMapping("dealApplyPull/{vieid}/{reply}")
    public Map<String,Object> dealApplyPull(HttpSession session,Integer vieid, Boolean reply);






    /**
     * 司机申请载客的方法
     * @param session 系统自动获取
     * @param drivervie 申请载客的，拼车的ID,司机的报价，抢单的留言，这三个，载客ID必须，另外不必
     * @return 返回申请数据
     */
    @RequestMapping("applyPull")
    public Map<String,Object> applyPull(HttpSession session, Drivervie drivervie );

    /**
     * @param session 系统自动获取
     * @param vieid 抢单的ID，司机抢单后生成表中的ID
     * @return 返回表中的变更状态
     */
    @RequestMapping("quitPull/{vieid}")
    public Map<String,Object> quitPull(HttpSession session,Integer vieid);


    /**
     * 查询所有的拉取信息
     * @param session
     * @return
     */
    @RequestMapping("findAllPull/{vieid}")
    public Map<String,Object> findAllPull(HttpSession session);

    /**
     * 当前申请的载客信息
     * @param session
     * @return
     */
    @RequestMapping("findApplyPull/{vieid}")
    public Map<String,Object> findApplyPull(HttpSession session);


    /**
     * 查看同意的载客信息
     * @param session
     * @return
     */
    @RequestMapping("findAgreePull/{vieid}")
    public Map<String,Object> findAgreePull(HttpSession session);


    /**
     * 查看不同意的载客信息
     * @param session
     * @return
     */
    @RequestMapping("findFilePull/{vieid}")
    public Map<String,Object> findFilePull(HttpSession session);



}
