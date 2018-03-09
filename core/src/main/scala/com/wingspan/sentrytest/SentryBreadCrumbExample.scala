package com.wingspan.sentrytest

import io.sentry.Sentry
import io.sentry.event.BreadcrumbBuilder

object SentryBreadCrumbExample extends App {

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

  def foo(): Unit = record("foo") ()
  def bar(): Unit = record("bar") ()
  def baz(): Unit = record("baz") ()

  Sentry.init()

  foo()
  bar()
  baz()
  throw new UnsupportedOperationException("Boom!")

}
