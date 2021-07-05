//

class Rational(n: Int, d: Int) {
    require(d != 0)

    private val g = gcd(n.abs, d.abs)
    val numer: Int = n / g
    val denom: Int = d / g

    def this(n: Int) = this(n, 1)//auxiliary
    
    override def toString = s"$numer/$denom"
    
    def +(that: Rational): Rational = {
        new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
    }

    def + (i: Int): Rational = {
        new Rational(numer + i * denom, denom)
    }

    def - (that: Rational): Rational = {
        new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
    }

    def - (i: Int): Rational = {
        new Rational(numer - i * denom, denom);
    }


    def *(that: Rational): Rational = {
        new Rational(numer * that.numer , denom * that.denom)
    }

    def * (i: Int): Rational = {
        new Rational(numer * i, denom)
    }

    def / (that: Rational) : Rational = {
        new Rational(numer * that.denom, denom * that.numer)
    }

    def / (i: Int) : Rational = {
        new Rational(numer, denom * i)
    }

    def lessThan(that: Rational): Boolean = {
        this.numer * that.denom < that.numer * this.denom
    }

    def max(that: Rational): Rational = {
        if (this.lessThan(that)) that else this
    }

    private def gcd(a: Int, b: Int): Int = {
        if (b == 0) a else gcd(b, a % b)
    }
}


object RationalApp extends App {

    implicit def intToRational(i: Int) = new Rational(i)


    val r21 = new Rational(2,4)
    val r32 = new Rational(2,3)
    println(s"max(${r21}, ${r32}) is ${r21.max(r32)}")
    println(s"$r21 + $r32 = ${r21 + r32}")
    println(s"$r21 - $r32 = ${r21 - r32}")
    println(s"$r21 * $r32 = ${r21 * r32}")
    println(s"$r21 / $r32 = ${r21 / r32}")

    println(s"$r21 + 2 = ${r21 + 2}")
    println(s"$r21 - 2 = ${r21 - 2}")
    println(s"$r21 * 2 = ${r21 * 2}")
    println(s"$r21 / 2 = ${r21 / 2}")

    println(s"2 + $r21 = ${2 + r21}")
    println(s"2 - $r21 = ${2 - r21}")
    println(s"2 * $r21 = ${2 * r21}")
    println(s"2 / $r21 = ${2 / r21}")
}