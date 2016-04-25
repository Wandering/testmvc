package cn.bwl.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/4/9.
 */
public interface ICarDAO {
    List<Map<String,Object>> bannerQueryList();
    List<Map<String,Object>> newsQueryList();
    List<Map<String,Object>> photosQueryList();
    List<Map<String,Object>> servicesQueryList();
    List<Map<String,Object>> newQueryPage(@Param("orderBy")String orderBy,@Param("sortBy")String sortBy,@Param("offset")String offset,@Param("rows")String rows);
    Integer newQueryCount();
    Map<String,Object> newQueryById(Object id);
    List<Map<String,Object>> carQueryPage(@Param("orderBy")String orderBy,@Param("sortBy")String sortBy,@Param("offset")String offset,@Param("rows")String rows);
    Integer carQueryCount();
    Map<String,Object> carQueryById(Object id);
    List<Map<String,Object>> buyQueryPage(@Param("orderBy")String orderBy,@Param("sortBy")String sortBy,@Param("offset")String offset,@Param("rows")String rows);
    Integer buyQueryCount();
    Map<String,Object> buyQueryById(Object id);
    boolean addBuy(Map<String,Object> map);
    boolean login(Map<String,Object> map);
}
