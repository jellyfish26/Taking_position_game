import java.util.concurrent.FutureTask
import java.util.logging.ConsoleHandler
import java.util.logging.Level
import java.util.logging.Logger

object Log {
    private val logger = Logger.getLogger(Log::class.java.name)

    @JvmStatic
    fun main(args: String) {
        logger.level = Level.ALL
        logger.useParentHandlers = false
        val ch = ConsoleHandler()
        ch.level = Level.ALL
        logger.addHandler(ch)
        FutureTask<Any>({
            when(args) {
                //start application
                "launch" -> logger.log(Level.INFO, "Launch application")
                "make_square" -> logger.log(Level.INFO, "Make square")
            }
        }, null).run()
    }
}