package cn.szh.service;


import cn.szh.pojo.Category;
import cn.szh.pojo.vo.CategoryVO;
import cn.szh.pojo.vo.NewItemsVO;

import java.util.List;

public interface CategoryService {

    /**查询所有分类
     * @return
     */
    List<Category> queryAllRootLevelCat();

    List<CategoryVO> getSubCatList(Integer rootCatId);

    List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);

}
