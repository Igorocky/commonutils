package org.igye.commonutils

import scala.collection.mutable.ListBuffer

trait Enum[E] {
    private val elems = ListBuffer[E]()
    private var allElems_ : List[E] = _

    protected def addElem(elem: E) = {
        elems += elem
        elem
    }

    def allElems = {
        if (allElems_ == null) {
            allElems_ = elems.toList
        }
        allElems_
    }
}
