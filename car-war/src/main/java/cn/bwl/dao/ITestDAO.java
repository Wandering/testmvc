package cn.bwl.dao;


import cn.bwl.domain.TestDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ITestDAO{
    List<TestDomain> queryList(@Param("condition")Map<String,Object> map);
}
