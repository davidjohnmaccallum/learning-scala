import java.util.Date

"Function types and values"
"========================="

def double(x: Int) = x * 2
double(5)

val myDouble: Int => Int = double
myDouble(4)

val myDoubleCopy = myDouble
myDoubleCopy(3)

def max(a:Int, b:Int) = if (a>b) a else b
max(1,2)

val myMax: (Int, Int) => Int = max
max(2,3)

def logStart() = "=" * 50 + "\nApplication starting\n" + "=" * 50
logStart()

val start: () => String = logStart
start()

"The wildcard operator _"
"-----------------------"

// val anotherDouble = double // Error: Missing arguments for method double(Int)
val anotherDouble = double _
// The underscore serves as a placeholder for a future invocation of the function.
anotherDouble(2)

"Higher order functions"
"======================"

def safeStringOp(s: String, f:String => String) = if (s!=null) f(s) else s
safeStringOp("Hello", (s: String) => s.reverse)
safeStringOp(null, (s: String) => s.reverse)
safeStringOp("Hello", _.reverse) // Placeholder syntax

"Function literals"
"================="

val doubler = (x:Int) => x * 2
//val doubler: Int => Int = _ * 2 // Placeholder syntax
doubler(2)

val greeter = (name:String) => s"Hello, $name"
greeter("David")

"Placeholder syntax"
"=================="

List("David", "Rowan", "Hilgard", "Louis", "Aphiwe", "Jacques").map(_.toUpperCase)

"Partial functions"
"================="

// You’ll find partial functions more useful when working with collections and pattern matching. For example, you can “collect” every item in a collection that is accepted by a given partial function.

val statusHandler: Int => String = {
  case 200 => "Ok"
  case 400 => "Client error"
  case 500 => "Server error"
}
statusHandler(400)

"Invoking higher-order functions with function literal blocks"
"============================================================"

val uuid = java.util.UUID.randomUUID.toString

val timedUUID = safeStringOp(uuid, { s =>
  val now = new Date().getTime
  val timed = s.take(24) + now
  timed
})

def safeStringOp1(s: String)(f: String => String) = {
  if (s!=null) f(s) else null
}

val timedUUID = safeStringOp1(uuid) { s =>
  val now = new Date().getTime
  val timed = s.take(24) + now
  timed
}

"Exercises"
"========="

// Write a function literal that takes two integers and returns the higher number.

val max1 = (a:Int, b:Int) => if (a>b) a else b
max1(1,2)

// Then write a higher-order function that takes a 3-sized tuple of integers plus
// this function literal, and uses it to return the maximum value in the tuple.

def f(nums:(Int,Int,Int), comparitor: (Int,Int) => Int): Int = {
  val a = comparitor(nums._1, nums._2)
  comparitor(a, nums._3)
}
f((1,2,3), max1)

// The library function util.Random.nextInt returns a random integer. Use it to invoke
// the “max” function with two random integers plus a function that returns the larger
// of two given integers. Do the same with a function that returns the smaller of two
// given integers, and then a function that returns the second integer every time.
