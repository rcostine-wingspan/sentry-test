package com.wingspan.sentrytest

import io.sentry.Sentry

import scala.util.{Success, Failure, Try}

object SentryAutoCaptureExceptionExample extends App {

  /*
    It is recommended that you use the DSN detection system, which
    will check the environment variable "SENTRY_DSN", the Java
    System Property "sentry.dsn", or the "sentry.properties" file
    in your classpath. This makes it easier to provide and adjust
    your DSN without needing to change your code. See the configuration
    page for more information.
  */
  Sentry.init()
  throw new UnsupportedOperationException("Boom!")


}
