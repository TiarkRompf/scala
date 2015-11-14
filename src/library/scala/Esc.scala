package scala

class local[-T] extends scala.annotation.StaticAnnotation

trait `->`[-A,+B] extends Function1[A,B] {
  def apply(@local y: A): B
}


trait CanThrow

object ESC {
	def NO[T](x:T):T = x

	def THROW[T](x:T)(@local c: CanThrow) : T = x
	def TRY[T](f: CanThrow -> T): T = f(new CanThrow {})
}