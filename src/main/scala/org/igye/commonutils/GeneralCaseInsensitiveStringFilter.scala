package org.igye.commonutils

import scala.util.matching.Regex

case class GeneralCaseInsensitiveStringFilter(filterStr: String) {
    val pattern = new Regex(filterStr.toUpperCase().mkString("^.*",".*",".*$"))
    def matches(str: String) = {
        pattern.findFirstIn(str.toUpperCase()).isDefined
    }
}
