
import ChecksumAccumulator.calculate

object SummaryApp extends App {

    for (season <- List("fall", "winter", "sprinig")) {
        println(season + ": " + calculate(season))
    }
}