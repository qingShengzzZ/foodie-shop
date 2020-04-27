package cn.szh.mapper;
import	java.util.Map;

import cn.szh.pojo.vo.ItemCommentVO;
import cn.szh.pojo.vo.SearchItemsVO;
import cn.szh.pojo.vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemsMapperCustom {
    public List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);
    public List<SearchItemsVO> searchItems(@Param("paramsMap") Map<String, Object> map);
    public List<SearchItemsVO> searchItemsByThirdCat(@Param("paramsMap") Map<String, Object> map);
    public List<ShopcartVO> queryItemsBySpecIds(@Param("paramsList") List specIdsList);
    public int decreaseItemSpecStock(@Param("specId") String specId,
                                     @Param("pendingCounts") int pendingCounts);
}
