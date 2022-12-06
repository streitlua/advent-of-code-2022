
def parse(s: String): (Array[Array[Char]], Array[Array[Int]]) =
  val groups: Array[Array[String]] = s.split("\n\n").map(_.split('\n'))
  val stacks: Array[Array[Char]] = groups(0).dropRight(1).map(_.grouped(4).toArray.map(g => g(1))).transpose.map(_.filter(_ != ' '))
  val instructions: Array[Array[Int]] = groups(1).map(_.split(" ").filter(_.forall(_.isDigit)).map(_.toInt).toArray)
  (stacks, instructions)

def printStacks(stacks: Array[Array[Char]]): Unit =
  val maxHeight = stacks.map(_.length).max
  val strings: Array[String] = (1 to maxHeight).map(i => stacks.map(s => if (i <= s.length) s"[${s(s.length - i)}]" else "   ").mkString(" ")).reverse.toArray
  strings.foreach(println)

def move(stacks: Array[Array[Char]], instructions: Array[Array[Int]], oneByOne: Boolean): Array[Array[Char]] =
  instructions.map(a => (a(0), a(1) - 1, a(2) - 1)).foreach { (n, from, to) =>
    stacks.update(to, (if (oneByOne) stacks(from).take(n).reverse else stacks(from).take(n)) ++ stacks(to))
    stacks.update(from, stacks(from).drop(n))
  }
  stacks

def parseAndMove(s: String, oneByOne: Boolean = false): String =
  val (stacks, instructions) = parse(s)
  val finalStack = move(stacks, instructions, oneByOne)
  finalStack.map(_.head).mkString
@main
def day5(): Unit =
  val input: String = "            [J] [Z] [G]            \n            [Z] [T] [S] [P] [R]    \n[R]         [Q] [V] [B] [G] [J]    \n[W] [W]     [N] [L] [V] [W] [C]    \n[F] [Q]     [T] [G] [C] [T] [T] [W]\n[H] [D] [W] [W] [H] [T] [R] [M] [B]\n[T] [G] [T] [R] [B] [P] [B] [G] [G]\n[S] [S] [B] [D] [F] [L] [Z] [N] [L]\n 1   2   3   4   5   6   7   8   9 \n\nmove 4 from 2 to 1\nmove 1 from 6 to 9\nmove 6 from 4 to 7\nmove 1 from 2 to 5\nmove 3 from 6 to 3\nmove 4 from 3 to 9\nmove 2 from 1 to 3\nmove 6 from 7 to 5\nmove 5 from 7 to 6\nmove 6 from 8 to 7\nmove 6 from 7 to 6\nmove 1 from 8 to 3\nmove 15 from 6 to 4\nmove 7 from 5 to 6\nmove 1 from 7 to 2\nmove 2 from 5 to 3\nmove 5 from 9 to 8\nmove 5 from 5 to 6\nmove 1 from 7 to 4\nmove 5 from 6 to 5\nmove 3 from 3 to 8\nmove 4 from 5 to 8\nmove 1 from 2 to 8\nmove 7 from 1 to 2\nmove 2 from 6 to 2\nmove 2 from 5 to 8\nmove 1 from 1 to 8\nmove 8 from 2 to 6\nmove 3 from 3 to 4\nmove 4 from 9 to 3\nmove 5 from 3 to 6\nmove 5 from 6 to 8\nmove 3 from 4 to 8\nmove 13 from 6 to 5\nmove 14 from 4 to 8\nmove 1 from 2 to 6\nmove 1 from 4 to 2\nmove 12 from 5 to 4\nmove 30 from 8 to 6\nmove 1 from 8 to 9\nmove 1 from 9 to 4\nmove 15 from 4 to 5\nmove 1 from 2 to 9\nmove 1 from 4 to 2\nmove 1 from 2 to 1\nmove 1 from 9 to 3\nmove 8 from 5 to 7\nmove 2 from 5 to 6\nmove 7 from 8 to 1\nmove 1 from 3 to 4\nmove 1 from 7 to 3\nmove 1 from 4 to 6\nmove 26 from 6 to 7\nmove 1 from 3 to 7\nmove 3 from 7 to 2\nmove 1 from 1 to 9\nmove 16 from 7 to 5\nmove 2 from 7 to 4\nmove 12 from 7 to 6\nmove 1 from 1 to 9\nmove 4 from 6 to 1\nmove 7 from 1 to 5\nmove 2 from 1 to 8\nmove 1 from 7 to 2\nmove 1 from 1 to 4\nmove 2 from 4 to 5\nmove 1 from 9 to 4\nmove 3 from 6 to 9\nmove 8 from 6 to 5\nmove 5 from 5 to 9\nmove 19 from 5 to 8\nmove 1 from 9 to 8\nmove 3 from 8 to 7\nmove 1 from 7 to 3\nmove 8 from 5 to 2\nmove 2 from 4 to 2\nmove 4 from 9 to 8\nmove 1 from 2 to 3\nmove 2 from 3 to 2\nmove 4 from 9 to 5\nmove 8 from 8 to 4\nmove 9 from 8 to 5\nmove 5 from 8 to 4\nmove 5 from 5 to 7\nmove 12 from 2 to 3\nmove 2 from 2 to 8\nmove 1 from 8 to 6\nmove 1 from 8 to 7\nmove 10 from 4 to 3\nmove 1 from 2 to 9\nmove 13 from 5 to 3\nmove 1 from 7 to 5\nmove 27 from 3 to 4\nmove 1 from 8 to 7\nmove 3 from 5 to 2\nmove 6 from 6 to 3\nmove 2 from 4 to 1\nmove 27 from 4 to 2\nmove 2 from 7 to 8\nmove 23 from 2 to 4\nmove 2 from 1 to 4\nmove 2 from 7 to 2\nmove 4 from 2 to 9\nmove 10 from 3 to 4\nmove 1 from 3 to 5\nmove 1 from 5 to 1\nmove 5 from 2 to 5\nmove 30 from 4 to 2\nmove 1 from 8 to 9\nmove 1 from 8 to 1\nmove 27 from 2 to 3\nmove 2 from 4 to 2\nmove 1 from 9 to 4\nmove 2 from 1 to 3\nmove 8 from 3 to 7\nmove 19 from 3 to 1\nmove 1 from 4 to 7\nmove 5 from 9 to 1\nmove 4 from 2 to 9\nmove 4 from 3 to 4\nmove 1 from 3 to 5\nmove 1 from 2 to 7\nmove 1 from 9 to 3\nmove 1 from 9 to 1\nmove 5 from 5 to 4\nmove 5 from 7 to 3\nmove 1 from 5 to 6\nmove 23 from 1 to 6\nmove 1 from 9 to 2\nmove 1 from 2 to 5\nmove 24 from 6 to 9\nmove 6 from 4 to 7\nmove 4 from 4 to 8\nmove 1 from 4 to 9\nmove 4 from 7 to 4\nmove 4 from 3 to 4\nmove 4 from 9 to 8\nmove 6 from 7 to 9\nmove 4 from 7 to 6\nmove 1 from 1 to 4\nmove 2 from 6 to 4\nmove 1 from 6 to 2\nmove 1 from 1 to 8\nmove 1 from 7 to 3\nmove 1 from 6 to 9\nmove 13 from 4 to 2\nmove 3 from 3 to 2\nmove 15 from 9 to 8\nmove 1 from 5 to 9\nmove 5 from 9 to 1\nmove 4 from 1 to 7\nmove 4 from 7 to 3\nmove 8 from 2 to 7\nmove 9 from 8 to 2\nmove 1 from 1 to 2\nmove 7 from 9 to 2\nmove 4 from 3 to 1\nmove 4 from 1 to 4\nmove 2 from 9 to 1\nmove 20 from 2 to 8\nmove 3 from 4 to 8\nmove 1 from 2 to 3\nmove 4 from 2 to 7\nmove 1 from 3 to 4\nmove 1 from 9 to 3\nmove 1 from 4 to 7\nmove 1 from 2 to 5\nmove 1 from 4 to 3\nmove 2 from 1 to 6\nmove 1 from 5 to 6\nmove 1 from 7 to 1\nmove 12 from 7 to 2\nmove 12 from 2 to 6\nmove 9 from 6 to 2\nmove 1 from 6 to 8\nmove 1 from 3 to 9\nmove 8 from 2 to 4\nmove 1 from 9 to 6\nmove 1 from 4 to 6\nmove 4 from 4 to 9\nmove 1 from 4 to 9\nmove 1 from 1 to 5\nmove 2 from 6 to 3\nmove 1 from 5 to 4\nmove 1 from 2 to 8\nmove 10 from 8 to 6\nmove 10 from 8 to 3\nmove 1 from 3 to 4\nmove 8 from 8 to 1\nmove 3 from 9 to 8\nmove 2 from 9 to 1\nmove 11 from 6 to 7\nmove 1 from 1 to 7\nmove 8 from 1 to 4\nmove 3 from 6 to 7\nmove 1 from 1 to 4\nmove 14 from 8 to 6\nmove 1 from 8 to 7\nmove 1 from 6 to 8\nmove 6 from 4 to 1\nmove 1 from 8 to 5\nmove 4 from 1 to 8\nmove 2 from 7 to 1\nmove 1 from 6 to 7\nmove 5 from 4 to 2\nmove 2 from 4 to 3\nmove 4 from 2 to 8\nmove 15 from 7 to 3\nmove 3 from 3 to 6\nmove 1 from 5 to 2\nmove 21 from 3 to 6\nmove 2 from 8 to 7\nmove 1 from 7 to 8\nmove 32 from 6 to 9\nmove 1 from 7 to 8\nmove 5 from 8 to 4\nmove 2 from 8 to 7\nmove 14 from 9 to 8\nmove 14 from 8 to 1\nmove 2 from 6 to 1\nmove 2 from 7 to 4\nmove 1 from 9 to 3\nmove 17 from 9 to 5\nmove 6 from 1 to 8\nmove 4 from 4 to 6\nmove 2 from 2 to 5\nmove 2 from 8 to 2\nmove 1 from 6 to 7\nmove 2 from 2 to 6\nmove 4 from 3 to 2\nmove 7 from 6 to 3\nmove 6 from 5 to 7\nmove 1 from 8 to 9\nmove 1 from 6 to 7\nmove 4 from 8 to 6\nmove 1 from 9 to 3\nmove 4 from 1 to 4\nmove 12 from 5 to 9\nmove 7 from 7 to 8\nmove 3 from 4 to 2\nmove 8 from 9 to 4\nmove 2 from 6 to 2\nmove 1 from 7 to 4\nmove 2 from 6 to 9\nmove 1 from 5 to 3\nmove 1 from 8 to 1\nmove 2 from 8 to 7\nmove 2 from 2 to 9\nmove 7 from 2 to 3\nmove 8 from 4 to 1\nmove 2 from 8 to 4\nmove 4 from 9 to 7\nmove 2 from 9 to 5\nmove 16 from 1 to 3\nmove 3 from 7 to 4\nmove 1 from 7 to 6\nmove 1 from 6 to 2\nmove 2 from 5 to 3\nmove 10 from 4 to 2\nmove 2 from 8 to 7\nmove 19 from 3 to 8\nmove 17 from 3 to 9\nmove 3 from 1 to 7\nmove 17 from 9 to 2\nmove 1 from 7 to 5\nmove 1 from 7 to 5\nmove 2 from 5 to 7\nmove 2 from 9 to 2\nmove 6 from 7 to 6\nmove 3 from 6 to 7\nmove 1 from 8 to 9\nmove 1 from 9 to 3\nmove 4 from 2 to 5\nmove 17 from 2 to 3\nmove 3 from 7 to 5\nmove 1 from 5 to 3\nmove 7 from 2 to 3\nmove 2 from 2 to 4\nmove 1 from 7 to 1\nmove 1 from 1 to 5\nmove 2 from 5 to 3\nmove 1 from 4 to 5\nmove 1 from 4 to 3\nmove 14 from 3 to 5\nmove 17 from 8 to 7\nmove 2 from 6 to 2\nmove 12 from 3 to 5\nmove 15 from 5 to 9\nmove 7 from 7 to 3\nmove 7 from 7 to 6\nmove 1 from 2 to 3\nmove 11 from 9 to 6\nmove 13 from 5 to 7\nmove 10 from 6 to 8\nmove 6 from 8 to 3\nmove 2 from 5 to 8\nmove 1 from 2 to 9\nmove 10 from 7 to 6\nmove 9 from 6 to 8\nmove 1 from 5 to 1\nmove 10 from 6 to 4\nmove 8 from 4 to 5\nmove 1 from 1 to 2\nmove 3 from 9 to 1\nmove 10 from 3 to 7\nmove 1 from 4 to 7\nmove 12 from 7 to 9\nmove 7 from 3 to 5\nmove 13 from 8 to 7\nmove 3 from 9 to 5\nmove 5 from 5 to 6\nmove 3 from 1 to 9\nmove 5 from 9 to 6\nmove 10 from 6 to 4\nmove 15 from 7 to 5\nmove 3 from 9 to 4\nmove 1 from 4 to 3\nmove 3 from 8 to 9\nmove 6 from 9 to 6\nmove 2 from 5 to 1\nmove 1 from 2 to 7\nmove 12 from 5 to 8\nmove 3 from 9 to 5\nmove 11 from 5 to 6\nmove 1 from 1 to 2\nmove 1 from 2 to 8\nmove 3 from 7 to 8\nmove 10 from 8 to 3\nmove 1 from 1 to 7\nmove 10 from 4 to 9\nmove 1 from 7 to 8\nmove 5 from 5 to 3\nmove 15 from 6 to 5\nmove 8 from 3 to 9\nmove 3 from 4 to 5\nmove 1 from 7 to 8\nmove 8 from 8 to 9\nmove 1 from 6 to 5\nmove 5 from 3 to 2\nmove 5 from 2 to 3\nmove 5 from 9 to 8\nmove 1 from 6 to 8\nmove 2 from 5 to 1\nmove 4 from 3 to 2\nmove 16 from 5 to 6\nmove 3 from 5 to 9\nmove 4 from 8 to 5\nmove 8 from 6 to 4\nmove 4 from 2 to 3\nmove 1 from 1 to 4\nmove 6 from 3 to 6\nmove 24 from 9 to 2\nmove 1 from 1 to 9\nmove 1 from 9 to 4\nmove 2 from 4 to 5\nmove 1 from 3 to 2\nmove 10 from 6 to 8\nmove 22 from 2 to 6\nmove 1 from 2 to 7\nmove 1 from 7 to 5\nmove 10 from 8 to 9\nmove 7 from 9 to 3\nmove 6 from 4 to 8\nmove 3 from 9 to 2\nmove 5 from 8 to 3\nmove 1 from 4 to 1\nmove 1 from 8 to 3\nmove 3 from 6 to 2\nmove 5 from 5 to 1\nmove 1 from 5 to 3\nmove 5 from 6 to 3\nmove 1 from 2 to 7\nmove 16 from 3 to 2\nmove 1 from 8 to 1\nmove 1 from 4 to 7\nmove 1 from 5 to 3\nmove 6 from 6 to 4\nmove 14 from 2 to 8\nmove 3 from 3 to 5\nmove 2 from 3 to 6\nmove 3 from 5 to 6\nmove 4 from 6 to 4\nmove 3 from 4 to 8\nmove 7 from 2 to 9\nmove 2 from 2 to 1\nmove 9 from 8 to 4\nmove 7 from 1 to 7\nmove 8 from 7 to 5\nmove 2 from 8 to 4\nmove 3 from 9 to 6\nmove 4 from 4 to 6\nmove 1 from 7 to 3\nmove 4 from 8 to 2\nmove 2 from 9 to 8\nmove 9 from 6 to 7\nmove 1 from 9 to 8\nmove 1 from 1 to 5\nmove 3 from 4 to 5\nmove 1 from 3 to 2\nmove 5 from 8 to 2\nmove 9 from 2 to 7\nmove 1 from 6 to 7\nmove 1 from 6 to 2\nmove 9 from 7 to 4\nmove 2 from 5 to 9\nmove 10 from 4 to 6\nmove 1 from 8 to 6\nmove 5 from 4 to 3\nmove 5 from 4 to 9\nmove 5 from 9 to 5\nmove 1 from 1 to 7\nmove 4 from 7 to 8\nmove 8 from 5 to 3\nmove 3 from 3 to 8\nmove 6 from 7 to 6\nmove 3 from 3 to 1\nmove 5 from 3 to 7\nmove 1 from 9 to 6\nmove 2 from 7 to 6\nmove 1 from 9 to 3\nmove 4 from 6 to 9\nmove 2 from 2 to 6\nmove 1 from 7 to 3\nmove 6 from 5 to 4\nmove 7 from 6 to 9\nmove 6 from 6 to 8\nmove 2 from 1 to 2\nmove 1 from 5 to 1\nmove 5 from 8 to 5\nmove 1 from 3 to 9\nmove 4 from 4 to 5\nmove 10 from 9 to 2\nmove 14 from 6 to 4\nmove 1 from 3 to 8\nmove 1 from 8 to 5\nmove 2 from 7 to 9\nmove 1 from 1 to 2\nmove 14 from 4 to 7\nmove 1 from 1 to 4\nmove 3 from 4 to 1\nmove 3 from 5 to 1\nmove 6 from 5 to 1\nmove 10 from 7 to 3\nmove 6 from 1 to 5\nmove 6 from 1 to 7\nmove 3 from 8 to 3\nmove 1 from 5 to 1\nmove 3 from 9 to 6\nmove 1 from 9 to 3\nmove 6 from 5 to 9\nmove 2 from 6 to 1\nmove 9 from 2 to 1\nmove 6 from 9 to 6\nmove 2 from 8 to 7\nmove 5 from 7 to 3\nmove 7 from 7 to 5\nmove 4 from 2 to 8\nmove 6 from 8 to 3\nmove 1 from 9 to 4\nmove 1 from 7 to 3\nmove 2 from 5 to 3\nmove 7 from 6 to 4\nmove 28 from 3 to 4\nmove 1 from 3 to 8\nmove 1 from 5 to 9\nmove 9 from 4 to 5\nmove 12 from 4 to 5\nmove 2 from 4 to 6\nmove 5 from 4 to 6\nmove 1 from 3 to 8\nmove 10 from 5 to 8\nmove 10 from 5 to 4\nmove 5 from 5 to 9\nmove 3 from 4 to 1\nmove 5 from 6 to 9\nmove 2 from 6 to 7\nmove 2 from 7 to 5\nmove 10 from 9 to 4\nmove 1 from 8 to 5\nmove 5 from 1 to 5\nmove 8 from 8 to 7\nmove 8 from 5 to 3\nmove 8 from 7 to 8\nmove 2 from 8 to 2\nmove 7 from 3 to 2\nmove 21 from 4 to 7\nmove 10 from 1 to 9\nmove 3 from 4 to 5\nmove 1 from 4 to 8\nmove 1 from 8 to 3\nmove 7 from 8 to 5\nmove 2 from 3 to 1\nmove 7 from 7 to 2\nmove 1 from 1 to 4\nmove 1 from 1 to 6\nmove 8 from 9 to 3\nmove 2 from 8 to 4\nmove 3 from 3 to 1\nmove 3 from 4 to 7\nmove 1 from 6 to 7\nmove 5 from 2 to 4\nmove 2 from 1 to 6"
  val example: String = "    [D]    \n[N] [C]    \n[Z] [M] [P]\n 1   2   3 \n\nmove 1 from 2 to 1\nmove 3 from 1 to 3\nmove 2 from 2 to 1\nmove 1 from 1 to 2"

  println(s"Part 1: ${parseAndMove(input, oneByOne = true)}")
  println(s"Part 2: ${parseAndMove(input, oneByOne = false)}")