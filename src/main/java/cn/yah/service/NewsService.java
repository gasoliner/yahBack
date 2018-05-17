package cn.yah.service;

import cn.yah.po.News;
import cn.yah.po.Page;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface NewsService {
    List<News> list(Page page);

    int insert(News record);

    int delete(Integer id);

    int update(News record);

    long count();

    News selectByPrimaryKey(Integer id);

}
