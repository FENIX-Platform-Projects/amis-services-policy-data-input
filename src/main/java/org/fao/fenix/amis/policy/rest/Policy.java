package org.fao.fenix.amis.policy.rest;

import org.fao.fenix.amis.policy.dao.jdbc.entities.policy.PolicyDb;
import org.fao.fenix.amis.policy.dto.search.PolicySearch;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("policies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Policy {

    @Inject
    PolicyDb dao;

    @GET
    public List<org.fao.fenix.amis.policy.dto.full.Policy> getPolicies() throws Exception {
        return dao.retrieveAll();
    }

    @GET
    @Path("{id}")
    public org.fao.fenix.amis.policy.dto.full.Policy getPolicy(@PathParam("id") String id) throws Exception {
        return dao.retrieve(Integer.parseInt(id));
    }

    @POST
    public org.fao.fenix.amis.policy.dto.full.Policy postPolicy(org.fao.fenix.amis.policy.dto.full.Policy policy) throws Exception {

        return dao.insert(policy);
    }

    @PUT
    public org.fao.fenix.amis.policy.dto.full.Policy putPolicy(org.fao.fenix.amis.policy.dto.full.Policy policy) throws Exception {

        return dao.updateRecordToTable(policy);
    }

    @DELETE
    @Path("{id}")
    public org.fao.fenix.amis.policy.dto.full.Policy deletePolicy(@PathParam("id") String id) throws Exception {

        return dao.delete(Integer.parseInt(id));
    }

    @POST
    @Path("/search")
    public List<org.fao.fenix.amis.policy.dto.full.Policy> searchPolicies(PolicySearch searchPolicyBean) {
        return dao.search(searchPolicyBean);

    }

}