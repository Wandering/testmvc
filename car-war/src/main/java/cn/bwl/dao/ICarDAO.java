package cn.bwl.dao;

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
}
