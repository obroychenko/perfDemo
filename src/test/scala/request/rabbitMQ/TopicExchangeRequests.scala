package request.rabbitMQ

import io.gatling.core.Predef._
import ru.tinkoff.gatling.amqp.Predef._

object TopicExchangeRequests {

  val publishToTopic = exec(
    amqp("publish to exchange").publish
      .topicExchange("gatlingExchange", "gatKey")
      .textMessage("Hello message - ${messageId}")
      .messageId("${messageId}")
      .priority(0),
  )
}
