package mapper;

import entity.Access;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessMapper {
    public List<Access> findRole_acc(int rid);
    public List<Access> findBygroup(int gid);
    public List<Access> findAll();
    public void insertAcc(int rid, int aid);
    public void deleteAccR(int rid);
    public void deleteACcA(int rid, int aid);

}
