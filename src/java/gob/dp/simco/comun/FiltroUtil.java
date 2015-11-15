/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.comun;

import org.apache.commons.lang3.StringUtils;


/**
 *
 * @author Administrador
 */
public class FiltroUtil
{
    private FiltroUtil()
    {

    }

    public static String agregarLike(String filtro)
    {
        if (StringUtils.isNotEmpty(filtro))
        {
            return "%" + filtro.trim() + "%" ;
        }
        return null;
    }
}
