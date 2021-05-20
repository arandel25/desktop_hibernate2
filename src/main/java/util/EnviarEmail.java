/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entidade.Usuario;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * @author Felipe
 */
public class EnviarEmail {

    private Session session;

    private void criarSessaoEmail() {
        Properties props = new Properties();
//        Parâmetros de conexão com servidor Gmail
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("arandel.felipe@gmail.com", "99651845");
            }
        });
        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);
    }

    public void criarEmailUsuarioNovo(Usuario usuario) {
        criarSessaoEmail();
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("arandel.felipe@gmail.com"));

            Address[] toUser = InternetAddress.parse(usuario.getLogin());

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Dados de acesso ao sistema");//Assunto

            StringBuilder corpoEmail = new StringBuilder();
            corpoEmail.append("Olá ").append(usuario.getNome()).append("!\n\n\n");
            corpoEmail.append("Segue os dados de acesso ao sistema\n\n");
            corpoEmail.append("Seu login é seu e-mail: ").append(usuario.getLogin());
            corpoEmail.append("\n\n");
            corpoEmail.append("Sua senha é: ").append(usuario.getSenha());
            corpoEmail.append("\n\n\n");
            corpoEmail.append("Atenciosamente RH Empresa XYZ Ltda");

            message.setText(corpoEmail.toString());

            Transport.send(message);
            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
