/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.domain.ntlm.CredencialDominio;

/**
 *
 * @author G0042204
 */
public interface NtlmDAO {

    public Boolean verificarCredenciais(CredencialDominio cred) throws Exception;

}
