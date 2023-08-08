package scenarios.breweriesScenarios

import io.gatling.core.Predef._
import request.starterpackage.OpenBrewBasicRequests
import utils.Helpers.{clearCache, clearCookies}
import utils.PropertiesLoader.csvFeeder

object BasicBreweryScenarios {

  //define scenario using requests from imported package object
  val mainBreweryScenario = scenario("Brew Main Scenario")
    .feed(csvFeeder)
    .exec(clearCache, clearCookies,
      OpenBrewBasicRequests.openBasicBrew,
      OpenBrewBasicRequests.getExtractedBrewery,
      OpenBrewBasicRequests.getOneBrewery
    )
}
