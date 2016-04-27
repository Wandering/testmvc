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

    List<Map<String,Object>> carQueryPage(@Param("orderBy")String orderBy,@Param("sortBy")String sortBy,@Param("offset")String offset,@Param("rows")String rows, @Param("mymap")Map<String,Object> queryparam);
    Integer carQueryCount();
    Map<String,Object> carQueryById(Object id);

    List<Map<String,Object>> buyQueryPage(@Param("orderBy")String orderBy,@Param("sortBy")String sortBy,@Param("offset")String offset,@Param("rows")String rows);
    Integer buyQueryCount();
    Map<String,Object> buyQueryById(Object id);

    boolean addBuy(Map<String,Object> map);
    boolean addNew(Map<String,Object> map);
    boolean addCar(Map<String,Object> map);

    boolean updateBuy(Map<String,Object> map);
    boolean updateNew(Map<String,Object> map);
    boolean updateCar(Map<String,Object> map);

    boolean deleteBuy(Object id);
    boolean deleteNew(Object id);
    boolean deleteCar(Object id);

    boolean login(Map<String,Object> map);

}
