package scala
package collection
import generic.CanBuildFrom

import scala.language.higherKinds

package object generic {
  type CanBuild[-Elem, +To] = CanBuildFrom[Nothing, Elem, To]

  @deprecated("use ClassTagTraversableFactory instead", "2.10.0")
  type ClassManifestTraversableFactory[CC[X] <: Traversable[L, X] with GenericClassManifestTraversableTemplate[X, CC]] = ClassTagTraversableFactory[CC]

  @deprecated("use GenericClassTagCompanion instead", "2.10.0")
  type GenericClassManifestCompanion[+CC[X] <: Traversable[L, X]] = GenericClassTagCompanion[CC]

  @deprecated("use GenericClassTagTraversableTemplate instead", "2.10.0")
  type GenericClassManifestTraversableTemplate[+A, +CC[X] <: Traversable[L, X]] = GenericClassTagTraversableTemplate[A, CC]
}
