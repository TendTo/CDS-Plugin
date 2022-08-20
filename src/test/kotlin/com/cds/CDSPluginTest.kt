package com.cds

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import org.mockito.kotlin.mock

internal class CDSPluginTest {
    var plugin = mock<CDSPlugin>()

    @BeforeTest
    fun beforeTest() {
        plugin = mock<CDSPlugin>()
    }

    @Test
    fun testPluginMock() {
        assertNotNull(plugin)
    }
}
