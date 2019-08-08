package services;

import entity.Access;

import java.util.List;

public interface AccessService {
    public List<Access> findRole_acc(int rid);
    public List<Access> findBygroup(int gid);
    public List<Access> findAll();
}
