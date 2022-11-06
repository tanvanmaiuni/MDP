package com.mdp.mystoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mdp.mystoreapp.model.Product
import kotlinx.android.synthetic.main.activity_list_product.*

class ListProductActivity : AppCompatActivity() {
    private val listProduct = arrayListOf(
        Product("Lenovo Ideapad 3i 14\" FHD", 279.0, "Black & White", R.drawable.electronic_1, "125496557", """
            Engineered for long-lasting performance, the Lenovo IdeaPad 3i delivers powerful performance with an Intel Core i3 Processor and Integrated Intel UHD Graphics. A narrow bezel on 2 sides makes for a clean design, and larger display giving you more viewing area and less clutter. Keep your privacy intact with a physical shutter for your webcam bringing you peace of mind when you need it. It's a laptop that's perfect for your everyday tasks, with features that you can depend on.
            
            14.0" (FHD) 1920 x 1080 LCD Display
            3.0 GHz Intel Core i3-1115G4 Dual-Core
            4GB Onboard DDR4 RAM
            128GB M.2 NVMe SSD
            4-in-1 Card Reader
        """.trimIndent()),
        Product("HP 14\" Laptop", 429.0, "White", R.drawable.electronic_2, "222768279", """
            Do more from anywhere. All-day long. Designed to keep you productive and entertained from anywhere, the HP 14 inch diagonal laptop combines long lasting battery life with a thin and portable, micro edge bezel design. Take it anywhere. See more. With its thin and light design, 6.5 mm micro-edge bezel, display, and 79% screen to body ratio take this PC anywhere and see and do more. Reliable performance for every day: Powerful enough for your busiest days, this PC features an Intel® processor and a solid state drive for speedy boot-up and snappier overall experience. Powered up and productive. All day long. With a long battery life and fast-charge technology, this laptop lets you work, watch, and stay connected all day. Integrated precision touchpad with multi-touch support speeds up both navigation and productivity.

            HP 14", intel Core i5-1137G5
            8GB RAM
            256GB SSD, Silver
            Windows 11
            14-dq2078wm
        """.trimIndent()),
        Product("Apple MacBook Air Laptop, 11.6\"", 219.0, "White", R.drawable.electronic_3, "128308256", """
            This Apple MacBook Air comes in Silver. Powered by Intel Core i5 and Intel HD Graphics 6000. Solid State Drive (SSD) capacity of 128GB with 4GB of RAM. This device has been tested to be in great working condition. It will show signs of use and cosmetic blemishes which may included some scratched/dings, all of which do not affect the usability of this device.

            128GB Solid State Drive (SSD) capacity
            4GB RAM
            Intel Core i5 processor 1.6GHz
            Intel HD Graphics 6000 that shares system memory
            backlit full-size keyboard
        """.trimIndent()),
        Product("MSI GF63 Thin 11SC-693 15.6\" Gaming Laptop", 599.0, "Black & Red", R.drawable.electronic_4, "172321853", """
            MSI GF63 Thin 11SC-693 15.6" Gaming Laptop, Intel Core i5-11400H, NVIDIA GeForce GTX 1650, 8GB Memory, 256GB NVMe SSD, Windows 11
            
            Model #: GF63 Thin 11SC-693
            Battery Type: Lithium-Polymer
            Graphic Card: NVIDIA GeForce GTX 1650 Laptop GPU
            Processor: Intel Core i5-11400H
            Screen: 15.6" 60Hz FHD Thin Bezel IPS
            Color: Black
            Memory: 8GB DDR4
            Storage: 256GB NVMe SSD
            Battery Life: 51Wh
            Weight: 4.1 lbs
        """.trimIndent()),
        Product("Gateway 15.6\" Ultra Slim Notebook, FHD", 249.0, "Navi", R.drawable.electronic_5, "902605940", """
            The notebook is equipped with Windows 11 Home to make sure you have exactly what you need to get all of your tasks done. Only weighing 4 lbs., the notebook features a front facing camera, 2 built in stereo speakers, a built- in microphone with 4.2 Bluetooth, and a precision touchpad. This notebook is packed with up to 10 hours of battery life, so no more needing to panic about plugging your computer in to keep it going.

            Key Features:

            Windows 11 Home
            AMD Ryzen™ 7 3700U Processor with Radeon™ RX Vega 10 Graphics (2.3GHz base, Up to 4.0GHz)
            15.6” IPS FHD Display, (1920 x 1080)
            Fingerprint Scanner
            Precision Touchpad
            Tuned by THX™ Audio
            512 GB Solid State Drive
            8 GB Memory (RAM)
            2.0 MP Front-Facing Camera
            Up to 10 hours of battery life
            Micro SD Slot (Up to 512 GB) x 1
            HDMI Output x 1
            USB Type-C x 1
            USB 3.0 x 2
            Built-in Stereo Speakers x 2
            Bluetooth 4.2
            Built-in Microphone
            Product Dimensions: 14.1” x 9.4” x 0.78”
            Weight: 4.0 lbs.
        """.trimIndent())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_product)
        listProductRecyclerView.layoutManager = LinearLayoutManager(this)
        listProductRecyclerView.adapter = MyAdapter(this, listProduct)
    }
}