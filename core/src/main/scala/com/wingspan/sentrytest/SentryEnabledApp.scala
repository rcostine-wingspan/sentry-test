package com.wingspan.sentrytest

import io.sentry.Sentry
import io.sentry.event.BreadcrumbBuilder

trait SentryEnabledApp extends App {
  def entered(s: String) : Unit = {
    val entered = new BreadcrumbBuilder().setMessage(s"${s} entered").build()
    Sentry.getContext.recordBreadcrumb(entered)
  }

  def exited(s: String): Unit = {
    val entered = new BreadcrumbBuilder().setMessage(s"${s} exited").build()
    Sentry.getContext.recordBreadcrumb(entered)
  }

  def record[A] ( s: String) (f: => A) = {
    entered(s)
    val a = f
    exited(s)
    a
  }
  /*
    It is recommended that you use the DSN detection system, which
    will check the environment variable "SENTRY_DSN", the Java
    System Property "sentry.dsn", or the "sentry.properties" file
    in your classpath. This makes it easier to provide and adjust
    your DSN without needing to change your code. See the configuration
    page for more information.
  */
  Sentry.init()
}
