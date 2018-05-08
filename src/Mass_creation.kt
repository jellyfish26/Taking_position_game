import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import org.w3c.dom.Text
import java.awt.Button
import java.awt.Label
import java.util.*

object Mass_creation {

    //2-dimensional array
    var temp = Array(12, {Array(12,{0})})
    var point: Array<Array<Int>> = temp
    var temp2 = Array(12, { arrayOfNulls<Button>(12)})
    var btn: Array<Array<Button?>> = temp2
    var panel = GridPane()

    //create square
    fun create(vertical: Int, width: Int, this_stage: Stage?) {
        random(vertical, width)

        for(ver_length in 0..vertical) {
            for(wid_length in 0..width) {
                btn[ver_length][wid_length] = Button(point[ver_length][wid_length].toString())
                //panel.add(btn[ver_length][wid_length], ver_length, wid_length)
            }
        }

        val sc = Scene(panel,750.0,750.0)

        this_stage?.scene = sc
        this_stage?.show()
    }

    //odd even
    fun random(vertical: Int, width: Int) {
        for(ver_length in 0..((vertical / 2))) {
            for(wid_length in 0..((width / 2))) {
                point[ver_length][wid_length] = Random().nextInt(32) - 16

                // Line symmetry
                point[vertical - ver_length - 1][width - wid_length - 1] = point[ver_length][wid_length]
                point[vertical - ver_length - 1][wid_length] = point[ver_length][wid_length]
                point[ver_length][width - wid_length - 1] = point[ver_length][wid_length]
            }
        }

        // debug
        if(Debug.developer) {
            for(ver_length in 0..(vertical - 1)) {
                for(wid_length in 0..(width - 1)) {
                    print(point[ver_length][wid_length].toString() + " ")
                }
                println()
            }
        }
    }
}

