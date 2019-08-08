package mapper;

import entity.Role;

import java.util.List;

public interface RoleMapper {
     public Role findById(int id);
     public List<Role> findAll();
     public void deleteRole(int rid);
}
