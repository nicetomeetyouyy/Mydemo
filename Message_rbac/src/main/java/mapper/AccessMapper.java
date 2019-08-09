package mapper;

import entity.Access;

import java.util.List;

public interface AccessMapper {
    public List<Access> findRole_acc(int rid);
    public List<Access> findBygroup(int gid);
    public List<Access> findAll();
    public void insertAcc(int rid,int aid);
    public void deleteAccR(int rid);
    public void deleteACcA(int rid,int aid);

}
