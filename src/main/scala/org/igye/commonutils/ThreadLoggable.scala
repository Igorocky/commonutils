package org.igye.commonutils

import java.lang.Thread.UncaughtExceptionHandler
import java.util.Date

import org.apache.logging.log4j.Logger

class ThreadLoggable(implicit log: Logger) extends Thread(log.getName + "_%1$tF_%1$tT".format(new Date)) {
    val prevUncaughtExceptionHandler = getUncaughtExceptionHandler
    setUncaughtExceptionHandler(new UncaughtExceptionHandler {
        override def uncaughtException(t: Thread, e: Throwable): Unit = {
            log.error(e.getMessage, e)
            if (prevUncaughtExceptionHandler != null) {
                prevUncaughtExceptionHandler.uncaughtException(t, e)
            } else {
                throw e
            }
        }
    })
}
