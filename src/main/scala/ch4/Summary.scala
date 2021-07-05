import ChecksumAccumulator.calculate

object Summary {
    def main(args: Array[String]) = {
        for (arg <- args) {
            println(arg + ": " + calculate(arg))
        }
    }
}