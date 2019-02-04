
package com.claudio.cadastro.server.rest;


import com.claudio.cadastro.server.dao.DAO;
import com.claudio.cadastro.server.model.Cidade;
import com.claudio.cadastro.server.model.Usuario;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author aluno
 */
@Path("/usuario")
@Transactional
public class UsuarioResource {
    
    @Inject
    private DAO<Usuario> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario findById(@PathParam("id") long id) {
        return dao.findById(id);
    }
    
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> list() {
        return dao.list();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long insert(Usuario usuario) {
        return dao.save(usuario);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_ATOM_XML})
    public long update(Usuario usuario) {
        return dao.save(usuario);
    }
    
    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id) {
        return dao.remove(id);
    }
    
    
}
