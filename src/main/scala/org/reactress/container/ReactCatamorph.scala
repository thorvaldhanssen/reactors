package org.reactress
package container






trait ReactCatamorph[@spec(Int, Long, Double) T, @spec(Int, Long, Double) S]
extends ReactContainer[S] with ReactContainer.Default[S] {

  def +=(v: S): Boolean

  def -=(v: S): Boolean

  def push(v: S): Boolean

  def signal: Signal[T]

}


object ReactCatamorph {

  def apply[@spec(Int, Long, Double) T](m: Monoid[T]) = new MonoidCatamorph[T, Signal[T]](_(), m.zero, m.operator)

  def apply[@spec(Int, Long, Double) T](cm: Commutoid[T]) = new CommuteCatamorph[T, Signal[T]](_(), cm.zero, cm.operator)

  def apply[@spec(Int, Long, Double) T](m: Abelian[T])(implicit a: Arrayable[T]) = new AbelianCatamorph[T, Signal[T]](_(), m.zero, m.operator, m.inverse)

}