import com.cds.CDSPlugin
import java.util.UUID
import org.bukkit.entity.Player
import org.bukkit.permissions.PermissionAttachment

class PermissionManager(val plugin: CDSPlugin) {
    val configPath = "permissions"
    val permissions: MutableMap<UUID, PermissionAttachment> = mutableMapOf()

    fun restorePermissions(player: Player) {
        plugin.logger.info("Restoring permissions of player ${player.name} - ${player.uniqueId}")

        val att = player.addAttachment(plugin)
        permissions[player.uniqueId] = att

        val path = "$configPath.${player.uniqueId.toString()}"
        val storedPermissions = plugin.config.getStringList(path)
        for (permission in storedPermissions) att.setPermission(permission, true)
    }

    fun setPermission(player: Player, permission: PermissionKeys, value: Boolean = true) {
        setPermission(player.uniqueId, permission, value)
    }

    fun setPermission(uuid: UUID, permission: PermissionKeys, value: Boolean = true) =
            permissions[uuid]!!.setPermission(permission.key, value)

    fun usetPermission(player: Player, permission: PermissionKeys): Unit =
            permissions[player.uniqueId]!!.unsetPermission(permission.key)

    fun detachPermissions(player: Player): Unit? =
            permissions[player.uniqueId]?.let { player.removeAttachment(it) }

    fun hasAttachment(player: Player): Boolean = permissions.containsKey(player.uniqueId)

    fun hasAttachment(uuid: UUID): Boolean = permissions.containsKey(uuid)

    fun savePermissions() {
        for ((uuid, attachment) in permissions) {
            val newPermissions = attachment.permissions.filterValues { it }.keys
            plugin.config.set("$configPath.${uuid.toString()}", newPermissions)
        }
        plugin.saveConfig()
    }

    fun detachAllPermissions() {
        permissions.clear()
    }
}
