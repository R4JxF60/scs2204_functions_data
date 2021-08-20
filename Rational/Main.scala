class Rational(x: Int, y: Int) {
    require(y>0)
    private def gcd(a: Int, b: Int): Int = if(b==0) a else this.gcd(b, a%b)
    private val g = this.gcd(x.abs, y.abs)
    val numer = x/this.g
    val denom = y/this.g

    def neg: Rational = new Rational(-this.numer, this.denom)
    def +(that: Rational): Rational = new Rational(this.numer*that.denom + that.numer*this.denom, this.denom*that.denom)
    def -(that: Rational): Rational = this+that.neg


    override def toString(): String = this.numer +"/"+ this.denom
}

object Main {
    def main(args: Array[String]): Unit = {
        println("Question 01");
        val r = new Rational(5, 10)
        println(r.neg.toString());

        println("Question 02");
        //x=3/4, y=5/8, z=2/7
        val x = new Rational(3, 4)
        val y = new Rational(5, 8)
        val z = new Rational(2, 7)
        val a1 = x-y-z
        println(a1.toString())
    }
}