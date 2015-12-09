package org.igye.commonutils

import java.util.function.Consumer

object Implicits {
    implicit def consumer[T](consumer: T => Unit) = {
        new Consumer[T] {
            override def accept(t: T): Unit = {
                consumer(t)
            }
        }
    }
}
