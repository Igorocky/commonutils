package org.igye.commonutils

import java.io.{StringReader, StringWriter}
import javax.xml.bind.{Marshaller, JAXBContext}

import scala.reflect.ClassTag

object JaxbSupport {
    def marshal[T: ClassTag](anyObj: T): String = {
        val jaxbContext = JAXBContext.newInstance(implicitly[ClassTag[T]].runtimeClass)
        val jaxbMarshaller = jaxbContext.createMarshaller()
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
        val res = new StringWriter()
        jaxbMarshaller.marshal(anyObj, res)
        res.toString
    }

    def unmarshal[T: ClassTag](str: String): T = {
        val jaxbContext = JAXBContext.newInstance(implicitly[ClassTag[T]].runtimeClass)
        val jaxbUnmarshaller = jaxbContext.createUnmarshaller()
        val source = new StringReader(str)
        jaxbUnmarshaller.unmarshal(source).asInstanceOf[T]
    }
}
