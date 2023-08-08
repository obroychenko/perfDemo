package scenarios.breweriesScenarios

import io.gatling.core.Predef.scenario
import request.rabbitMQ.TopicExchangeRequests
import utils.Helpers.{clearCache, clearCookies}
import utils.PropertiesLoader.messageIdsFeeder

object BasicRabbitMQScenario {

  //define scenario using requests from imported package object
  val mainRabbitMQScenario = scenario("RabbitMQ Topic Exchange Basic Scenario")
    .feed(messageIdsFeeder)
    .exec(
      clearCache,
      clearCookies,
      TopicExchangeRequests.publishToTopic
    )
}
