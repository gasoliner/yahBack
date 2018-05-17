package cn.yah.service.impl;

import cn.yah.mapper.NewsMapper;
import cn.yah.po.News;
import cn.yah.po.NewsExample;
import cn.yah.po.Page;
import cn.yah.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("newsService")
public class NewsServiceImpl implements NewsService {


    @Autowired
    NewsMapper newsMapper;


    long total = 0L;

    @Override
    public List<News> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<News> list = newsMapper.selectByExample(new NewsExample());
        PageInfo<News> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(News record) {
        return newsMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(News record) {
        return newsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public News selectByPrimaryKey(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

}
