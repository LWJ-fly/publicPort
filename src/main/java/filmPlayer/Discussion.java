package filmPlayer;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public interface Discussion {

    /**
     * 评论数增加
     * 参数：dissionId: 讨论贴id
     *
     * 注意：此方法作用 评论个数+1，只在你后台调用
     */
    @RequestMapping("addDiscussionCount/{dissionId}")
    public Map<String,Object> addDiscussionCount(int dissionId);


    /**
     *查看所有讨论帖
     * 参数：无
     *
     * 返回：所有讨论贴信息
     */
    @RequestMapping("getDiscussion")
    public Map<String,Object> getDiscussion();




    /**
     *增加讨论帖 （唯一键dissionId）后台生成
     * 参数：dission:讨论贴对象/或者采用你那种每个字段都拼在地址后面那种
     *
     * 返回：所有讨论贴信息（调用getDiscussion()）
     */
    @RequestMapping("addDiscussion/{dission}")
    public Map<String,Object> addDiscussion(String dission);




    /**
     *删除讨论帖
     * 参数：dissionId:讨论贴id
     *
     * 返回：所有讨论贴信息（调用getDiscussion()）
     */
    @RequestMapping("deleteDiscussion/{dissionId}")
    public Map<String,Object> deleteDiscussion(int dissionId);




    /**
     *查看某一个讨论id下的所有回复
     * 参数：discussionId:讨论贴id
     *
     * 注意：这里的意思是我需要你返回一个讨论下的所有回复
     *
     * 返回：返回此讨论贴的所有用户评论
     */
    @RequestMapping("getDiscussionInfo/{discussionId}")
    public Map<String,Object> getDiscussionInfo(int discussionId);




    /**
     *增加某一个讨论贴的回复 (唯一键itemId)后台生成
     * 参数：discussionId: 讨论贴id  【【【不需要，中包含的有】】】
     *     discussionInfo: discussionInfo对象/或者采用你那种每个字段都拼在地址后面那种
     *
     * 返回：返回此id讨论贴的所有回复（调用getDiscussionInfo(discussionId)，同时调用评论增加addDiscussionCount(dissionId)）
     */
    @RequestMapping("addDiscussionInfo/{discussionitem}")
    public Map<String,Object> addDiscussionInfo(Discussionitem discussionitem);





    /**
     *删除某一个讨论贴的回复
     * 参数：dissionId:讨论贴id
     *     discussionId: 讨论贴中某个回复的id【【【【只用给我讨论帖的id 即可，后续的我都能获取到】】】】
     *
     * 返回：返回此id讨论贴的所有回复（调用getDiscussionInfo(dissionId)）
     */
    @RequestMapping("deleteDiscussionInfo/{discussionitemId}")
    public Map<String,Object> deleteDiscussionInfo(int dissionId ,int discussionId);



}