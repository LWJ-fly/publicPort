package filmPlayer;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public interface user {

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
     * 查询个人信息
     * 参数：userId:用户的id
     *
     * 返回：此用户的所有信息
     */
    @RequestMapping("getUserInfo/{userId}")
    public Map<String,Object> getUserInfo(int userId);

    /**
     * 修改个人信息
     * 参数：gender:性别
     *       qq:
     *       phone:电话
     *
     * 返回：此用户的所有信息（调用getUserInfo(userId)）
     */
    @RequestMapping("changeUserInfo/{gender}/{qq}/{phone}")
    public Map<String,Object> changeUserInfo(String gender,String qq,String phone);



//    ==================电影相关==================================


    /**
     *查询所有电影
     * 参数：无
     *
     * 返回：电影所有信息
     */
    @RequestMapping("findAllMoves")
    public Map<String,Object> findAllMoves();

    /**
     *查询电影（按名称模糊查询）
     * 参数：name：电影名（模糊查询）
     *
     * 返回：相关名称的电影的所有信息
     */
    @RequestMapping("findMovesById/{name}")
    public Map<String,Object> findMovesById(String name);

    /**
     *查询电影详细信息
     * 参数：moveId：电影id
     *
     * 返回：对应moveId的电影信息
     */
    @RequestMapping("findMoveInfo/{moveId}")
    public Map<String,Object> findMoveInfo(int moveId);

    /**
     *添加电影(唯一键moveId)后台生成
     * 参数：moves:电影对象/或者采用你那种每个字段都拼在地址后面那种
     *
     * 返回：返回所有电影信息（调用findAllMoves()）
     */
    @RequestMapping("addMove/{moves}")
    public Map<String,Object> addMove(moves moves);

    /**
     *
     */
    @RequestMapping("getUserInfo/{userId}")
    public Map<String,Object> getUserInfo(int userId);
}
