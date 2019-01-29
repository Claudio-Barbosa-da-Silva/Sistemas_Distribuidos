
package com.claudio.cadastro.server.rest;


import com.claudio.cadastro.server.dao.DAO;
import com.claudio.cadastro.server.model.Usuario;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author aluno
 */
@Path("/usuario")
public class UsuarioResource {
    
    @Inject
    private DAO<Usuario> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario findById(@PathParam("id") long id) {
        return dao.findById(id);
    }
    
    
    
}
