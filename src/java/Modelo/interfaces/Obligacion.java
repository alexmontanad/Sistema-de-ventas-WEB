/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import java.util.List;

/**
 *
 * @author Alex
 * @param <Objeto>
 */
public interface Obligacion <Objeto>{
    
    public boolean create(Objeto nuevo);
    
    public List<Objeto> readAll();
    
    public Objeto read(Objeto filtro);
    
    public boolean update(Objeto item);
    
    public boolean delete(Objeto item);
    
}
