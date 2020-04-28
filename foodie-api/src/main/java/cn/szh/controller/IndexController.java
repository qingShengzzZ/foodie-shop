package cn.szh.controller;


import cn.szh.enums.YesOrNo;
import cn.szh.pojo.Carousel;
import cn.szh.pojo.Category;
import cn.szh.pojo.Users;
import cn.szh.pojo.bo.UserBO;
import cn.szh.pojo.vo.CategoryVO;
import cn.szh.pojo.vo.NewItemsVO;
import cn.szh.service.CarouselService;
import cn.szh.service.CategoryService;
import cn.szh.service.UserService;
import cn.szh.utils.CookieUtils;
import cn.szh.utils.IMOOCJSONResult;
import cn.szh.utils.JsonUtils;
import cn.szh.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(value = "首页展示",tags = {"用于首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图列表",notes = "获取首页轮播图列表",httpMethod = "GET")
    @GetMapping("/carousel")
    public IMOOCJSONResult carousel(){
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        return IMOOCJSONResult.ok(list);

    }

    @ApiOperation(value = "获取一级目录",notes = "获取一级目录",httpMethod = "GET")
    @GetMapping("/cats")
    public IMOOCJSONResult cats(){
        List<Category> list = categoryService.queryAllRootLevelCat();
        return IMOOCJSONResult.ok(list);

    }

    @ApiOperation(value = "获取商品子分类" , notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public IMOOCJSONResult subCat(
            @ApiParam(name = "rootCatId", value = "一级分类id",required = true)
            @PathVariable Integer rootCatId) {

        if (rootCatId == null) {
            return IMOOCJSONResult.errorMsg("分类不存在");
        }
        List<CategoryVO> list = categoryService.getSubCatList(rootCatId);
//        System.out.println(list.toString());
        return IMOOCJSONResult.ok(list);
    }
    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据" , notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}" )
    public IMOOCJSONResult sixNewItems(
            @ApiParam(name = "rootCatId" , value = "一级分类ID", required = true)
            @PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            return IMOOCJSONResult.errorMsg("分类不存在");
        }
        List<NewItemsVO> list = categoryService.getSixNewItemsLazy(rootCatId);
        return IMOOCJSONResult.ok(list);

    }

}
