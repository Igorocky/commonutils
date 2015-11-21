package org.igye.commonutils

import java.io.{File, StringReader, StringWriter}
import javax.xml.bind.{Marshaller, JAXBContext}

import scala.reflect.ClassTag

object JaxbSupport {
    def marshal[T: ClassTag](anyObj: T): String = {
        val res = new StringWriter()
        createMarshaller(anyObj).marshal(anyObj, res)
        res.toString
    }

    def marshal[T: ClassTag](anyObj: T, file: File): Unit = {
        createMarshaller(anyObj).marshal(anyObj, file)
    }

    private def createMarshaller[T: ClassTag](anyObj: T): Marshaller = {
        val jaxbContext = JAXBContext.newInstance(implicitly[ClassTag[T]].runtimeClass)
        val jaxbMarshaller = jaxbContext.createMarshaller()
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
        jaxbMarshaller
    }

    def unmarshal[T: ClassTag](str: String): T = {
        val source = new StringReader(str)
        createUnmarshaller[T].unmarshal(source).asInstanceOf[T]
    }

    def unmarshal[T: ClassTag](file: File): T = {
        createUnmarshaller[T].unmarshal(file).asInstanceOf[T]
    }

    private def createUnmarshaller[T: ClassTag] = {
        val jaxbContext = JAXBContext.newInstance(implicitly[ClassTag[T]].runtimeClass)
        jaxbContext.createUnmarshaller()
    }
}
