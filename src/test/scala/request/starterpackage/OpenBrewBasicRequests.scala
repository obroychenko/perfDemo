package request.starterpackage

//import
import io.gatling.core.Predef._
import io.gatling.http.Predef._

 object OpenBrewBasicRequests {

  //describe requests
  val openBasicBrew = tryMax(2) {
    exec(http("All breweries")
      .get("/breweries").check(status.is(200), substring("micro").exists,
      jsonPath("$..id").find.saveAs("brewId"))).exitHereIfFailed
  }

  val getOneBrewery = tryMax(2) {
      exec(http("Get brewery")
        .get("/breweries/${brewery_id}").check(status.is(200), responseTimeInMillis.lte(1600)))
  }

   val getExtractedBrewery = tryMax(2) {

     exec(http("Get Extracted Brewery")
       .get("/breweries/${brewId}").check(status.is(200)))
   }
}
