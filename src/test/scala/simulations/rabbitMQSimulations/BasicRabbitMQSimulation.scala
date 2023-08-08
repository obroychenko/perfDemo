package simulations.rabbitMQSimulations

import io.gatling.core.Predef._
import scenarios.breweriesScenarios.BasicRabbitMQScenario
import simulations.breweriesSimulations.BaseSimulation
import ru.tinkoff.gatling.amqp.Predef._
import utils.PropertiesLoader._
import utils.RabbitMQHelper.amqpConf

///define simulation importing scenarios and http protocol from package object
class BasicRabbitMQSimulation extends BaseSimulation {

  setUp(
    BasicRabbitMQScenario.mainRabbitMQScenario.inject(
      constantUsersPerSec(users).during(duration)).protocols(amqpConf)
  )
}