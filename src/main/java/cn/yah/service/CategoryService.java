package cn.yah.service;

import cn.yah.po.Page;
import cn.yah.po.Category;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface CategoryService {
    List<Category> list(Page page);

    int insert(Category record);

    int delete(Integer id);

    int update(Category record);

    long count();

    Category selectByPrimaryKey(Integer id);

}
