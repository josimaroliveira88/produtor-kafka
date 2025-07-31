package br.com.exemplo.produtor;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/pedidos")
public class ProdutorResource {

    @Channel("pedidos-novos")
    Emitter<String> emitter;

    private static int counter = 0;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String enviarPedido() {
        String pedido = "Novo pedido recebido: " + System.currentTimeMillis();
        String key = "pedido-key-" + (counter++);

        Message<String> message = Message.of(pedido)
                .addMetadata(OutgoingKafkaRecordMetadata.<String>builder()
                        .withKey(key)
                        .build());

        emitter.send(message);
        System.out.println("Pedido enviado com chave '" + key + "': " + pedido);
        return "Pedido enviado: " + pedido;
    }

    @Incoming("pedidos-processados-interno-in")
    public void notificarProcessamento(String notificacao) {
        System.out.println("Notificação de processamento recebida: " + notificacao);
    }
}
