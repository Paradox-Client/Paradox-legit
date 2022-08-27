package xyz.paradoxclient.utils

import net.minecraft.client.gui.Gui
import net.minecraft.client.gui.ScaledResolution
import xyz.paradoxclient.interfaces.IMinecraft
import java.awt.Color

class RenderUtil {

    companion object : IMinecraft {
        fun drawRect(x: Double, y: Double, width: Double, height: Double, color: Color) {
            Gui.drawRect(x, y, x + width, y + height, color.rgb)
        }

        fun getScaledResolution(): ScaledResolution {
            return ScaledResolution(mc)
        }
    }
}