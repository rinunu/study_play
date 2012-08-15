/**
 * Form の扱い
 */

package controllers

import play.api.mvc._
import play.api.data.format.Formats._
import play.api.data._
import play.api.data.Forms._

case class FooModel(s: String, i: Int)

object Forms extends Controller {
  /**
   * Form を定義します
   *
   * form は以下のことを行います
   * - validation
   * - データの保持de-tanohozi
   * - Map => Tuple/Case Class
   * - etc.
   */

  /**
   * tuple を使用した form
   *
   * Map => Tuple 変換できます
   *
   */
  val tupleForm = Form(
    tuple(
      "s" -> text,
      "i" -> number
    )
  )

  /**
   * case class を扱う form かな?
   */
  val mappingForm = Form(
    mapping(
      "form_s" -> text,
      "form_i" -> number
    )(FooModel.apply)(FooModel.unapply)
  )

  /**
   * 変換関数を自前で定義する場合
   */
  val mappingForm2 = Form(
    mapping(
      "form_s" -> text,
      "form_i" -> number,
      "accept" -> checked("Please accept the terms and conditions")
    )((s, i, _) => FooModel(s, i))
      ((model) => Some(model.s, model.i, false))
  )

  /**
   * Action の composition.
   */
  def postTuple() = Action {
    // val a = tupleForm.bindFromRequest().get
    Ok("")
  }
}
