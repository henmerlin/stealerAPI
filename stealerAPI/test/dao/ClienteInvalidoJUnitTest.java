/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exception.CircuitoNaoEncontradoException;
import dao.exception.ClienteSemBandaException;
import dao.exception.FalhaInputException;
import input.TestValues;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class ClienteInvalidoJUnitTest {

    private final EfikaCustomerInterface dao = FactoryDAO.createClienteDAO();

    public ClienteInvalidoJUnitTest() {
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

    @Test
    public void erroDigitacao() {
        try {
            dao.consultarCliente("413022-2839.");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof FalhaInputException);
        }
    }

    @Test
    public void erroDigitacao2() {
        try {
            dao.consultarCliente("slkdf");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof FalhaInputException);
        }
    }

    @Test
    public void clienteValido() {
        try {
            dao.consultarCliente(TestValues.VALIDO);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void clienteSemDesignador() {
        try {
            dao.consultarCliente(TestValues.SEM_BANDA);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof ClienteSemBandaException);
        }
    }

    @Test
    public void clienteSemCircuitoGpon() {

        try {
            dao.consultarCliente("1630105326");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof CircuitoNaoEncontradoException);
        }
    }

    @Test
    public void clienteSemCircuitoMetalico() {
        try {
            dao.consultarCliente("1630105326");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof CircuitoNaoEncontradoException);
        }
    }

}
