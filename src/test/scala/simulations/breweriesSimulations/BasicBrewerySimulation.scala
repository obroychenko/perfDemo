package simulations.breweriesSimulations

import io.gatling.core.Predef._
import request.starterpackage.OpenBrewBasicRequests._
import scenarios.breweriesScenarios.BasicBreweryScenarios
import utils.Helpers
import utils.PropertiesLoader._

///define simulation importing scenarios and http protocol from package object
class BasicBrewerySimulation extends BaseSimulation {

  setUp(
    BasicBreweryScenarios.mainBreweryScenario.inject(
      constantUsersPerSec(users).during(duration))
      .protocols(httpProtocol)
  )
}