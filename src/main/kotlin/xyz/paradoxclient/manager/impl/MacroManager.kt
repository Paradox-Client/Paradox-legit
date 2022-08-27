package xyz.paradoxclient.manager.impl

import org.lwjgl.input.Keyboard
import xyz.paradoxclient.Paradox
import xyz.paradoxclient.macro.Macro
import xyz.paradoxclient.macro.impl.GuiMacro
import xyz.paradoxclient.macro.impl.ToggleMacro
import xyz.paradoxclient.manager.Manager

class MacroManager : Manager() {

    val macros = ArrayList<Macro>()

    override fun run() {
        macros.add(GuiMacro(Paradox.INSTANCE.igMaterialGUI, Keyboard.KEY_RSHIFT))
    }
}