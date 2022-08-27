package xyz.paradoxclient.utils

class MouseUtil {

    companion object {
        fun isInside(mouseX: Int, mouseY: Int, x: Double, y: Double, width: Double, height: Double): Boolean {
            return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height
        }
    }
}