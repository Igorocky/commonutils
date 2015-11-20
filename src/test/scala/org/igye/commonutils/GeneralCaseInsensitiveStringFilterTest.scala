package org.igye.commonutils

import org.junit.{Assert, Test}

class GeneralCaseInsensitiveStringFilterTest {
    @Test
    def testMatcher(): Unit = {
        Assert.assertTrue(GeneralCaseInsensitiveStringFilter("bd").matches("abcde"))
        Assert.assertTrue(GeneralCaseInsensitiveStringFilter("bd").matches("ABCDE"))
        Assert.assertFalse(GeneralCaseInsensitiveStringFilter("db").matches("abcde"))
        Assert.assertTrue(GeneralCaseInsensitiveStringFilter("").matches("abcde"))
        Assert.assertFalse(GeneralCaseInsensitiveStringFilter("abc").matches("abbde"))
    }
}
