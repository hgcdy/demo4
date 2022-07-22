package cn.netinnet.demo4.sevice.impl;

import cn.netinnet.demo4.entity.HouseEntity;
import cn.netinnet.demo4.mapper.HouseMapper;
import cn.netinnet.demo4.sevice.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<HouseEntity> getHouseAll() {
        return houseMapper.getHouseAll();
    }
}
