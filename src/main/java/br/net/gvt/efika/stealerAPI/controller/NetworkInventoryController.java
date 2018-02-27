/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.stealerAPI.controller.in.GetClienteIn;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.net.gvt.efika.stealerAPI.model.entity.Log;
import javax.ws.rs.POST;
import br.net.gvt.efika.stealerAPI.model.service.factory.FactoryService;
import javax.ws.rs.Consumes;

/**
 *
 * @author G0041775
 */
@Path("/networkInventory")
public class NetworkInventoryController {

    @POST
    @Path("/tbs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteTBS(GetClienteIn in) {
        try {

            InventarioRede out = FactoryService.createTbsNetworkInventoryServiceImpl().consultar(in.getInstancia());
            try {
                Log l = new Log(in);
                l.setOuput(out);
                FactoryDAO.createLogDAO().cadastrar(l);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Response.status(200).entity(out).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @POST
    @Path("/sigres")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteSigres(GetClienteIn in) {
        try {

            InventarioRede out = FactoryService.createSigresNetworkInventoryServiceImpl().consultar(in.getInstancia());
            try {
                Log l = new Log(in);
                l.setOuput(out);
                FactoryDAO.createLogDAO().cadastrar(l);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Response.status(200).entity(out).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

}
