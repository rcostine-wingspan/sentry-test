package com.wingspan.sentrytest

object SentryAutoCaptureExceptionExample extends SentryEnabledApp {
  throw new UnsupportedOperationException("Auto capture example - Boom!")
}
