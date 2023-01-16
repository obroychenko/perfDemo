package request.starterpackage

//import
import utils.PropertiesLoader._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

 object OpenBrewBasicRequests {

  // load properties
  // create http protocol and feeder

  //describe requests
  val openBasicBrew = tryMax(2) {
    exec(http("All breweries")
      .get("/breweries").check(status.is(200), substring("micro").exists)).exitHereIfFailed
  }

  val getOneBrewery = tryMax(2) {
    feed(csvFeeder)
      .exec(http("Get brewery")
        .get("/breweries/${brewery_id}").check(status.is(200), responseTimeInMillis.lte(1600)))
  }
}
