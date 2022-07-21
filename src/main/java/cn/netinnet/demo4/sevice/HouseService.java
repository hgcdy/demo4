package cn.netinnet.demo4.sevice;

import cn.netinnet.demo4.entity.ClassEntity;
import cn.netinnet.demo4.entity.HouseEntity;

import java.util.List;

public interface HouseService {

    //获取所有班级
    public List<HouseEntity> getHouseAll();
}
