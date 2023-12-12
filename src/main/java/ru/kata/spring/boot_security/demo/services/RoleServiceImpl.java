package ru.kata.spring.boot_security.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repository.RoleDao;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {


    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findRoleById(Long id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleDao.findRoleByRoleName(roleName);
    }


}
