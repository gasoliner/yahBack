package cn.yah.service;

import cn.yah.po.News;
import cn.yah.po.Page;

import java.util.List;


public interface NewsService {
    List<News> list(Page page);

    int insert(News record);

    int delete(Integer id);

    int update(News record);

    long count();

    News selectByPrimaryKey(Integer id);

}
