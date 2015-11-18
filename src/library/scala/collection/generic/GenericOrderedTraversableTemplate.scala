/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2003-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */



package scala
package collection
package generic

import mutable.Builder
import scala.annotation.unchecked.uncheckedVariance
import scala.language.higherKinds

/** This trait represents collections classes which require
 *  ordered element types.
 *
 *  @author Aleksandar Prokopec
 */
trait GenericOrderedTraversableTemplate[+A, +CC[J, X] <: Traversable[Any, X]] extends HasNewBuilder[A, CC[J, A] @uncheckedVariance] {
  implicit protected[this] val ord: Ordering[A]
  def orderedCompanion: GenericOrderedCompanion[CC]
  def genericOrderedBuilder[B](implicit ord: Ordering[B]): Builder[B, CC[/**/_, B]] = orderedCompanion.newBuilder[B]
}

