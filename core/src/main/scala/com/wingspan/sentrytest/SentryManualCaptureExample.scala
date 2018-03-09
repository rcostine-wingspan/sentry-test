package com.wingspan.sentrytest

import io.sentry.Sentry
import scala.util.{Try, Success, Failure }

object SentryManualCaptureExample extends SentryEnabledApp {

  def foo(): Unit = record("foo") ()
  def bar(): Unit = record("bar") ()
  def baz(): Unit = record("baz") ()

  foo()
  bar()
  baz()
  Try { throw new UnsupportedOperationException("Manual capture example - Boom!") } match {
    case Success(_) => ()
    case Failure(t) => Sentry.capture(t)
  }

}
