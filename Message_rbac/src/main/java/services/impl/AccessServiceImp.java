package services.impl;

import entity.Access;
import mapper.AccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.AccessService;

import java.util.List;
@Service
public class AccessServiceImp implements AccessService {
    @Autowired
    private AccessMapper accessMapper;

    @Override
    public List<Access> findRole_acc(int rid) {
        return accessMapper.findRole_acc(rid);
    }

    @Override
    public List<Access> findBygroup(int gid) {
        return accessMapper.findBygroup(gid);
    }

    @Override
    public List<Access> findAll() {
        return accessMapper.findAll();
    }

}
