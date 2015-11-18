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


/** A trait for all sequences which may possibly
 *  have their operations implemented in parallel.
 *
 *  @author Martin Odersky
 *  @author Aleksandar Prokopec
 *  @since 2.9
 */
trait GenSeq[-L, +A]
extends GenSeqLike[L, A, GenSeq[L, A]]
   with GenIterable[L, A]
   with Equals
   with GenericTraversableTemplate[L, A, GenSeq]
{
  def seq: Seq[L, A]
  override def companion: GenericCompanion[L, GenSeq] = GenSeq
}


object GenSeq extends GenTraversableFactory[GenSeq] {
  implicit def canBuildFrom[A] = ReusableCBF.asInstanceOf[GenericCanBuildFrom[A]]
  def newBuilder[A] = Seq.newBuilder
}
