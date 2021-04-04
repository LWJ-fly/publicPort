package carPort;

import Nouse.Carfriend;
import Nouse.Drivercar;
import Nouse.Uinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: 狼芒
 * @Date: 2021/4/3 23:09
 * @Descrintion: 管理员方法
 *                  管理员方法使用adminXXX方法命名，进行拦截验证
 * @version: 1.0
 */
@RestController
public interface AdminController {

//==========车主信息维护============

    /**
     * 管理员查看所有司机信息
     */
    @RequestMapping("findAllDriver")
    public Map<String, Object> adminFindAllDriver(HttpSession session);

    /**
     * 修改司机、用户 信息
     */
    @RequestMapping("updateUserInfo")
    public Map<String, Object> adminUpdateUserInfo(HttpSession session, Uinfo uinfo);


    /**
     * 查看司机车辆信息0
     * @param driverId 司机的id
     * @return
     */
    @RequestMapping("findDriverCar/{driverId")
    public Map<String, Object> adminFindDriverCar(HttpSession session, @PathVariable("driverId") int driverId);


    /**
     * 修改司机车辆信息
     * @param drivercar 司机车辆的全部信息，ID不能改其他都可以
     * @return
     */
    @RequestMapping("updateDriverCar")
    public Map<String, Object> adminUpdateDriverCar(HttpSession session, Drivercar drivercar);


    //===============司机抢单信息====================

    /**
     * 查看司机抢单信息
     * @param driverId 司机的id
     * @return
     */
    @RequestMapping("findDriverVie/{driverId")
    public Map<String, Object> adminFindDriverVie(HttpSession session, @PathVariable("driverId") int driverId);


    /**
     * 终止司机抢单
     * @param vieid 抢单的id
     * @return
     */
    @RequestMapping("endDriverVie/{vieid")
    public Map<String, Object> adminEndDriverVie(HttpSession session, @PathVariable("vieid") int vieid);


    //==============用户信息维护======================

    /**
     * 查看所有用户信息
     */
    @RequestMapping("findAllUser")
    public Map<String, Object> adminFindAllUser(HttpSession session);


    /**
     * 禁用用户
     * @param userid 用户的id
     * @return
     */
    @RequestMapping("disableUser/{userid")
    public Map<String, Object> adminDisableUser(HttpSession session, @PathVariable("userid") int userid);


    /**
     * 查看所有被封禁的用户
     */
    @RequestMapping("findAllDisableUser")
    public Map<String, Object> adminFindAllDisableUser(HttpSession session);


    /**
     * 解封用户
     * @param userid 用户的id
     * @return
     */
    @RequestMapping("ableUser/{userid")
    public Map<String, Object> adminAbleUser(HttpSession session, @PathVariable("userid") int userid);


    //================拼车信息维护==========================

    /**
     * 查看拼车详细信息
     * @param poolingcarid 拼车的id
     * @return
     */
    @RequestMapping("carfriendInfo/{poolingcarid")
    public Map<String, Object> adminCarfriendInfo(HttpSession session, @PathVariable("poolingcarid") int poolingcarid);


    /**
     * 更改拼车信息
     * @param carfriend 拼车的详细信息，id不能改其他都可以
     * @return
     */
    @RequestMapping("updateCarfriendInfo")
    public Map<String, Object> adminUpdateCarfriendInfo(HttpSession session, Carfriend carfriend);


}

