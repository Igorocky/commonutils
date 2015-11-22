package org.igye.commonutils

import org.apache.logging.log4j.Logger

import scala.concurrent.Future

object FutureLoggable {
    def apply[T](body : => T)(implicit log: Logger, executor : scala.concurrent.ExecutionContext): Future[T] = {
        val res = Future {
            body
        }
        res.onFailure({ case t: Throwable => {
            log.error(s"Exception: ${t.getMessage}", t)
            throw t
        }
        })
        res
    }
}
