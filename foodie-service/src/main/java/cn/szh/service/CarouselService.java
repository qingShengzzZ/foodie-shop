package cn.szh.service;

import cn.szh.pojo.Carousel;

import java.util.List;

public interface CarouselService {
    List<Carousel> queryAll(Integer isShow);
}
