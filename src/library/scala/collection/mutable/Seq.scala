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


/** A subtrait of `collection.Seq` which represents sequences
 *  that can be mutated.
 *
 *  $seqInfo
 *
 *  The class adds an `update` method to `collection.Seq`.
 *
 *  @define Coll `mutable.Seq`
 *  @define coll mutable sequence
 */
trait Seq[-L, A] extends Iterable[L, A]
//                with GenSeq[L, A]
                with scala.collection.Seq[L, A]
                with GenericTraversableTemplate[L, A, Seq]
                with SeqLike[L, A, Seq[L, A]] {
  override def companion: GenericCompanion[L, Seq] = Seq
  override def seq: Seq[L, A] = this
}

/** $factoryInfo
 *  The current default implementation of a $Coll is an `ArrayBuffer`.
 *  @define coll mutable sequence
 *  @define Coll `mutable.Seq`
 */
object Seq extends SeqFactory[Seq] {
  implicit def canBuildFrom[A]: CanBuildFrom[Coll, A, Seq[Any, A]] = ReusableCBF.asInstanceOf[GenericCanBuildFrom[A]]
  def newBuilder[A]: Builder[A, Seq[Any, A]] = new ArrayBuffer
}

/** Explicit instantiation of the `Seq` trait to reduce class file size in subclasses. */
abstract class AbstractSeq[-L, A] extends scala.collection.AbstractSeq[L, A] with Seq[L, A]
