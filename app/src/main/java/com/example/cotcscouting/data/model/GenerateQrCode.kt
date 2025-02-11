//import com.g0dkar.qrcode.QRCode
import android.graphics.Bitmap
import qrcode.*
import qrcode.color.Colors
import qrcode.render.QRCodeGraphics
import java.io.FileOutputStream

fun generateQRCode(content: String): String {
    val helloWorld = QRCode.ofSquares()
        .withColor(Colors.DEEP_SKY_BLUE) // Default is Colors.BLACK
        .withSize(10) // Default is 25
        .build("Hello world!")

    // By default, QRCodes are rendered as PNGs.
    val pngBytes = helloWorld.render()

    return pngBytes.toString()
//    FileOutputStream("hello-world.png").use { it.write(pngBytes) }


}
