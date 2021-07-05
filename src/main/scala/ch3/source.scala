import scala.io.Source

if (args.length <= 0) {
    Console.err.println("Please enter filename")
} else {
    for (line <- Source.fromFile(args(0)).getLines()) {
        println(line.length.toString + "\t" +line)
    }
}