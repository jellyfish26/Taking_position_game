import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

//gui class
class App : Application() {

    //start GUI
    override fun start(primaryStage: Stage?) {
        //title
        primaryStage?.title = "Taking position game"

        //scene
        primaryStage?.scene = Scene(FXMLLoader.load<Parent>(this.javaClass.getResource("App.fxml")))

        //show gui
        primaryStage?.show()
    }
}