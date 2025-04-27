package com.meupar.perfeito.controller;

import com.meupar.perfeito.util.CriptografiaAES;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private static final String SECRET_KEY = "1234567890123456"; // 16 caracteres

    @MessageMapping("/enviar")
    @SendTo("/topic/mensagens")
    public String enviarMensagem(String mensagem) throws Exception {
        String mensagemDescriptografada = CriptografiaAES.descriptografar(mensagem, SECRET_KEY);
        System.out.println("Mensagem recebida (descriptografada): " + mensagemDescriptografada);

        // Aqui poderia salvar no banco, ou apenas repassar
        String mensagemCriptografada = CriptografiaAES.criptografar(mensagemDescriptografada, SECRET_KEY);
        return mensagemCriptografada;
    }
}
