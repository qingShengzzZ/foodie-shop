package cn.szh.service.impl;

import cn.szh.mapper.CarouselMapper;
import cn.szh.pojo.Carousel;
import cn.szh.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    /**查询所有轮播图
     * @param isShow
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Carousel> queryAll(Integer isShow) {

        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("isShow",isShow);

        List<Carousel> carousels = carouselMapper.selectByExample(example);

        return carousels;
    }
}
