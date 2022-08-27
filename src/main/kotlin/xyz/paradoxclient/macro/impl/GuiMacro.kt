package xyz.paradoxclient.macro.impl

import net.minecraft.client.gui.GuiScreen
import xyz.paradoxclient.interfaces.IMinecraft
import xyz.paradoxclient.macro.Macro

class GuiMacro(val gui: GuiScreen, mKey: Int) : Macro(mKey), IMinecraft {

    override fun run() {
        mc.displayGuiScreen(gui)
    }
}