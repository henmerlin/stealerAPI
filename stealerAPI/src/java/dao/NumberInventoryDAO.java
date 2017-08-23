/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.gvt.www.eai.NumberInventoryServicesWS.GetNumberByFilterIn;
import br.com.gvt.www.eai.NumberInventoryServicesWS.GetNumberByFilterOut;
import br.com.gvt.www.eai.NumberInventoryServicesWS.NumberInventoryServicesWSProxy;
import java.rmi.RemoteException;

/**
 *
 * @author G0041775
 */
public class NumberInventoryDAO implements NumberInventoryDAOInterface{

    private final NumberInventoryServicesWSProxy ws = new NumberInventoryServicesWSProxy();
    
    @Override
    public GetNumberByFilterOut getSwitchInfo(String instancia) throws RemoteException {
        return ws.getNumberByFilter(new GetNumberByFilterIn(instancia));
    }
    
}
