package cn.netinnet.demo4.mapper;


import cn.netinnet.demo4.entity.HouseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HouseMapper {

    //查询所有教室
    public List<HouseEntity> getHouseAll();

    //查询指定id
    public HouseEntity getHouseId(Integer id);
}
