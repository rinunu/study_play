package controllers

import play.api.mvc._
import play.api.libs.json.Json

/**
 * 基本的なコントローラ
 */
object Basic extends Controller {

  // basic concept.
  //
  // Action: Request[A] => Result
  //
  // Call: HTTP Request(method and URL)
  //
  // Content: HTTP Response with content type
  //
  // Controller: Action generator.
  //
  // Flash: Short-lived HTTP data scope.
  //
  // Result: Action result. used to generate an HTTP response.
  //   - SimpleResult: header, enumerator
  //
  // Session:
  //

  /**
   * URL に含まれる id を受け取ります。
   */
  def details(id: String) = Action {
    // template はただのメソッドです。
    // val html = views.html.
    NotImplemented
  }

  /**
   * page は routes にてデフォルト値を設定されている
   *
   * == binder ==
   * page は String から binder によって Int に変換されます(binding)。
   */
  def list(page: Int) = Action {
    NotImplemented
  }

  def delete(id: String) = Action {


    // reverse routing
    val call = routes.Basic.list()

    // redirect
    Redirect(call)
  }

  /**
   * Action の composition.
   */
  def composition() {
  }

  def json() = Action {
    val map = Map("property0" -> "value0")
    val json = Json.toJson(map)
    Ok(json)
  }

  // TODO JSON を受け取るには?

  // シンプルにステータスコードだけを返す場合
  def status = Action {
    val res = NotImplemented // とか
    val res2 = NotFound // とか
    res
  }

  // ステータスとヘッダーを指定する場合
  def statusWithHeader = Action {
    val res = Ok("OK").withHeaders(LOCATION -> "")

    // Content-Type はショートカットもある
    val res2 = Ok("OK").as("application/json")

    res2
  }
}
