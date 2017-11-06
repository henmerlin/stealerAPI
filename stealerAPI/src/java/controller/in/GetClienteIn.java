/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import br.net.gvt.efika.customer.EfikaCustomer;
import model.entity.LoggerIn;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class GetClienteIn extends LoggerIn {

    private String instancia;

    public GetClienteIn() {
    }

    @Override
    public String getInput() {
        return "{\"instancia\":\"" + instancia + "\"}";
    }

    @Override
    public String getAcao() {
        return "ClienteController.getCliente";
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

}
