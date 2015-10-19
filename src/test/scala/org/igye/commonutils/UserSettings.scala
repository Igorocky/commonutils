package org.igye.commonutils

import javax.xml.bind.annotation.{XmlElement, XmlRootElement}

@XmlRootElement
class UserSettings {
     @XmlElement
     var s1: String = _
     @XmlElement
     var s2: String = _
 }
