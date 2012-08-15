/**
 * http://www.playframework.org/documentation/2.0.2/ScalaWebSockets
 *
 */

package controllers

import play.api.mvc.{WebSocket, Controller}
import play.api.libs.iteratee.{Enumerator, Iteratee}

object MyWebSocket {

  def index = WebSocket.using[String] { request =>
  //                          version
  // 入力を処理する iteratee, 出力を生成する enumerator を生成して返します
  //

  // Log events to the console
  // 終了時は EOF を受け取ります
    val in = Iteratee.foreach[String](println).mapDone { _ =>
      println("Disconnected")
    }

    // Send a single 'Hello!' message
    val out = Enumerator("Hello!")

    (in, out)
  }
}



