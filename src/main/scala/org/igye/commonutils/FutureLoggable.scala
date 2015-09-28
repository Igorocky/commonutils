package org.igye.commonutils

import org.slf4j.Logger

import scala.concurrent.Future

object FutureLoggable {
    def apply[T](body : => T)(implicit log: Logger, executor : scala.concurrent.ExecutionContext): Future[T] = {
        val res = Future {
            body
        }
        res.onFailure({case ex: Exception => log.error(s"Exception: ${ex.getMessage}", ex)})
        res
    }
}