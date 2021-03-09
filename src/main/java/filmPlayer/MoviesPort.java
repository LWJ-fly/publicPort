package filmPlayer;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

public interface MoviesPort {


    /**
     *查询所有电影
     * 参数：无
     *
     * 返回：电影所有信息
     */
    @RequestMapping("findAllMovies")
    public Map<String,Object> findAllMovies();

    /**
     *查询电影（按名称模糊查询）
     * 参数：name：电影名（模糊查询）
     *
     * 返回：相关名称的电影的所有信息
     */
    @RequestMapping("findMoviesById/{name}")
    public Map<String,Object> findMoviesById(String name);

    /**
     *查询电影详细信息
     * 参数：movieId：电影id
     *
     * 返回：对应movieId的电影信息
     */
    @RequestMapping("findMovieInfo/{movieId}")
    public Map<String,Object> findMovieInfo(int movieId);

    /**
     *添加电影(唯一键movieId)后台生成
     * 参数：movies:电影对象/或者采用你那种每个字段都拼在地址后面那种
     *
     * 返回：返回所有电影信息（调用findAllMovies()）
     */
    @RequestMapping("addMovie/{movies}")
    public Map<String,Object> addMovie(Movies movies);

    /**
     *删除电影
     * 参数：movieId:电影id
     *
     * 返回：返回所有电影信息（调用findAllMovies()）
     */
    @RequestMapping("deleteMovie/{movieId}")
    public Map<String,Object> getrUserInfo(int movieId);

    /**
     *电影评论数增加
     * 参数：movieId: 电影id
     *
     * 注意：此方法作用 评论个数+1，只在你后台调用
     */
    @RequestMapping("addMovieCommentCount/{movieId}")
    public Map<String,Object> addMovieCommentCount(int movieId);


    /**
     *查询电影评论
     * 参数：movieId: 电影id
     *
     * 返回：当前电影所有评论
     */
    @RequestMapping("getMovieComment/{movieId}")
    public Map<String,Object> getMovieComment(int movieId);


    /**
     *创建电影评论
     * 参数：movieId: 电影id（用于返回时查询电影评论的参数）
     *     comments: comments对象/或者采用你那种每个字段都拼在地址后面那种
     *
     * 返回：当前电影所有评论（调用getMovieComment(movieId)，同时调用评论数增加的方法addMovieCommentCount(movieId)）
     */
    @RequestMapping("addMovieComment/{movieId}/{comments}")
    public Map<String,Object> addMovieComment(int movieId,Comments comments);



    /**
     *修改评论点赞数量
     * 参数：commentsId:评论自身的id（唯一键那个，用来找到这个评论）
     *     stars:点赞个数
     *
     * 注意：你需要做的是把传过来stars直接覆盖原来的数据就行
     *
     * 返回：不用返回任何东西
     */
    @RequestMapping("addStars/{commentsId}/{stars}")
    public Map<String,Object> addStars(int commentsId,int stars);



    /**
     *删除电影评论
     * 参数：movieId:电影id(用于返回该电影的所有评论)
     *     commentsId:评论id（用于删除评论时后台查询使用）
     *
     * 返回：返回当前电影所有评论（调用getMovieComment(movieId)）
     */
    @RequestMapping("deleteMovieComment/{movieId}/{commentsId}")
    public Map<String,Object> deleteMovieComment(int movieId,int commentsId);
    



}
