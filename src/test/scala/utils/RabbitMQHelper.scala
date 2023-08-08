package utils

import io.gatling.core.Predef._
import ru.tinkoff.gatling.amqp.Predef._
import ru.tinkoff.gatling.amqp.protocol.AmqpProtocolBuilder

object RabbitMQHelper {

  val amqpConf: AmqpProtocolBuilder = amqp
    .connectionFactory(
      rabbitmq
        .host("localhost")
        .port(5672)
        .username("guest")
        .password("guest")
        .vhost("/"),
    )
    .replyTimeout(60000)
    .consumerThreadsCount(8)
    .usePersistentDeliveryMode

}