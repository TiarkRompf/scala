/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2006-2013, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */


package scala
package collection
package generic

import scala.language.higherKinds

abstract class OrderedTraversableFactory[CC[J, X] <: Traversable[Any, X] with GenericOrderedTraversableTemplate[X, CC]]
extends GenericOrderedCompanion[CC] {

  class GenericCanBuildFrom[A](implicit ord: Ordering[A]) extends CanBuildFrom[CC[/**/_, _], A, CC[/**/_, A]] {
    def apply(from: CC[/**/_, _]) = from.genericOrderedBuilder[A]
    def apply = newBuilder[A]
  }

}
