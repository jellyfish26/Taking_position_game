import java.util.ArrayList

import javafx.application.Application
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.stage.Stage
import kotlin.system.exitProcess

class App : Application() {
    private var row = 0

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        primaryStage.title = "Taking position game"
        primaryStage.scene = Scene(createContent())
        primaryStage.show()
    }

    private fun createContent(): Parent {
        val root = Pane()
        root.setPrefSize(750.0, 750.0)

        setting()

        var c = 'a'
        val tiles = ArrayList<Tile>()
        for(ver_length in 0 until Value.vertical) {
            for(wid_length in 0 until Value.width) {
                tiles.add(Tile(Value.point[ver_length][wid_length].toString()))
            }
        }

        row = Value.width

        for (i in tiles.indices) {
            val tile = tiles[i]
            tile.translateX = (50 * (i % row)).toDouble()
            tile.translateY = (50 * (i / row)).toDouble()
            root.children.add(tile)
        }

        return root
    }

    private fun setting() {

        if(Debug.developer) println("Lunch App")
        Value.vertical = initialization("Please enter the number of vertical squares. (5 to 12)")
        //check
        while (true) {
            if(Value.vertical == 0) {
                Value.vertical = initialization("Please enter the number of vertical squares. (5 to 12)")
            } else break
        }
        Value.width = initialization("Please enter the number of width squares. (5 to 12)")

        //check
        while (true) {
            if(Value.vertical == 0) {
                Value.vertical = initialization("Please enter the number of vertical squares. (5 to 12)")
            } else break
        }

        Mass_creation.create(Value.vertical, Value.width)
    }

    //Display a dialog for generating a square.
    private fun initialization(content: String?): Int {

        var number = -1

        // Input dialog display
        var resultsquare = Dialog.InputDialog(null, "Create square", content)

        if (resultsquare == null) exitProcess(0) // End of program, No further processing is performed.

        try {
            number = resultsquare.toInt()

            if (!(number >= 5 && number <= 12)) {
                Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "Please enter a number between 5 and 13")
                number = 0
            }

        } catch (e: NumberFormatException) {
            Dialog.AlertDialog(Alert.AlertType.WARNING, null, "Warning", "Please enter a number (5 to 12)")
            number = 0
        }

        if(Debug.developer) println(number)
        return number //number == 0, false
    }

    private inner class Tile(value: String) : StackPane() {
        private val text = Text()

        val isOpen: Boolean
            get() = text.opacity == 1.0

        init {
            val border = Rectangle(50.0, 50.0)
            border.fill = null
            border.stroke = Color.BLACK

            text.text = value
            text.font = Font.font(25.0)

            alignment = Pos.CENTER
            children.addAll(border, text)

            // onMouseClicked = EventHandler<MouseEvent>  { this.handleMouseClick(it) }
            onMouseClicked = EventHandler { this.handleMouseClick(it) }
        }

        fun handleMouseClick(event: MouseEvent) {
            if(Debug.developer) println(event)
        }
    }
}
