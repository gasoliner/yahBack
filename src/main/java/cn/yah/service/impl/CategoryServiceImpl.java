package cn.yah.service.impl;

import cn.yah.mapper.CategoryMapper;
import cn.yah.po.Page;
import cn.yah.po.Category;
import cn.yah.po.CategoryExample;
import cn.yah.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryMapper categoryMapper;


    long total = 0L;

    @Override
    public List<Category> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Category> list = categoryMapper.selectByExample(new CategoryExample());
        PageInfo<Category> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
    
}
