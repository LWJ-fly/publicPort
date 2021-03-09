package filmPlayer;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public interface SpellGroupPort {

    /**
     * 查看所有团约
     * 参数：无
     *
     * 返回：所有团约的信息
     */
    @RequestMapping("getSpellGroup")
    public Map<String,Object> getSpellGroup();


    /**
     *增加团约 (唯一键spellGroupsId)后台生成
     * 参数：spellGroups:spellGroups对象/或者采用你那种每个字段都拼在地址后面那种
     *
     * 返回：所有团约的信息（调用getSpellGroups()）
     */
    @RequestMapping("addSpellGroup/{spellGroup}")
    public Map<String,Object> addSpellGroup(SpellGroup spellGroup);

    /**
     *删除团约
     * 参数：spellGroupId:团约id
     *
     * 返回：所有团约的信息（调用getSpellGroups()）
     */
    @RequestMapping("deleteSpellGroup/{spellGroupId}")
    public Map<String,Object> deleteSpellGroup(int spellGroupId);

    /**
     *查看团约详细信息
     * 参数：spellGroupId:团约id
     *
     * 返回：此id下团约的所有信息（也就是几个人  跟你的查看拼车一样）
     */
    @RequestMapping("getSpellGroupInfo/{spellGroupId}")
    public Map<String,Object> getSpellGroupInfo(int spellGroupId);

    /**
     *申请加入团约
     * 参数：spellGroupId:团约id
     *     userId:用户id
     *
     * 返回：此id下团约的所有信息（调用getSpellGroupInfo(spellGroupId)）
     */
    @RequestMapping("addSpellGroupInfo/{discussionId}/{useId}")
    public Map<String,Object> addSpellGroupInfo(int discussionId ,int useId);



}
