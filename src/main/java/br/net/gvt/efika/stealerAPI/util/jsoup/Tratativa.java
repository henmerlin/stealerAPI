/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.util.jsoup;

/**
 *
 * @author G0042204
 * @param <T>
 * @param <E>
 */
public interface Tratativa<T, E> {

    public T parse(E param) throws Exception;

}