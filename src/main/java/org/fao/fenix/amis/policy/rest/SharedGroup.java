package org.fao.fenix.amis.policy.rest;

import org.fao.fenix.amis.policy.dao.jdbc.entities.sharedGroup.SharedGroupDb;
import org.fao.fenix.amis.policy.dto.search.SharedGroupSearch;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("sharedgroups")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SharedGroup {

    @Inject
    SharedGroupDb dao;

    @GET
    public List<org.fao.fenix.amis.policy.dto.full.SharedGroup> getSharedGroups() throws Exception {
        return dao.retrieveAll();
    }

    @GET
    @Path("{id}")
    public org.fao.fenix.amis.policy.dto.full.SharedGroup getSharedGroup(@PathParam("id") String id) throws Exception {
        return dao.retrieve(Integer.parseInt(id));
    }

    @POST
    public org.fao.fenix.amis.policy.dto.full.SharedGroup postSharedGroup(org.fao.fenix.amis.policy.dto.full.SharedGroup group) throws Exception {
        return dao.insert(group);
    }

    @PUT
    public org.fao.fenix.amis.policy.dto.full.SharedGroup putSharedGroup(org.fao.fenix.amis.policy.dto.full.SharedGroup group) throws Exception {
        return dao.updateRecordToTable(group);
    }

    @DELETE
    @Path("{id}")
    public org.fao.fenix.amis.policy.dto.full.SharedGroup deleteSharedGroup(@PathParam("id") String id) throws Exception {
        return dao.delete(Integer.parseInt(id));
    }

    @POST
    @Path("/search")
    public List<org.fao.fenix.amis.policy.dto.full.SharedGroup> getSharedGroups(SharedGroupSearch searchSharedGroupBean) {
        return dao.search(searchSharedGroupBean);
    }

}