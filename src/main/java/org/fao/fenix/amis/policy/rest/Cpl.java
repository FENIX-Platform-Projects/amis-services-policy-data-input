package org.fao.fenix.amis.policy.rest;

import org.fao.fenix.amis.policy.dao.jdbc.entities.cpl.CplDb;
import org.fao.fenix.amis.policy.dto.search.CplSearch;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("cpls")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Cpl {

    @Inject
    private CplDb dao;

    @GET
    public List<org.fao.fenix.amis.policy.dto.full.Cpl> getCpls() throws Exception {
        return dao.retrieveAll();
    }

    @GET
    @Path("{id}")
    public org.fao.fenix.amis.policy.dto.full.Cpl getCpl(@PathParam("id") String id) throws Exception {
        return dao.retrieve(Integer.parseInt(id));
    }

    @POST
    public org.fao.fenix.amis.policy.dto.full.Cpl postCPL(org.fao.fenix.amis.policy.dto.full.Cpl cpl) throws Exception {
        return dao.insert(cpl);
    }

    @PUT
    public org.fao.fenix.amis.policy.dto.full.Cpl putSharedGroup(org.fao.fenix.amis.policy.dto.full.Cpl cpl) throws Exception {
        return dao.updateRecordToTable(cpl);
    }

    @DELETE
    @Path("{id}")
    public org.fao.fenix.amis.policy.dto.full.Cpl deleteSharedGroup(@PathParam("id") String id) throws Exception {
        return dao.delete(Integer.parseInt(id));
    }

    @POST
    @Path("/search")
    public List<org.fao.fenix.amis.policy.dto.full.Cpl> searchCpl(CplSearch sb) {
        return dao.search(sb);
    }

}