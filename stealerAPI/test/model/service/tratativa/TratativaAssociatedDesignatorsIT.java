/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.tratativa;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import dao.FactoryDAO;
import dao.oss.OSSGenericDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.GsonUtil;

/**
 *
 * @author G0041775
 */
public class TratativaAssociatedDesignatorsIT {

    public TratativaAssociatedDesignatorsIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of tratar method, of class TratativaAssociatedDesignators.
     */
    @Test
    public void testTratar() throws Exception {
        System.out.println("tratar");
        String instancia = "4130776101";
        EfikaCustomer ec = new EfikaCustomer();
        OSSGenericDAO dao = FactoryDAO.createOSS();
        InventoryAccountResponse accountItems = dao.getAccountItems(instancia);
        InventoryDesignatorsResponse associatedDesignators = dao.getAssociatedDesignators(instancia);

        TratativaAssociatedDesignators instance = new TratativaAssociatedDesignators(associatedDesignators, ec, accountItems);
        instance.tratar();
        System.out.println("Cliente -> " + GsonUtil.serialize(ec));
        
    }

}