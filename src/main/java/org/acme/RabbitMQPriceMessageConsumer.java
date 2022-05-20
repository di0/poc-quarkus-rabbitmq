package org.acme;

import org.jboss.logging.Logger;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class RabbitMQPriceMessageConsumer {
    private static final Logger LOG = Logger.getLogger(RabbitMQPriceMessageConsumer.class);

    @Incoming("prices")
    public CompletionStage<Void> consume(Message<String> message) {
        LOG.info("Mensagem recebido " + message);

        // Acknowledge the incoming message, marking the RabbitMQ message as `accepted`.
        return message.ack();
    }
}

