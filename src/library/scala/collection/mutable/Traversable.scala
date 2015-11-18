/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */



package scala
package collection
package mutable

import generic._

/** A trait for traversable collections that can be mutated.
 *  $traversableInfo
 *  @define mutability mutable
 */
trait Traversable[-L, A] extends scala.collection.Traversable[L, A]
//                        with GenTraversable[L, A]
                        with GenericTraversableTemplate[L, A, Traversable]
                        with TraversableLike[L, A, Traversable[L, A]]
                        with Mutable {
  override def companion: GenericCompanion[L, Traversable] = Traversable
  override def seq: Traversable[L, A] = this
}

/** $factoryInfo
 *  The current default implementation of a $Coll is an `ArrayBuffer`.
 *  @define coll mutable traversable collection
 *  @define Coll `mutable.Traversable`
 */
object Traversable extends TraversableFactory[Traversable] {
  implicit def canBuildFrom[A]: CanBuildFrom[Coll, A, Traversable[Any, A]] = ReusableCBF.asInstanceOf[GenericCanBuildFrom[A]]
  def newBuilder[A]: Builder[A, Traversable[Any, A]] = new ArrayBuffer
}


