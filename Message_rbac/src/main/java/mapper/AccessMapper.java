package mapper;

import entity.Access;

import java.util.List;

public interface AccessMapper {
    public List<Access> findRole_acc(int rid);
    public List<Access> findBygroup(int gid);
    public List<Access> findAll();

}
