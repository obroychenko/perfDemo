package utils

import com.typesafe.config._
import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object PropertiesLoader {

  //Load environment properties
  val environment: String = System.getProperty("env")
  private val config: Config = ConfigFactory.load(s"$environment.application.conf")

  // App Details
  lazy val apiURL: String = config.getString("api.url")

  //Simulation Details
  lazy val users: Int = config.getInt("users")
  lazy val duration: Int = config.getInt("duration")
  lazy val httpProtocol: HttpProtocolBuilder = http.baseUrl(apiURL)
  lazy val isDebug: Boolean = config.getString("isDebug").toBoolean
  lazy val csvFeeder: BatchableFeederBuilder[String] = csv(config.getString("brewIdsFeed")).eager.circular
  lazy val messageIdsFeeder: BatchableFeederBuilder[String] = csv(config.getString("messageIdsFeed")).eager.circular
}
