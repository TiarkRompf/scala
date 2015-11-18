/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */



package scala
package collection
package immutable

import generic._
import mutable.Builder

/** A subtrait of `collection.LinearSeq` which represents sequences that
 *  are guaranteed immutable.
 *  $linearSeqInfo
 */
trait LinearSeq[-L, +A] extends Seq[L, A]
                            with scala.collection.LinearSeq[L, A]
                            with GenericTraversableTemplate[L, A, LinearSeq]
                            with LinearSeqLike[L, A, LinearSeq[L, A]] {
  override def companion: GenericCompanion[L, LinearSeq] = LinearSeq
  override def seq: LinearSeq[L, A] = this
}

/** $factoryInfo
 *  The current default implementation of a $Coll is a `List`.
 *  @define coll immutable linear sequence
 *  @define Coll `immutable.LinearSeq`
 */
object LinearSeq extends SeqFactory[LinearSeq] {
  implicit def canBuildFrom[A]: CanBuildFrom[Coll, A, LinearSeq[Any, A]] = ReusableCBF.asInstanceOf[GenericCanBuildFrom[A]]
  def newBuilder[A]: Builder[A, LinearSeq[Any, A]] = new mutable.ListBuffer
}
