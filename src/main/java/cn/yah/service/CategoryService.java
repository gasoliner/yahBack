package cn.yah.service;

import cn.yah.po.Page;
import cn.yah.po.Category;

import java.util.List;


public interface CategoryService {
    List<Category> list(Page page);

    int insert(Category record);

    int delete(Integer id);

    int update(Category record);

    long count();

    Category selectByPrimaryKey(Integer id);

}
