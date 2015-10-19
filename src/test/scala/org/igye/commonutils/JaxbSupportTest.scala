package org.igye.commonutils

import org.junit.{Assert, Test}

class JaxbSupportTest {
    @Test
    def marshalSimple(): Unit = {
        val sets = new UserSettings
        sets.s1 = "S1"
        sets.s2 = "S2"

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<userSettings>\n    <s1>S1</s1>\n    <s2>S2</s2>\n</userSettings>\n",
            JaxbSupport.marshal(sets)
        )
    }

    @Test
    def unmarshalSimple(): Unit = {
        val sets = JaxbSupport.unmarshal[UserSettings]("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<userSettings>\n    <s1>S1</s1>\n    <s2>S2</s2>\n</userSettings>")
        Assert.assertEquals("S1", sets.s1)
        Assert.assertEquals("S2", sets.s2)
    }
}
