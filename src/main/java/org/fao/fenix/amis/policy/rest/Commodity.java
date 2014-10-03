package org.fao.fenix.amis.policy.rest;

import org.fao.fenix.amis.policy.dao.jdbc.entities.commodity.CommodityDb;
import org.fao.fenix.amis.policy.dto.search.CommoditySearch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import java.util.List;

@Path("commodities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Commodity {

    @Inject
    private CommodityDb dao;

    @GET
    public List<org.fao.fenix.amis.policy.dto.full.Commodity> getCommodities() throws Exception {
        return dao.retrieveAll();
    }

    @GET
    @Path("{id}")
    public org.fao.fenix.amis.policy.dto.full.Commodity getCommodity(@PathParam("id") String id) throws Exception {
        return dao.retrieve(Integer.parseInt(id));
    }

    @POST
    public org.fao.fenix.amis.policy.dto.full.Commodity postCommodity(org.fao.fenix.amis.policy.dto.full.Commodity commodity) throws Exception {
        return dao.insert(commodity);
    }

    @PUT
    public org.fao.fenix.amis.policy.dto.full.Commodity putCommodity(org.fao.fenix.amis.policy.dto.full.Commodity commodity) throws Exception {
        return dao.updateRecordToTable(commodity);
    }

    @DELETE
    @Path("{id}")
    public org.fao.fenix.amis.policy.dto.full.Commodity deleteCommodity(@PathParam("id") String id) throws Exception {
        return dao.delete(Integer.parseInt(id));
    }

    @POST
    @Path("/search")
    public List<org.fao.fenix.amis.policy.dto.full.Commodity> search(CommoditySearch searchCommodityBean) {
        return dao.search(searchCommodityBean);
    }

}