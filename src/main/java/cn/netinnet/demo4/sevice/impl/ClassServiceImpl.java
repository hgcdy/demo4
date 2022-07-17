package cn.netinnet.demo4.sevice.impl;

import cn.netinnet.demo4.entity.ClassEntity;
import cn.netinnet.demo4.mapper.ClassMapper;
import cn.netinnet.demo4.sevice.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<ClassEntity> getClassAll() {
        return classMapper.getClassAll();
    }
}
