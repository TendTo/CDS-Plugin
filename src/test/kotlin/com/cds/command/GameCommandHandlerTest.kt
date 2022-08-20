package com.cds.command

import com.cds.CDSPlugin
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.bukkit.command.Command
import org.bukkit.entity.Player
import org.mockito.kotlin.mock
import org.mockito.kotlin.spy
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class GameCommandHandlerTest {
    var plugin = mock<CDSPlugin>()
    var player = mock<Player>()
    var cmd = mock<Command>()
    var commandHandler = GameCommandHandler(plugin)

    @BeforeTest
    fun beforeTest() {
        plugin = mock<CDSPlugin>()
        player = mock<Player>()
        cmd = mock<Command>()
        commandHandler = spy(GameCommandHandler(plugin))
    }

    @Test
    fun givenCmdName_whenHandleCommand_shouldReturnFalse() {
        whenever(cmd.name).thenReturn("name")

        val res = commandHandler.handleCommand(player, cmd, "label", listOf("arg").toTypedArray())

        assertFalse(res)
        verify(commandHandler, times(0)).handleDed(player)
        verify(commandHandler, times(0))
                .handleMucri(player, cmd, "label", listOf("arg").toTypedArray())
    }

    @Test
    fun givenCmdDed_whenHandleCommand_shouldRunHandleDed() {
        whenever(cmd.name).thenReturn("ded")

        val res = commandHandler.handleCommand(player, cmd, "label", listOf("arg").toTypedArray())

        assertTrue(res)
        verify(commandHandler, times(1)).handleDed(player)
        verify(commandHandler, times(0))
                .handleMucri(player, cmd, "label", listOf("arg").toTypedArray())
    }

    @Test
    fun givenCmdMucri_whenHandleCommand_shouldRunHandleMucri() {
        whenever(cmd.name).thenReturn("mucri")

        commandHandler.handleCommand(player, cmd, "label", listOf("arg").toTypedArray())

        verify(commandHandler, times(0)).handleDed(player)
        verify(commandHandler, times(1))
                .handleMucri(player, cmd, "label", listOf("arg").toTypedArray())
    }

    @Test
    fun givenCmdMucri_whenHandleMucri_killPlayer() {
        whenever(cmd.name).thenReturn("mucri")

        val res = commandHandler.handleDed(player)

        assertTrue(res)
        verify(player, times(1)).setHealth(0.0)
    }

    @Test
    fun givenPlayerWithNoPermission_whenHandleMucri_shouldWarnInsufficientPermissions() {
        whenever(cmd.name).thenReturn("mucri")
        whenever(player.hasPermission(PermissionKeys.MUCRO.key)).thenReturn(false)

        val res = commandHandler.handleMucri(player, cmd, "label", listOf("arg").toTypedArray())

        assertTrue(res)
        verify(player, times(1)).sendMessage("Non sei mucro, mi dispy :'(")
    }

    @Test
    fun givenPlayerWithPermissionButNoArgs_whenHandleMucri_shouldWarnInsufficientPermissions() {
        whenever(cmd.name).thenReturn("mucri")
        whenever(player.hasPermission(PermissionKeys.MUCRO.key)).thenReturn(true)

        val res = commandHandler.handleMucri(player, cmd, "label", listOf<String>().toTypedArray())

        assertFalse(res)
    }
}
