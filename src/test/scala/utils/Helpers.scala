package utils

import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef.exec
import io.gatling.http.Predef.{flushCookieJar, flushHttpCache}
import org.slf4j.LoggerFactory

object Helpers {
  def debugInfo(): Unit = {
    if (PropertiesLoader.isDebug) {
      val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
      context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
    }
  }

  val clearCache = exec(flushHttpCache)
  val clearCookies = exec(flushCookieJar)
}
