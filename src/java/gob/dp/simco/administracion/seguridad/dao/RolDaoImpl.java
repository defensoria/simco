/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.administracion.seguridad.dao;

import gob.dp.simco.administracion.seguridad.entity.Rol;
import gob.dp.simco.administracion.seguridad.entity.Usuario;
import gob.dp.simco.administracion.seguridad.entity.UsuarioRol;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public class RolDaoImpl extends SqlSessionDaoSupport implements RolDao {

    @Override
    public List<Rol> buscarRol(Rol filtro) {
        return getSqlSession().selectList("rolDao.buscarRol", filtro);
    }

    @Override
    public List<Rol> buscarRolSegunUsuario(Usuario filtro) {
        return getSqlSession().selectList("rolDao.buscarRolSegunUsuario", filtro);
    }

    @Override
    public void insertarUsuarioRol(UsuarioRol usuarioRol) {
        getSqlSession().insert("rolDao.insertarUsuarioRol", usuarioRol);
    }

    @Override
    public void deleteUsuarioRol(UsuarioRol usuarioRol) {
        getSqlSession().delete("rolDao.deleteUsuarioRol", usuarioRol);
    }

    @Override
    public Map<String, Rol> buscarMapRolSegunUsuario(Usuario filtro) {

        return getSqlSession().selectMap("rolDao.buscarRolSegunUsuario", filtro, "codigo");
    }

}
