/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

package scala
package collection

import generic._
import mutable.Builder

/** A base trait for sequences.
 *  $seqInfo
 */
trait Seq[-L, +A] extends PartialFunction[Int, A]
                      with Iterable[L, A]
                      with GenSeq[L, A]
                      with GenericTraversableTemplate[L, A, Seq]
                      with SeqLike[L, A, Seq[L, A]] {
  override def companion: GenericCompanion[L, Seq] = Seq

  override def seq: Seq[L, A] = this
}

/** $factoryInfo
 *  The current default implementation of a $Coll is a `List`.
 *  @define coll sequence
 *  @define Coll `Seq`
 */
object Seq extends SeqFactory[Seq] {
  /** $genericCanBuildFromInfo */
  implicit def canBuildFrom[A]: CanBuildFrom[Coll, A, Seq[Any, A]] = ReusableCBF.asInstanceOf[GenericCanBuildFrom[A]]

  def newBuilder[A]: Builder[A, Seq[Any, A]] = immutable.Seq.newBuilder[A]
}

/** Explicit instantiation of the `Seq` trait to reduce class file size in subclasses. */
abstract class AbstractSeq[-L, +A] extends AbstractIterable[L, A] with Seq[L, A]
