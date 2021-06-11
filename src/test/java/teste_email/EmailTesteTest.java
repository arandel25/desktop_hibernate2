/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste_email;

import entidade.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;
import util.UtilGerador;

/**
 *
 * @author Felipe
 */
public class EmailTesteTest {
    
    public EmailTesteTest() {
    }

//    @Test
    public void testCriarEmailUsuarioNovo() {
        System.out.println("criarEmailUsuarioNovo");
        Usuario usuario = new Usuario();
        usuario.setNome(UtilGerador.gerarNome());
        usuario.setLogin("arandel.felipe@gmail.com");
        usuario.setSenha(UtilGerador.gerarCaracter(4));
        
        EmailTeste emailTeste = new EmailTeste();
        boolean enviou = emailTeste.criarEmailUsuarioNovo(usuario);
        assertTrue(enviou);
    }
}
