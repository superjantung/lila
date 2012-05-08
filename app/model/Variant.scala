package lila
package model

sealed abstract class Variant(val id: Int) {

  lazy val name = toString.toLowerCase

  def standard = this == Standard
}

case object Standard extends Variant(1)
case object Chess960 extends Variant(2)

object Variant {

  val all = List(Standard, Chess960)

  val byId = all map { v ⇒ (v.id, v) } toMap

  def apply(id: Int): Option[Variant] = byId get id
}
