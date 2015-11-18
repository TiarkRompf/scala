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
import parallel.immutable.ParSeq

/** A subtrait of `collection.Seq` which represents sequences
 *  that are guaranteed immutable.
 *
 *  $seqInfo
 *  @define Coll `immutable.Seq`
 *  @define coll immutable sequence
 */
trait Seq[-L, +A] extends Iterable[L, A]
//                      with GenSeq[L, A]
                      with scala.collection.Seq[L, A]
                      with GenericTraversableTemplate[L, A, Seq]
                      with SeqLike[L, A, Seq[L, A]]
                      with Parallelizable[A, ParSeq[A]]
{
  override def companion: GenericCompanion[L, Seq] = Seq
  override def toSeq: Seq[L, A] = this
  override def seq: Seq[L, A] = this
  protected[this] override def parCombiner = ParSeq.newCombiner[A] // if `immutable.SeqLike` gets introduced, please move this there!
}

/** $factoryInfo
 *  @define Coll `immutable.Seq`
 *  @define coll immutable sequence
 */
object Seq extends SeqFactory[Seq] {
  /** genericCanBuildFromInfo */
  implicit def canBuildFrom[A]: CanBuildFrom[Coll, A, Seq[Any, A]] = ReusableCBF.asInstanceOf[GenericCanBuildFrom[A]]
  def newBuilder[A]: Builder[A, Seq[Any, A]] = new mutable.ListBuffer
}
