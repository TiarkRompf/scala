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
import parallel.mutable.ParIterable

/** A base trait for iterable collections that can be mutated.
 *  $iterableInfo
 */
trait Iterable[-L, A] extends Traversable[L, A]
//                     with GenIterable[L, A]
                     with scala.collection.Iterable[L, A]
                     with GenericTraversableTemplate[L, A, Iterable]
                     with IterableLike[L, A, Iterable[L, A]]
                     with Parallelizable[A, ParIterable[A]]
{
  override def companion: GenericCompanion[L, Iterable] = Iterable
  protected[this] override def parCombiner = ParIterable.newCombiner[A] // if `mutable.IterableLike` gets introduced, please move this there!
  override def seq: Iterable[L, A] = this
}

/** $factoryInfo
 *  The current default implementation of a $Coll is an `ArrayBuffer`.
 *  @define coll mutable iterable collection
 *  @define Coll `mutable.Iterable`
 */
object Iterable extends TraversableFactory[Iterable] {
  implicit def canBuildFrom[A]: CanBuildFrom[Coll, A, Iterable[Any, A]] = ReusableCBF.asInstanceOf[GenericCanBuildFrom[A]]
  def newBuilder[A]: Builder[A, Iterable[Any, A]] = new ArrayBuffer
}

/** Explicit instantiation of the `Iterable` trait to reduce class file size in subclasses. */
abstract class AbstractIterable[-L, A] extends scala.collection.AbstractIterable[L, A] with Iterable[L, A]
