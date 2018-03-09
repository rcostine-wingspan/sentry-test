package com.wingspan.sentrytest

object SentryBreadCrumbExample extends SentryEnabledApp {

  def foo(): Unit = record("foo") ()
  def bar(): Unit = record("bar") ()
  def baz(): Unit = record("baz") ()

  foo()
  bar()
  baz()
  throw new UnsupportedOperationException("Bread crumb example - Boom!")

}
