import kotlinx.browser.document
import org.w3c.dom.HTMLInputElement

/** dayjs（コンストラクタあり）読み込み */
@JsModule("dayjs")
@JsNonModule
external fun dayjs(d: dynamic): dynamic

/** dayjs読み込み */
@JsModule("dayjs")
@JsNonModule
external fun dayjs(): dynamic

fun main() {

    // 残り日数表示要素
    val countdownTextElement = document.getElementById("countdown_text")!!
    // ボタン
    val calcButton = document.getElementById("calc_button")!!
    // 日付入力要素
    val dateInputElement = document.getElementById("date_input")!! as HTMLInputElement

    // ボタン押したとき
    calcButton.addEventListener("click", {
        // 日付取得
        val dateString = dateInputElement.value
        val countdown = dayjs(dateString).diff(dayjs(), "day") as Int
        countdownTextElement.textContent = "残り $countdown 日"
    })
}